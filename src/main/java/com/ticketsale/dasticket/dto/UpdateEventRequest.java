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
public class UpdateEventRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String artist;

    @NotBlank
    private String venue;

    @NotBlank
    private String city;

    @Future
    private LocalDateTime eventDate;

    @Positive
    private BigDecimal price;

    @Positive
    private Integer availableTickets;
}
