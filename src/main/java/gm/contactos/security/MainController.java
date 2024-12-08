package gm.contactos.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /*
    @GetMapping("/")
    public String home() {
        return "index"; // Página principal
    }
     */

    @GetMapping("/login")
    public String login() {
        return "login"; // Página de login
    }
}
