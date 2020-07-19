package ec.edu.ups.modelo;
import java.util.Objects;
public class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;

    public Usuario(String cedula, String nombre, String apellido, String correo, String contrasenia) {
	setCedula(cedula);
	setNombre(nombre);
	setApellido(apellido);
	setCorreo(correo);
	setContrasenia(contrasenia);
    }

    public Usuario() {
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
	cedula = validarString(cedula, 10);
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
	nombre = validarString(nombre, 25);
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
	apellido = validarString(apellido, 25);
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
	correo = validarString(correo, 50);
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
	contrasenia = validarString(contrasenia, 8);
        this.contrasenia = contrasenia;
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
    
    public String validarString(String str, int longitud){
	if(str.length() > longitud)
	    str = str.substring(0, longitud);
	else if(str.length() < longitud)
	    while(str.length() < longitud)
		str += " ";
	return str;
    }
}
