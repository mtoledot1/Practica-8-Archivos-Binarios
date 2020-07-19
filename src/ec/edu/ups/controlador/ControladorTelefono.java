/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.util.List;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VentanaGestionTelefono;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tano
 */
public class ControladorTelefono {
    
    private ITelefonoDAO telefonoDAO;
    private Telefono telefono;
    private ControladorUsuario controladorUsuario;
    private VentanaGestionTelefono gestionTelefono;

    public ControladorTelefono(ITelefonoDAO telefonoDAO, ControladorUsuario controladorUsuario) {
	this.gestionTelefono = gestionTelefono;
	this.telefonoDAO = telefonoDAO;
	this.controladorUsuario = controladorUsuario;
    }
    
    /*
    private int codigo; 4 bytes
    private String numero; 25 bytes + 2 extras
    private String tipo; 25 bytes + 2 extras
    private String operadora; 25 bytes + 2 extras
    private String cedula; 10 bytes + 2 extras
    */
    public void registrar(int codigo, String numero, String tipo, String operadora, String cedula){
	telefono = new Telefono(codigo, numero, tipo, operadora);
	Usuario usuario = controladorUsuario.buscar(controladorUsuario.getSesion().getCedula());
	telefono.setUsuario(usuario);
	telefonoDAO.create(telefono);
    }
    
    public void actualizar(int codigo, String numero, String tipo, String operadora, String cedula){
	telefono = new Telefono(codigo, numero, tipo, operadora);
        telefonoDAO.update(telefono);
    }
    
    public void eliminar(int codigo){
	telefono = new Telefono();
	telefono.setCodigo(codigo);
        telefonoDAO.delete(telefono);
    }
    
    public void verTelefonos(DefaultTableModel tabla){
        List<Telefono> telefonos;
        telefonos = telefonoDAO.findAll();
	tabla.setNumRows(0);
	for(int i = 0; i < telefonos.size(); i++){
	    tabla.addRow(new Object[]{
		telefonos.get(i).getCodigo(),
		telefonos.get(i).getTipo(),
		telefonos.get(i).getNumero(),
		telefonos.get(i).getOperadora(),
		telefonos.get(i).getUsuario().getCedula()
	    });
	}
    }
    
    public int cantidadTelefonos(){
	List<Telefono> telefonos;
        telefonos = telefonoDAO.findAll();
	return telefonos.size();
    }
    
    public int ultimoCodigo(){

	return telefonoDAO.obtenerUltimoCodigo();
    }
}
