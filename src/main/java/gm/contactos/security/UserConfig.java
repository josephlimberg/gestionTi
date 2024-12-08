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
        // Usuario "user"
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER") // Rol USER
                .build();

        // Nuevo usuario "admin"
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN") // Rol ADMIN
                .build();


        return new InMemoryUserDetailsManager(user, admin);
    }
}
