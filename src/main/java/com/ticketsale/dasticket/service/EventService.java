package com.ticketsale.dasticket.service;

import com.ticketsale.dasticket.dto.CreateEventRequest;
import com.ticketsale.dasticket.dto.EventResponse;
import com.ticketsale.dasticket.dto.UpdateEventRequest;
import com.ticketsale.dasticket.entity.Event;
import com.ticketsale.dasticket.exception.EventNotFoundException;
import com.ticketsale.dasticket.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public EventResponse createEvent(CreateEventRequest request) {

        Event event = Event.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .artist(request.getArtist())
                .venue(request.getVenue())
                .city(request.getCity())
                .eventDate(request.getEventDate())
                .price(request.getPrice())
                .availableTickets(request.getAvailableTickets())
                .build();

        Event saved = eventRepository.save(event);

        return mapToResponse(saved);
    }

    public EventResponse updateEvent(UpdateEventRequest request, UUID id) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));

        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setArtist(request.getArtist());
        event.setVenue(request.getVenue());
        event.setCity(request.getCity());
        event.setEventDate(request.getEventDate());
        event.setPrice(request.getPrice());
        event.setAvailableTickets(request.getAvailableTickets());
        Event updatedEvent = eventRepository.save(event);

        return mapToResponse(updatedEvent);
    }

    public Page<EventResponse> getAllEvents(Pageable pageable) {
       Page<Event> events = eventRepository.findAll(pageable);
        return events.map(this::mapToResponse);
    }

    public EventResponse getEvent(UUID id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        return mapToResponse(event);
    }

    public void deleteEvent(UUID id){
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        eventRepository.delete(event);
    }

    public List<EventResponse> searchEvents(String keyword){
        List<Event> events = eventRepository.findByTitleContainingIgnoreCaseOrArtistContainingIgnoreCaseOrVenueContainingIgnoreCaseOrCityContainingIgnoreCase(
                keyword,
                keyword,
                keyword,
                keyword
        );
        return events.stream().map(this::mapToResponse).toList();
    }

    private EventResponse mapToResponse(Event event) {

        return EventResponse.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .artist(event.getArtist())
                .venue(event.getVenue())
                .city(event.getCity())
                .eventDate(event.getEventDate())
                .price(event.getPrice())
                .availableTickets(event.getAvailableTickets())
                .build();
    }
}
