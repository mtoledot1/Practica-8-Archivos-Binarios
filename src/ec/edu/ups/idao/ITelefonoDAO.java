package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
 *
 * @author tano
 */
public interface ITelefonoDAO {
    public void create(Telefono telefono);
    public Telefono read(int codigo);
    public void update(Telefono telefono);
    public void delete(Telefono telefono);   
    public List<Telefono> findAll();
}
