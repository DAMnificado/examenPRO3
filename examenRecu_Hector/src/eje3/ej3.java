package eje3;

import java.io.*;
import java.util.Scanner;

public class ej3 {

    static File archivo = new File("./src/eje3/empleados.txt");
    static File archivoTemp = new File("./src/eje3/empleadosTemp.txt");
    static Scanner sc = new Scanner(System.in);

    public static void añadirEmpleado(){
        crearArchivo(archivo);
        sc = new Scanner(System.in);
        System.out.println("Dime el dni del empleado");
        String dni = sc.next();

        System.out.println("Dime el nombre del empleado");
        String nombre = sc.next();

        System.out.println("Dime el apellido");
        String apellido = sc.next();

        System.out.println("Dime el puesto que ocupa");
        String puesto = sc.next();

        sc = new Scanner(System.in);
        System.out.println("Dime su salario");
        int salario= sc.nextInt();

        sc = new Scanner(System.in);
        System.out.println("Dime su edad");
        int edad = sc.nextInt();

    Empleado empleado = new Empleado(dni,nombre,apellido,puesto,salario,edad);

    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo, true))) {
        oos.writeObject(empleado);

    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


    }

    public static void consultarEmpleadoXNombre(){
        sc = new Scanner(System.in);
        crearArchivo(archivo);
        System.out.println("Dime el nombre del empleado que quieres consultar");
        String empleadoAConsultar = sc.next();
        Empleado empleado;

       try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
           while (true) {
               empleado = (Empleado) ois.readObject();
               if (empleadoAConsultar.equalsIgnoreCase(empleado.getNombre())) {
                   System.out.println("Sí, este empleado pertenece a nuestra plantilla");
               } else System.out.println("Me temo que no, este empleado no está registrado");
           }
       }catch (EOFException e){
           System.out.println("Fin del archivo");
       }catch (StreamCorruptedException e){
           System.out.println("Error en el stream");
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
       }

    }

    public static void listarEmpleados(){
        crearArchivo(archivo);
      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
          while (true) {
              System.out.println(ois.readObject());
          }
      }catch (EOFException e){
          System.out.println("Fin del archivo");
      }catch (FileNotFoundException e) {
          throw new RuntimeException(e);
      }catch (IOException e) {
          throw new RuntimeException(e);
      }catch (ClassNotFoundException e) {
          throw new RuntimeException(e);
      }
    }

    public static void eliminarEmpleadoXNombre(){
        sc = new Scanner(System.in);
        crearArchivo(archivo);
        System.out.println("Dime el nombre del empleado que quieres eliminar");
        String empleadoAEliminar = sc.next();
        Empleado empleado;

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
            ObjectOutputStream oisT = new ObjectOutputStream(new FileOutputStream(archivoTemp,true))) {
            empleado = (Empleado) ois.readObject();
            while (true) {

                if (empleadoAEliminar.equalsIgnoreCase(empleado.getNombre())) {
                    System.out.println("Eliminado");
                } else oisT.writeObject(empleado);
            }
        }catch(EOFException e) {
            System.out.println("Fin del archivo");
            archivo.delete();
            archivoTemp.renameTo(archivo);
        }catch(StreamCorruptedException e) {
            System.out.println("Error en el Stream");
            archivo.delete();
            archivoTemp.renameTo(archivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


public static void crearArchivo(File archivo){
        if(!archivo.exists()){
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}



}
