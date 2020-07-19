/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import javax.swing.text.html.HTML;

/**
 *
 * @author tano
 */
public class TelefonoDAO implements ITelefonoDAO{
    
    /*
    private int codigo; 4 bytes
    private String numero; 25 bytes + 2 extras
    private String tipo; 25 bytes + 2 extras
    private String operadora; 25 bytes + 2 extras
    private String cedula; 10 bytes + 2 extras
    */
    private RandomAccessFile file;
    private int tamanioRegistro;
    private ControladorUsuario controladorUsuario;

    public TelefonoDAO(ControladorUsuario controladorUsuario) {
	this.controladorUsuario = controladorUsuario;
	try {
	    tamanioRegistro = 97;
	    file = new RandomAccessFile("datos/telefono.dat", "rw");
	} catch (FileNotFoundException ex) {
	    System.out.println("Error de lectura y escritura: ");
	    ex.printStackTrace();
	}
    }

    @Override
    public void create(Telefono telefono) {
        try {
	    file.seek(file.length());
	    file.writeInt(telefono.getCodigo());
	    file.writeUTF(telefono.getNumero());
	    file.writeUTF(telefono.getTipo());
	    file.writeUTF(telefono.getOperadora());
	    file.writeUTF(telefono.getUsuario().getCedula());
	    System.out.println("Longitud archivo despues de crear: "+file.getFilePointer());
	} catch (IOException ex) {
	    System.out.println("Error de lectura y escritura: ");
	    ex.printStackTrace();
	}
    }

    @Override
    public Telefono read(int codigo) {
	try{
	    int salto = 0;
	    while(salto < file.length()){
		file.seek(salto);
		int codigoArchivo = file.readInt();
		if(codigo == codigoArchivo){
		    Telefono telefono = new Telefono(codigo, file.readUTF(), file.readUTF(), file.readUTF());
		    Usuario usuario = controladorUsuario.buscar(file.readUTF());
		    telefono.setUsuario(usuario);
		    return telefono;
		}
	    }
	}catch (IOException ex){
	    System.out.println("Error de lectura y escritura: ");
	    ex.printStackTrace();
	}
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        
    }

    @Override
    public void delete(Telefono telefono) {
        
    }

    @Override
    public List<Telefono> findAll() {
        try {
            List<Telefono> telefono = new ArrayList<>();
            int pos = 0;
	    file.seek(pos);
	    System.out.println("Longitud archivo: "+file.length());
            while (pos < file.length()-1) {
		int codigo = file.readInt();
		//System.out.println(file.getFilePointer());
		String numero = file.readUTF();
		//System.out.println(file.getFilePointer());
		String tipo = file.readUTF();
		System.out.println(file.getFilePointer());
		String operadora = file.readUTF();
		System.out.println(file.getFilePointer());
                Telefono telf = new Telefono(codigo, numero, tipo, operadora);
		String cedula = file.readUTF();
		System.out.println(file.getFilePointer());
		telf.setUsuario(controladorUsuario.buscar(cedula));
                telefono.add(telf);
                pos += tamanioRegistro;
            }
            return telefono;
        } catch (IOException ex) {
            System.out.println("Error de escritura y lectura");
            ex.printStackTrace();
        }
        return null;
    }
    
    public int obtenerUltimoCodigo(){
	try{
	    if(file.length() >= tamanioRegistro)
		file.seek(file.length() - tamanioRegistro);
	    else
		return -1;
	    //System.out.println(file.getFilePointer());
	    int codigo = file.readInt();
	    //System.out.println(codigo);
	    return codigo;
	}catch (IOException ex){
	    System.out.println("Error de lectura y escritura: ");
	    ex.printStackTrace();
	}
	return 0;
    }
}
