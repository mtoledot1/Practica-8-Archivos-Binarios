/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.test;

/**
 *
 * @author tano
 */
public class Main {
    /*
    //scanner
    Scanner leer = new Scanner(System.in);
    //vistas
    VistaUsuario vistaUsuario = new VistaUsuario();
    VistaTelefono vistaTelefono = new VistaTelefono();
    //daos
    IUsuarioDAO usuarioDAO = new UsuarioDAO();
    ITelefonoDAO telefonoDAO = new TelefonoDAO();
    //controladores
    ControladorUsuario controladorUsuario = new ControladorUsuario(usuarioDAO, telefonoDAO);
    ControladorTelefono controladorTelefono = new ControladorTelefono(vistaTelefono, telefonoDAO, controladorUsuario);

    /**
     * @param args the command line arguments
     */
   /* public static void main(String[] args) {
        Main main = new Main();
	//VentanaTelefono ventana = new VentanaTelefono();
    }
    
    public Main(){
        int opc = 0;
	InicioSesion is;
        do{
            if(controladorUsuario.sesionIniciada()){
                opc = menuSesionIniciada();
            }else{
                opc = menuNormal();
            }
            switch(opc){
                case 1:
                    //inicio de sesión
                    //controladorUsuario.iniciarSesion();
		    is = new InicioSesion(controladorUsuario, telefonoDAO);
                    break;
                case 2:
                    //Registro de usuarios
                    controladorUsuario.registrar();
                    break;
                case 3:
                    //modificar usuario
                    controladorUsuario.actualizar();
                    break;
                case 4:
                    //eliminar usuarios
                    controladorUsuario.eliminar();
                    break;
                case 5:
                    //buscar usuarios
                    controladorUsuario.verUsuario();
                    break;
                case 6:
                    //Listar usuarios
                    controladorUsuario.verUsuarios();
                    break;
                case 7:
                    //registro de teléfono
                    //InicioSesion is = new InicioSesion(controladorTelefono,telefonoDAO);
                    break;
                /*case 8:
                    //modificar teléfono
                    controladorTelefono.actualizar();
                    break;
                case 9:
                    //elminar teléfono
                    controladorTelefono.eliminar();
                    break;
                case 10:
                    //buscar teléfono
                    controladorTelefono.verTelefono();
                    break;
                case 11:
                    //listar teléfonos de la sesión
                    controladorUsuario.telefonosSesion();
                    break;*/
                /*case 8:
                    //listar teléfonos mediante la cédula
                    controladorUsuario.telefonosPorCedula();
                    break;
                case 9:
                    //listar todos los teléfonos
                    controladorTelefono.verTelefonos();
                    break;
                case 10:
                    //cambiar de usuario
                    controladorUsuario.iniciarSesion();
                    break;
                case 11:
                    //cerrar sesión
                    controladorUsuario.cerrarSesion();
                    break;
            }
        }while(opc != 12);
    }
    
    public int menuSesionIniciada(){
        int opc = 0;
        do{
            System.out.println("----MENU----");
            System.out.println("1) Registrar Usuario");
            System.out.println("2) Modificar Usuario");
            System.out.println("3) Eliminar Usuario");
            System.out.println("4) Buscar Usuario");
            System.out.println("5) Listar Todos los Usuarios registrados");
            System.out.println("6) Agenda Telefónica");
            /*System.out.println("7) Modificar Teléfono");
            System.out.println("8) Eliminar Teléfono");
            System.out.println("9) Buscar Teléfono");
            System.out.println("10) Listar Teléfonos del Usuario");*/
            /*System.out.println("7) Listar Teléfonos de un Usuario mediante la cédula");
            System.out.println("8) Listar Todos los Teléfonos registrados");
            System.out.println("9) Cambiar de Usuario");
            System.out.println("10) Cerrar Sesión");
            System.out.println("11) Cerrar programa");
            System.out.print("Ingrese una opcion: ");
            opc = leer.nextInt();
            leer.nextLine();
            if(opc < 1 || opc > 15){
                System.out.println("Ingrese una opcion correcta");
            }
        }while(opc < 1 || opc > 16);
        opc++;
        return opc;
    }
    
    public int menuNormal(){
        int opc = 0;
        do{
            System.out.println("----MENU----");
            System.out.println("1) Iniciar Sesion");
            System.out.println("2) Registrar Usuario");
            System.out.println("3) Modificar Usuario");
            System.out.println("4) Eliminar Usuario");
            System.out.println("5) Buscar Usuario");
            System.out.println("6) Listar Todos los Usuarios registrados");
            System.out.println("7) Listar Teléfonos de un Usuario mediante la cédula");
            System.out.println("8) Listar Todos los Teléfonos registrados");
            System.out.println("9) Cerrar programa");
            System.out.print("Ingrese una opcion: ");
            opc = leer.nextInt();
            leer.nextLine();
            if(opc < 1 || opc > 9){
                System.out.println("Ingrese una opcion correcta");
            }
        }while(opc < 1 || opc > 9);
        if(opc == 7){
            return 8;
        }else if(opc == 8){
            return 9;
        }else if(opc == 9){
            return 12;
        }
        return opc;
    }
    
    */
}
