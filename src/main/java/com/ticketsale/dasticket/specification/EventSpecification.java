package com.ticketsale.dasticket.specification;

import com.ticketsale.dasticket.entity.Event;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventSpecification {

    public static Specification<Event> hasCity(String city) {
        if(city == null || city.isBlank()) {
            return null;
        }
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("city")),
                        "%" + city.toLowerCase() + "%"
                );
    }

    public static Specification<Event> hasArtist(String artist) {
        if(artist == null || artist.isBlank()) {
            return null;
        }
        return (root,query,criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("artist")),
                        "%" + artist.toLowerCase() + "%"
                );
    }

    public static Specification<Event> hasVenue(String venue) {
        if(venue == null || venue.isBlank()) {
            return null;
        }
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("venue")),
                        "%" + venue.toLowerCase() + "%"
                );
    }

    public static Specification<Event> hasMinPrice(BigDecimal minPrice) {
        if(minPrice == null) {
            return  null;
        }
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"),minPrice));
    }

    public static Specification<Event> hasMaxPrice(BigDecimal maxPrice) {
        if(maxPrice == null) {
            return null;
        }
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"),maxPrice));
    }

    public static Specification<Event> hasFromDate (LocalDateTime fromTime) {
        if(fromTime == null){
            return null;
        }
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("eventDate"), fromTime));
    }

    public static Specification<Event> hasToDate(LocalDateTime toTime) {
        if(toTime == null) {
            return  null;
        }
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("eventDate"),toTime));
    }
}
