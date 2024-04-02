package br.com.matheusgmello.passin.services;

import br.com.matheusgmello.passin.domain.attendee.Attendee;
import br.com.matheusgmello.passin.domain.event.Event;
import br.com.matheusgmello.passin.dto.event.EventResponseDTO;
import br.com.matheusgmello.passin.repositories.AttendeeRepository;
import br.com.matheusgmello.passin.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    public EventResponseDTO getEventDetail(String eventId){
        Event event = this.eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found with ID:" + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);
        return new EventResponseDTO(event, attendeeList.size());
    }
}
