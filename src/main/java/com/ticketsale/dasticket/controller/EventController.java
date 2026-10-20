package com.ticketsale.dasticket.controller;

import com.ticketsale.dasticket.dto.CreateEventRequest;
import com.ticketsale.dasticket.dto.EventFilterRequest;
import com.ticketsale.dasticket.dto.EventResponse;
import com.ticketsale.dasticket.dto.UpdateEventRequest;
import com.ticketsale.dasticket.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Events",
        description = "Event management and search operations"
)
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @Operation(
            summary = "Create an event",
            description = "Creates a new event using the provided information."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Event created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid event data")
    })
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse createEvent(
            @Valid @RequestBody CreateEventRequest request) {
        return eventService.createEvent(request);
    }

    @GetMapping
    @Operation(
            summary = "Get all events",
            description = "Returns paginated events with optional filtering."
    )
    public Page<EventResponse> getAllEvents(
            @ParameterObject @ModelAttribute EventFilterRequest filter,
            @ParameterObject Pageable pageable) {

        return eventService.filterEvents(filter, pageable);
    }

    @Operation(summary = "Get event by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Event found"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    @GetMapping("/{id}")
    public EventResponse getEvent(@PathVariable UUID id){
        return eventService.getEvent(id);
    }

    @Operation(
            summary = "Update an event",
            description = "Updates an existing event using its ID."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Event updated"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    @PutMapping("/{id}")
    public EventResponse updateEvent(@PathVariable UUID id,
                                     @Valid @RequestBody UpdateEventRequest updateEventRequest){
        return eventService.updateEvent(updateEventRequest,id);
    }

    @Operation(summary = "Delete an event")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Event deleted"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable UUID id){
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Search events",
            description = "Searches events using a keyword."
    )
    @GetMapping("/search")
    public List<EventResponse> searchEvents(
            @RequestParam String keyword) {
        return eventService.searchEvents(keyword);
    }
}
