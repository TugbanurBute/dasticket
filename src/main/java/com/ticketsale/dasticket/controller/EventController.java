package com.ticketsale.dasticket.controller;

import com.ticketsale.dasticket.dto.CreateEventRequest;
import com.ticketsale.dasticket.dto.EventFilterRequest;
import com.ticketsale.dasticket.dto.EventResponse;
import com.ticketsale.dasticket.dto.UpdateEventRequest;
import com.ticketsale.dasticket.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public EventResponse createEvent(
            @Valid @RequestBody CreateEventRequest request) {
        return eventService.createEvent(request);
    }

    @GetMapping
    public Page<EventResponse> getAllEvents(
            EventFilterRequest filter,
            Pageable pageable) {
        return eventService.filterEvents(filter,pageable);
    }

    @GetMapping("/{id}")
    public EventResponse getEvent(@PathVariable UUID id){
        return eventService.getEvent(id);
    }

    @PutMapping("/{id}")
    public EventResponse updateEvent(@PathVariable UUID id,
                                     @RequestBody UpdateEventRequest updateEventRequest){
        return eventService.updateEvent(updateEventRequest,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable UUID id){
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<EventResponse> searchEvents(
            @RequestParam String keyword) {
        return eventService.searchEvents(keyword);
    }
}
