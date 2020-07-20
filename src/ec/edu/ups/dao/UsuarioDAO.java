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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tano
 */
public class UsuarioDAO implements IUsuarioDAO{
    

    private List<Usuario> usuarios;
    private RandomAccessFile file;
    /*
    private String cedula, 10+2=12 caracteres (validar cédula)
    private String nombre, 25+2 caracteres (llenar con espacios o cortar)
    private String apellido, 25 caracteres (llenar con espacios o cortar)
    private String correo, 50 caracteres (llenar con espacios o cortar)
    private String contraseña; 8 caracteres (llenar con espacios o cortar)
    */

    public UsuarioDAO() {
        try {
	    file = new RandomAccessFile("datos/usuario.dat", "rw");
            int tamaño = 128;
	} catch (FileNotFoundException ex) {
	    System.out.println("Error de lectura y escritura: ");
	    ex.printStackTrace();
	}
    }

    @Override
    public void create(Usuario usuario) {
	try {
	    if(file.length() > 0)
		file.seek(file.length());
	    else
		file.seek(0);
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
	cedula = cedula.trim();
        try {
            int pos = 0;
            while (pos < file.length()) {
		file.seek(pos);
                String cedulaUs = file.readUTF().trim();
                if(cedula.equals(cedulaUs)){
                    Usuario usuario = new Usuario(cedulaUs, file.readUTF(), file.readUTF(), file.readUTF(), file.readUTF());
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
	usuarios = new ArrayList<>();
	String cedula = usuario.getCedula();
        try {
            int pos = 0;
	    file.seek(pos);
            while (pos < file.length()) {                
                String cedulaUs = file.readUTF().trim();
		Usuario usr = new Usuario(cedulaUs, file.readUTF(), file.readUTF(), file.readUTF(), file.readUTF());
                if(cedula.equals(cedulaUs)){
                    usr = usuario;
                }
		usuarios.add(usr);
                pos += 128;
            }
	    file.setLength(0);
	    for(Usuario u : usuarios){
		create(u);
	    }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String cedula) {
	usuarios = new ArrayList<>();
        try {
            int pos = 0;
            while (pos < file.length()) {
		file.seek(pos);
                String cedulaUs = file.readUTF().trim();
                if(!cedula.equals(cedulaUs)){
                    Usuario usuario = new Usuario(cedulaUs, file.readUTF(), file.readUTF(), file.readUTF(), file.readUTF());
                    usuarios.add(usuario);
                }
                pos += 128;
            }
	    file.setLength(0);
	    for(Usuario u : usuarios){
		create(u);
	    }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Usuario> findAll() {
	usuarios = new ArrayList<>();
        try {
            int pos = 0;
	    file.seek(pos);
            while (pos < file.length()) {
		Usuario usuario = new Usuario(file.readUTF(), file.readUTF(), file.readUTF(), file.readUTF(), file.readUTF());
                pos += 128;
		usuarios.add(usuario);
            }
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
	return usuarios;
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
		    return new Usuario(file.readUTF(), file.readUTF(), file.readUTF(), file.readUTF(), file.readUTF());
		}
		salto += 128;
	    }
	} catch (IOException ex) {
	    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
}
