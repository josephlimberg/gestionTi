package gm.contactos.controlador;
import gm.contactos.modelo.Ticket;
import gm.contactos.servicio.TicketServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TicketControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(TicketControlador.class);

    @Autowired
    TicketServicio ticketServicio;

    @GetMapping("/agregarTicket")
    public String mostrarAgregarTicket(){
        return "agregarTicket"; //agregarTicket.html
    }
    @PostMapping("/agregarTicket")
    public String agregarTicket(@ModelAttribute("ticketForma") Ticket ticket){
        logger.info("Ticket a agregar: "+ ticket);
        ticketServicio.gurdarTicket(ticket);
        return "redirect:/"; // redirigiremos al controlador el path "/"
    }
    @GetMapping("/editarTicket/{idTicket}")
    public String mostrarEditarTicket(@PathVariable(value = "idTicket")int idTicket,ModelMap modelo){
        Ticket ticket = ticketServicio.buscarTicketPorId(idTicket);
        logger.info("Ticket a editar (mostrar): "+ticket);
        modelo.put("ticket", ticket);
        return "editarTicket"; //editar.html
    }
    @PostMapping("/editarTicket")
    public String editarTicket(@ModelAttribute("ticket") Ticket ticket){
        logger.info("Ticket a guardar (editar): "+ticket);
        ticketServicio.gurdarTicket(ticket);
        return "redirect:/";  // redirigiremos al controlador el path "/"
    }
    @GetMapping("/eliminarTicket/{id}")
    public String eliminarTicket(@PathVariable(value = "id") int idTicket){
        Ticket ticket = new Ticket();
        ticket.setIdTicket(idTicket);
        ticketServicio.eliminarTicket(ticket);
        return "redirect:/";  // redirigiremos al controlador el path "/"
    }

}
