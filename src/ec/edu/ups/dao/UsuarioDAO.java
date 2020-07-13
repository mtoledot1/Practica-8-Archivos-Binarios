/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tano
 */
public class UsuarioDAO implements IUsuarioDAO{
    

    private Map<Integer,Usuario> usuarios;
    private RandomAccessFile file;
    /*
    private String cedula, 10 caracteres (validar cédula)
    private String nombre, 25 caracteres (llenar con espacios o cortar)
    private String apellido, 25 caracteres (llenar con espacios o cortar)
    private String correo, 50 caracteres (llenar con espacios o cortar)
    private String contraseña; 8 caracteres (llenar con espacios o cortar)
    */

    public UsuarioDAO() {
	usuarios = new TreeMap<>();
        try {
	    file = new RandomAccessFile("datos/usuario.dat", "rw");
	} catch (FileNotFoundException ex) {
	    System.out.println("Error de lectura y escritura: ");
	    ex.printStackTrace();
	}
    }

    @Override
    public void create(Usuario usuario) {
	try {
	    file.writeUTF(usuario.getCedula());
	    file.writeUTF(usuario.getNombre());
	    file.writeUTF(usuario.getApellido());
	    file.writeUTF(usuario.getCorreo());
	    file.writeUTF(usuario.getContrasenia());
	} catch (IOException ex) {
	    System.out.println("Error de lectura y escritura: ");
	    ex.printStackTrace();
	}
    }

    @Override
    public Usuario read(String cedula) {
        Usuario usuario = new Usuario(cedula, null, null, null, null);
        if(usuarios.containsKey(usuario.hashCode())){
            return usuarios.get(usuario.hashCode());
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
        if(usuarios.containsKey(usuario.hashCode())){
	    usuario.setTelefonos(usuarios.get(usuario.hashCode()).getTelefonos());
            usuarios.replace(usuario.hashCode(), usuario);
        }
    }

    @Override
    public void delete(Usuario usuario) {
        if(usuarios.containsKey(usuario.hashCode())){
            usuarios.remove(usuario.hashCode());
        }
    }

    @Override
    public List<Usuario> findAll() {
        return new ArrayList(usuarios.values());
    }

    @Override
    public Usuario login(String correo, String pass) {
	try {
	    int salto = 66;
	    while(salto < file.length()){
		file.seek(salto);
		String correoArchivo = file.readUTF();
		correoArchivo = correoArchivo.trim();
		String passArchivo = file.readUTF();
		passArchivo = passArchivo.trim();
		if(correo.equals(correoArchivo) && pass.equals(passArchivo)){
		    file.seek(salto - 66);
		    String cedula = file.readUTF();
		    String nombre = file.readUTF();
		    String apellido = file.readUTF();
		    return new Usuario(cedula, nombre, apellido, correo, pass);
		}
		salto += 128;
	    }
	} catch (IOException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
}
