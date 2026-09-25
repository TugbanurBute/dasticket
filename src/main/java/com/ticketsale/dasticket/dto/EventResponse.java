package com.ticketsale.dasticket.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class EventResponse {

    private UUID id;

    private String title;

    private String description;

    private String artist;

    private String venue;

    private String city;

    private LocalDateTime eventDate;

    private BigDecimal price;

    private Integer availableTickets;
}
