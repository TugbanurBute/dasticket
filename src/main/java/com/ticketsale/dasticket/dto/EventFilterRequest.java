package com.ticketsale.dasticket.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventFilterRequest {

    private String city;
    private String artist;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private LocalDateTime fromDate;
    private LocalDateTime toDate;
    private String venue;
}
