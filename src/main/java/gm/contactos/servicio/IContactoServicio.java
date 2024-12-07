package gm.contactos.servicio;

import gm.contactos.modelo.Contacto;
import java.util.List;

public interface IContactoServicio {

    public List<Contacto> listarContacto();

    public Contacto buscarContactoPorId (Integer idContacto);

    public void gurdarContacto(Contacto contacto);

    public void eliminarContacto(Contacto contacto);

}
