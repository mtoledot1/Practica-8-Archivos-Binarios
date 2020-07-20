# Práctica de laboratorio 08: Agenda Telefónica con MVC y DAO con Archivos Binarios”
## Lenguaje
- Java JDK 8.1
- IDE Netbeans Apache 11.3
## Librerias
- java.io.RandomAccessFile;
- java.io.IOException;
- java.util.Scanner;
- java.util.logging.Level;
- java.util.logging.Logger;
- javax.swing.JFileChooser;
- javax.swing.JOptionPane;
## Objetivo Alcanzado
* Desarrollar aplicaciones con capacidad de persistir datos en archivos
* Implementar control de excepciones en el desarrollo de aplicaciones
## Actividades Desarrolladas
### 1. Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 08: Agenda Telefónica con MVC y DAO con Archivos Binarios”

El repositorio que se creó se encuentra en el siguiente link de GitHub
https://github.com/mtoledot1/Practica-de-laboratorio-08-Agenda-Telefonica-con-MVC-y-DAO-con-Archivos-Binarios
### 2. Desarrollar una aplicación en Java para gestionar una agenda telefónica según los requerimientos planteados en las instrucciones de la práctica.

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/1.png)

Esta es la ventana principal del programa, desde aquí podemos acceder a las diferentes ventanas que para gestionar la agenda telefónica mediante los menús que se nos muestran en la parte superior.

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/2.png)

En esta ventana podremos iniciar un sesión de un usuario registrado, para acceder a las ventanas para gestionar los usuarios y los teléfonos, mostrándonos un mensaje si el inicio de sesión fue exitoso o no.
Al iniciar una sesión se nos mostrará un menú nuevo con dos items que nos permitirán gestionar los teléfonos y los usuarios.

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/3.png)

En esta ventana podemos registrar un usuario nuevo en el sistema, y nos mostrará un mensaje que nos informaŕa si se pudo registrar el usuario o no.

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/4.png)

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/5.png)

En esta ventana podemos registrar un nuevo teléfono que estará asociado al usuario que ha iniciado sesión, además que podremos seleccionar un teléfono de la lista y podremos modificarlo o borrarlo.

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/6.png)

En esta ventana gestionaremos los usuarios registrados, podemos modificarlos o borrarlos según necesitemos.

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/7.png)

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/8.png)

![imagen](https://github.com/mtoledot1/Capturas/blob/master/Practica%208/9.png)

Esta ventana sirve para listar los teléfonos registrados, ya sea por cédula, por correo o listar todos los teléfonos registrados.

### 3. Realizar varios commits en la herramienta GitHub que demuestren el desarrollo de la aplicación desde principio a fin.
https://github.com/mtoledot1/Practica-de-laboratorio-08-Agenda-Telefonica-con-MVC-y-DAO-con-Archivos-Binarios/commits/master
## RESULTADO(S) OBTENIDO(S):
Manejar archivos con acceso no secuencial mediante la clase RandomAccesFile y sus diferentes métodos que nos sirven para guardar y leer los datos que están en el archivo, y saber posicionar el puntero para leer diferentes datos e iterar mediante los registros.
## CONCLUSIONES:
La clase RandomAccessFile nos ayuda cuando los archivos que queremos manejar no son archivos de texto simple y estos están compuestos de diferentes tipos de datos.
Los diferentes tipos de datos en un RandomAccessFile ocupan cierta posición de bytes, y para iterar por estos se debe conocer los tipos que están guardando y cuales son los tamaños que ocupa cada uno.
## RECOMENDACIONES:
Entender los diferentes tipos de datos que se pueden guardar en un archivo, y los diferentes tamaños que tiene cada uno de los datos.
