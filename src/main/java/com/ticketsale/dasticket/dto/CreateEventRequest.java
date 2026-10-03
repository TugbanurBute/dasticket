package com.ticketsale.dasticket.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateEventRequest {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @NotBlank(message = "Artist cannot be empty")
    private String artist;

    @NotBlank(message = "Venue cannot be empty")
    private String venue;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @Future
    private LocalDateTime eventDate;

    @Positive
    private BigDecimal price;

    @Positive
    private Integer availableTickets;
}
