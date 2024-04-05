package br.com.matheusgmello.passin.dto.event;

public record EventRequestDTO(
    String title,
    String details,
    Integer maximumAttendees
) {
    
}