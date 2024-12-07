package gm.contactos.servicio;

import gm.contactos.modelo.Ticket;
import gm.contactos.repositorio.TicketRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TicketServicio implements ITicketServicio{

    @Autowired
    private TicketRepositorio ticketRepositorio;

    @Override
    public List<Ticket> listarTicket() {
        return ticketRepositorio.findAll();
    }

    @Override
    public Ticket buscarTicketPorId(Integer idTicket) {
        Ticket ticket = ticketRepositorio.findById(idTicket).orElse(null);
        return ticket;
    }

    @Override
    public void gurdarTicket(Ticket ticket) {
        ticketRepositorio.save(ticket);

    }

    @Override
    public void eliminarTicket(Ticket ticket) {
        ticketRepositorio.delete(ticket);
    }
}

