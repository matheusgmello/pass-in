package br.com.matheusgmello.passin.repositories;

import br.com.matheusgmello.passin.domain.event.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String>{

}