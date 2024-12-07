package gm.contactos.servicio;

import gm.contactos.modelo.Ticket;

import java.util.List;

public interface ITicketServicio {

    public List<Ticket> listarTicket();

    public Ticket buscarTicketPorId (Integer idTicket);

    public void gurdarTicket(Ticket ticket);

    public void eliminarTicket(Ticket ticket);

}
