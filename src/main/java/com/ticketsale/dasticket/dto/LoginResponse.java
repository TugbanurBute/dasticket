package com.ticketsale.dasticket.dto;

public record LoginResponse(
        String accessToken,
        String tokenType)
{}
