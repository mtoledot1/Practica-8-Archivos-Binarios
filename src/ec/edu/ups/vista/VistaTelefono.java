/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author tano
 */
public class VistaTelefono {
    private Scanner leer;
    
    public VistaTelefono(){
        leer = new Scanner(System.in);
    }
    
    public Telefono ingresarTelefono(){
        System.out.println("Ingrese los datos del telefono:");
        System.out.print("Codigo: ");
        int codigo = leer.nextInt();
        leer.nextLine();
        System.out.print("Numero: ");
        String numero = leer.nextLine();
        System.out.print("Tipo: ");
        String tipo = leer.nextLine();
        System.out.print("Operadora: ");
        String operadora = leer.nextLine();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    public Telefono actualizarTelefono(){
        System.out.print("Ingrese el codigo del telefono: ");
        int codigo = leer.nextInt();
        leer.nextLine();
        System.out.println("Ingrese los nuevos datos");
        System.out.print("Numero: ");
        String numero = leer.nextLine();
        System.out.print("Tipo: ");
        String tipo = leer.nextLine();
        System.out.print("Operadora: ");
        String operadora = leer.nextLine();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    public Telefono eliminarTelefono(){
        System.out.print("Ingrese el codigo del telefono: ");
        int codigo = leer.nextInt();
        leer.nextLine();
        return new Telefono(codigo, null, null, null);
    }
    
    public int buscarTelefono(){
        System.out.print("Ingrese el codigo del telefono: ");
        int codigo = leer.nextInt();
        leer.nextLine();
        return codigo;
    }
    
    public void verTelefono(Telefono telefono){
        System.out.println("Datos del Telefono: " + telefono.toString());
    }
    
    public void verTelefonos(List<Telefono> telefonos){
        telefonos.forEach((telefono) -> {
            System.out.println("Datos del Telefono: " + telefono.toString());
        });
    }
}
