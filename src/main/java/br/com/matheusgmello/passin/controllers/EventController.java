package br.com.matheusgmello.passin.controllers;


import br.com.matheusgmello.passin.dto.attendee.AttendeesListResponseDTO;
import br.com.matheusgmello.passin.dto.event.EventIdDTO;
import br.com.matheusgmello.passin.dto.event.EventRequestDTO;
import br.com.matheusgmello.passin.dto.event.EventResponseDTO;
import br.com.matheusgmello.passin.services.AttendeeService;
import br.com.matheusgmello.passin.services.EventService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id){
        EventResponseDTO event = this.eventService.getEventDetail(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder){
        EventIdDTO eventIdDTO = this.eventService.createEvent(body);
        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventIdDTO.eventId()).toUri();
        return ResponseEntity.created(uri).body(eventIdDTO);

    }

    @GetMapping("/attendees/{id}")
    public ResponseEntity<AttendeesListResponseDTO> getEventAttendees(@PathVariable String id){
        AttendeesListResponseDTO attendeesListResponseDTO = this.attendeeService.getEventsAttendee(id);
        return ResponseEntity.ok(attendeesListResponseDTO);
    }
}
