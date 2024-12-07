package gm.contactos.controlador;
import gm.contactos.modelo.Contacto;
import gm.contactos.modelo.Ticket;
import gm.contactos.servicio.ContactoServicio;
import gm.contactos.servicio.ITicketServicio;
import gm.contactos.servicio.TicketServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Sistema de Contactos Thymeleaf y Spring boot

//http://localhost:8080/

@Controller
public class ContactoControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(ContactoControlador.class);

    @Autowired
    ContactoServicio contactoServicio;

    @Autowired
    TicketServicio ticketServicio;

    @GetMapping("/")
    public String iniciar(ModelMap modelo){
        List<Contacto> contactos = contactoServicio.listarContacto();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.put("contactos", contactos);

        List<Ticket> tickets = ticketServicio.listarTicket();
        tickets.forEach((ticket) -> logger.info(ticket.toString()));
        modelo.put("tickets", tickets);

        return "index";//index.html
    }

    @GetMapping("/agregar")
    public String mostrarAgregar(){
        return "agregar"; //agregar.html
    }
    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto){
        logger.info("Contacto a agregar: "+ contacto);
        contactoServicio.gurdarContacto(contacto);
        return "redirect:/"; // redirigiremos al controlador el path "/"
    }
    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id")int idContacto,ModelMap modelo){
        Contacto contacto = contactoServicio.buscarContactoPorId(idContacto);
        logger.info("Contacto a editar (mostrar): "+contacto);
        modelo.put("contacto", contacto);
        return "editar"; //editar.html
    }
    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto") Contacto contacto){
        logger.info("Contacto a guardar (editar): "+contacto);
        contactoServicio.gurdarContacto(contacto);
        return "redirect:/";  // redirigiremos al controlador el path "/"
    }
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") int idContacto){
        Contacto contacto = new Contacto();
        contacto.setIdContacto(idContacto);
        contactoServicio.eliminarContacto(contacto);
        return "redirect:/";  // redirigiremos al controlador el path "/"
    }

}
