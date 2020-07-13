package ec.edu.ups.modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private List<Telefono> telefonos;

    public Usuario(String cedula, String nombre, String apellido, String correo, String contrasenia) {
        telefonos = new ArrayList<>();
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Usuario() {
        telefonos = new ArrayList<>();
    }
    
    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return the telefonos
     */
    public List<Telefono> getTelefonos() {
        return telefonos;
    }
    
    public void setTelefonos(List<Telefono> telefonos){
	this.telefonos = telefonos;
    }
    
    public void agregarTelefono(Telefono telefono){
        telefonos.add(telefono);
    }
    
    public void actualizarTelefono(Telefono telefono){
        if(telefonos.contains(telefono)){
            telefonos.set(telefonos.indexOf(telefono), telefono);
        }
    }
    
    public void eliminarTelefono(Telefono telefono){
        if(telefonos.contains(telefono))
            telefonos.remove(telefono);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.getCedula());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario\n" +
                "Cédula: " + getCedula() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "Apellido: " + getApellido() + "\n" +
                "Correo: " + getCorreo() + "\n" + 
                "Contraseña: " + getContrasenia() + "\n";
    }
}
