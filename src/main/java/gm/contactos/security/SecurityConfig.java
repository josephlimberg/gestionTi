package gm.contactos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated() // Requiere que el usuario esté autenticado
                )
                .formLogin(form -> form
                        .loginPage("/login") // Página de login personalizada
                        .defaultSuccessUrl("/") // Redirige a la página principal tras el login
                        .permitAll() // Permitir acceso a la página de login sin autenticación
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // Redirige al login tras logout
                        .permitAll()
                )
                .csrf().disable(); // Desactiva CSRF para simplificar pruebas locales

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Codificador de contraseñas
    }
}
