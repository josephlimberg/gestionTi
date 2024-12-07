package gm.contactos.repositorio;

import gm.contactos.modelo.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepositorio extends JpaRepository<Ticket, Integer> {
}
