/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tano
 */
public class VistaUsuario {
    private Scanner leer;
    
    public VistaUsuario(){
        leer = new Scanner(System.in);
    }
    
    public Usuario ingresarUsuario(){
        System.out.println("Ingrese los datos del usuario:");
        System.out.print("Cedula: ");
        String cedula = leer.nextLine();
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Apellido: ");
        String apellido = leer.nextLine();
        System.out.print("Correo: ");
        String correo = leer.nextLine();
        System.out.print("Contraseña: ");
        String contrasenia = leer.nextLine();
        return new Usuario(cedula, nombre, apellido, correo, contrasenia);
    }
    
    public Usuario actualizarUsuario(){
        System.out.print("Ingrese la cedula del usuario: ");
        String cedula = leer.nextLine();
        System.out.println("Ingrese los nuevos datos");
        System.out.print("Nombre: ");
        String nombre = leer.nextLine();
        System.out.print("Apellido: ");
        String apellido = leer.nextLine();
        System.out.print("Correo: ");
        String correo = leer.nextLine();
        System.out.print("Contraseña: ");
        String contrasenia = leer.nextLine();
        return new Usuario(cedula, nombre, apellido, correo, contrasenia);
    }
    
    public Usuario eliminarUsuario(){
        System.out.print("Ingrese la cedula del usuario: ");
        String cedula = leer.nextLine();
        return new Usuario(cedula, null, null, null, null);
    }
    
    public String buscarUsuario(){
        System.out.print("Ingrese la cedula del usuario: ");
        String cedula = leer.nextLine();
        return cedula;
    }
    
    public void verUsuario(Usuario usuario){
        System.out.println("Datos del Usuario: " + usuario.toString());
    }
    
    public void verUsuarios(List<Usuario> usuarios){
        usuarios.forEach((usuario) -> {
            System.out.println("Datos del Usuario: " + usuario.toString());
        });
    }
    
    public Usuario iniciarSesion(){
        System.out.print("Ingrese el correo: ");
        String correo = leer.nextLine();
        System.out.print("Ingrese la contrasenia: ");
        String contrasenia = leer.nextLine();
        return new Usuario(null, null, null, correo, contrasenia);
    }
}
