package ec.edu.ups.controlador;

import ec.edu.ups.idao.*;
import ec.edu.ups.modelo.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tano
 */
public class ControladorUsuario {
    private IUsuarioDAO usuarioDAO;
    private Usuario usuario;
    private Usuario sesion;

    public ControladorUsuario(IUsuarioDAO iUsuarioDAO) {
        this.usuarioDAO = iUsuarioDAO;
    }
    
    public boolean registrar(String cedula, String nombre, String apellido, String correo, String pass){
	usuario = new Usuario(cedula, nombre, apellido, correo, pass);
        usuarioDAO.create(usuario);
	return true;
    }
    
    
    public void actualizar(String cedula, String nombre, String apellido, String correo, String pass){
	usuario = new Usuario(cedula, nombre, apellido, correo, pass);
        usuarioDAO.update(usuario);
    }
    
    public void eliminar(String cedula){
	usuarioDAO.delete(cedula);
    }
    
    public void verUsuarios(DefaultTableModel tabla){
        List<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        tabla.setRowCount(0);
	for(int i = 0; i < usuarios.size(); i++){
	    tabla.addRow(new Object[]{
		usuarios.get(i).getCedula(),
		usuarios.get(i).getNombre(),
		usuarios.get(i).getApellido(),
		usuarios.get(i).getCorreo()
	    });
	}
    }
    
    public List<Usuario> listarUsuarios(){
	return usuarioDAO.findAll();
    }
    
    public boolean iniciarSesion(String correo, String contrasenia){
        usuario = usuarioDAO.login(correo, contrasenia);
	if(usuario != null){
	    sesion = usuario;
	    return true;
	}else
	    return false;
    }
    
    public void cerrarSesion(){
        sesion = null;
    }
    
    /*public List<Telefono> telefonosSesionVentana(){
        
    }*/
    
    public Usuario buscar(String cedula){
        usuario = usuarioDAO.read(cedula);
        return usuario;
    }
    
    /*public List<Telefono> telefonosPorCedula(String cedula){
        usuario = usuarioDAO.read(cedula);
        
        return telefonos;
    }*/
    
    public boolean sesionIniciada(){
        if(sesion == null)
            return false;
        else
            return true;
    }
    
    public boolean validarCedula(String cedula) throws NumberFormatException{
	if(cedula.length() != 10)
	    return false;
	Integer.parseInt(cedula);
	int res = 0;
	for(int i = 0; i < cedula.length()-1; i++){
	    if((i+1)%2 == 0){
		res += cedula.charAt(i)-'0';
	    } else {
		int digito = cedula.charAt(i)-'0';
		digito *= 2;
		if(digito > 9)
		    digito -= 9;
		res += digito;
	    }
	}
	while(res > 0){
	    res -= 10;
	}
	res = 0-res;
	int verificador = cedula.charAt(cedula.length()-1)-'0';
	if(res == verificador)
	    return true;
	else
	    return false;
    }

    public Usuario getSesion() {
	return sesion;
    }
    
}