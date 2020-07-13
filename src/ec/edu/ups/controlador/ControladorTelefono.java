/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import java.util.List;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VentanaGestionTelefono;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author tano
 */
public class ControladorTelefono {
    
    private VistaTelefono vistaTelefono;
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
	telefono.setCodigo(codigo);
	
	numero = validarString(numero, 25);
	telefono.setNumero(numero);
	
	tipo = validarString(tipo, 25);
	telefono.setTipo(tipo);
	
	operadora = validarString(operadora, 25);
	telefono.setOperadora(operadora);
	
	cedula = validarString(cedula, 10);
	telefono.setUsuario(controladorUsuario.buscar(cedula));
	
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
    
    public void verTelefono(){
        int codigo = vistaTelefono.buscarTelefono();
	telefono = new Telefono(codigo, "", "", "");
        vistaTelefono.verTelefono(telefono);
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
		telefonos.get(i).getOperadora()
	    });
	}
    }
    
    public int cantidadTelefonos(){
	List<Telefono> telefonos;
        telefonos = telefonoDAO.findAll();
	return telefonos.size();
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
