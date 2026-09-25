package com.ticketsale.dasticket.service;

import com.ticketsale.dasticket.dto.CreateEventRequest;
import com.ticketsale.dasticket.dto.EventResponse;
import com.ticketsale.dasticket.entity.Event;
import com.ticketsale.dasticket.exception.EventNotFoundException;
import com.ticketsale.dasticket.repository.EventRepository;
import lombok.RequiredArgsConstructor;
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

    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public EventResponse getEvent(UUID id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        return mapToResponse(event);
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
