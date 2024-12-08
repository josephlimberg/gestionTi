package gm.contactos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {


        // Nuevo usuario "admin"
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN") // Rol ADMIN
                .build();
        // Nuevo usuario "admin"
        UserDetails admin2 = User.withUsername("juanadmin@correo.com")
                .password(passwordEncoder.encode("juanadmin"))
                .roles("ADMIN") // Rol ADMIN
                .build();

        // Usuario "user"
        UserDetails user = User.withUsername("miauser1@correo.com")
                .password(passwordEncoder.encode("miauser1"))
                .roles("USER") // Rol USER
                .build();

        // Nuevo usuario "user1"
        UserDetails user1 = User.withUsername("felipeuser@correo.com")
                .password(passwordEncoder.encode("felipeuser"))
                .roles("USER") // Rol USER
                .build();
        // Nuevo usuario "user2"
        UserDetails user2 = User.withUsername("mariauser1@correo.com")
                .password(passwordEncoder.encode("mariauser1"))
                .roles("USER") // Rol ADMIN
                .build();


        return new InMemoryUserDetailsManager(user, admin,admin2, user1, user2);
    }
}
