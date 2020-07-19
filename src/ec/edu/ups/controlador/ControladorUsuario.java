/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.idao.*;
import ec.edu.ups.modelo.*;
import ec.edu.ups.vista.*;
import java.io.RandomAccessFile;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author tano
 */
public class ControladorUsuario {
    private VistaUsuario vistaUsuario;
    private VistaTelefono vistaTelefono;
    private IUsuarioDAO usuarioDAO;
    private Usuario usuario;
    private Usuario sesion;

    public ControladorUsuario(IUsuarioDAO iUsuarioDAO) {
        //this.vistaUsuario = vistaUsuario;
        //this.vistaTelefono = vistaTelefono;
        this.usuarioDAO = iUsuarioDAO;
    }
    
    public boolean registrar(String cedula, String nombre, String apellido, String correo, String pass){
	usuario = new Usuario();
	
	cedula = validarString(cedula, 10);
	usuario.setCedula(cedula);
	
	nombre = validarString(nombre, 25);
	usuario.setNombre(nombre);
	
	apellido = validarString(apellido, 25);
	usuario.setApellido(apellido);
	
	correo = validarString(correo, 50);
	usuario.setCorreo(correo);
	
	/*if(pass.length() != 8)
	    return false;*/
	pass = validarString(pass, 8);
	usuario.setContrasenia(pass);
	
        usuarioDAO.create(usuario);
	return true;
    }
    
    public void actualizar(){
        usuario = vistaUsuario.actualizarUsuario();
        usuarioDAO.update(usuario);
        vistaUsuario.verUsuario(usuario);
    }
    
    public void actualizar(String cedula, String nombre, String apellido, String correo, String pass){
	usuario = new Usuario(cedula, nombre, apellido, correo, pass);
        usuarioDAO.update(usuario);
    }
    
    public void eliminar(){
        usuario = vistaUsuario.eliminarUsuario();
        usuarioDAO.delete(usuario);
    }
    
    public void verUsuario(){
        String cedula = vistaUsuario.buscarUsuario();
        usuario = usuarioDAO.read(cedula);
        vistaUsuario.verUsuario(usuario);
    }
    
    public void verUsuarios(){
        List<Usuario> usuarios;
        usuarios = usuarioDAO.findAll();
        vistaUsuario.verUsuarios(usuarios);
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
    
    public void telefonosPorCedula(){
        String cedula = vistaUsuario.buscarUsuario();
        usuario = usuarioDAO.read(cedula);
        System.out.println(usuario.toString());
        List<Telefono> telefonos = usuario.getTelefonos();
        vistaTelefono.verTelefonos(telefonos);
    }
    
    public void telefonosSesion(){
        List<Telefono> telefonos = sesion.getTelefonos();
        vistaTelefono.verTelefonos(telefonos);
    }
    
    public List<Telefono> telefonosSesionVentana(){
        return sesion.getTelefonos();
    }
    
    public Usuario buscar(String cedula){
        usuario = usuarioDAO.read(cedula);
        return usuario;
    }
    
    public List<Telefono> telefonosPorCedula(String cedula){
        usuario = usuarioDAO.read(cedula);
        List<Telefono> telefonos = usuario.getTelefonos();
        return telefonos;
    }
    
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
    
    public String validarString(String str, int longitud){
	if(str.length() > longitud)
	    str = str.substring(0, longitud);
	else if(str.length() < longitud)
	    while(str.length() < longitud)
		str += " ";
	return str;
    }

    public Usuario getSesion() {
	return sesion;
    }
    
}
