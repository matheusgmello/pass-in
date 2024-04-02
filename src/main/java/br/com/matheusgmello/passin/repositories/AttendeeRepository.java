package br.com.matheusgmello.passin.repositories;

import br.com.matheusgmello.passin.domain.attendee.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository extends JpaRepository<Attendee, String> {
}
