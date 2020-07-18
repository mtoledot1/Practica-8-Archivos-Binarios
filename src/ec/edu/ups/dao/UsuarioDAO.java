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
    
    private RandomAccessFile file;
    List<Usuario> lista;
    /*
    private String cedula, 10 caracteres (validar cédula)
    private String nombre, 25 caracteres (llenar con espacios o cortar)
    private String apellido, 25 caracteres (llenar con espacios o cortar)
    private String correo, 50 caracteres (llenar con espacios o cortar)
    private String contraseña; 8 caracteres (llenar con espacios o cortar)
    */

    public UsuarioDAO() {
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
         try {
            int pos = 0;
            while (pos < file.length()) {                
                file.seek(pos);
                String cedulaUs = file.readUTF();
                cedulaUs = cedulaUs.trim();
                if(cedula.equals(cedulaUs)){
                    Usuario usuario = new Usuario(cedulaUs, file.readUTF().trim(), file.readUTF().trim(), file.readUTF().trim(), file.readUTF().trim());
                    return usuario;
                }
                pos += 128;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
	String cedula = usuario.getCedula();
        lista = new ArrayList<>();
	try {
            int pos = 0;
	    boolean cent = false;
            while (pos < file.length()) {                
		file.seek(pos);
                String cedulaUs = file.readUTF();
                cedulaUs = cedulaUs.trim();
                if(cedula.equals(cedulaUs)){
		    cent = true;
		}
		Usuario usr = new Usuario(cedulaUs, 
			file.readUTF().trim(), 
			file.readUTF().trim(), 
			file.readUTF().trim(), 
			file.readUTF().trim());
		lista.add(usr);
                pos += 128;
            }
	    if(cent){
		
	    }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String cedula) {
        
    }

    @Override
    public List<Usuario> findAll() {
	lista = new ArrayList<>();
	try {
            int pos = 0;
            while (pos < file.length()) {                
                file.seek(pos);
		Usuario usuario = new Usuario(file.readUTF().trim(), file.readUTF().trim(), file.readUTF().trim(), file.readUTF().trim(), file.readUTF().trim());
		lista.add(usuario);
                pos += 128;
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
        return new ArrayList(lista);
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
