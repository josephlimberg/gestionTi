package gm.contactos.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "contacto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContacto;
    String nombre;
    String celular;
    String email;
    String estado;
}
