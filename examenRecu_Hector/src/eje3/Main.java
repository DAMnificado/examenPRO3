package eje3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }
    private static void menu() {

            Scanner sc;
            int num = 0;
            while (true){
                System.out.println("*******GESTIÓN DE EMPLEADOS*******");
                System.out.println("****ELIGE UNA DE LAS OPCIONES*****");
                System.out.println("|     1.Añade empleado           |");
                System.out.println("| 2.Consulta empleado por nombre |");
                System.out.println("|     3.Lista empleados          |");
                System.out.println("|     4.Elimina empleado         |");


                sc = new Scanner(System.in);
                System.out.println("Introduce una opcion");
                try {
                    num = sc.nextInt();
                }catch (InputMismatchException ex){
                    System.out.println("Dato introducido incorrecto");
                    menu();
                }
                switch (num){
                    case 0:
                        System.out.println("Fin del programa");
                        return;
                    case 1:
                        ej3.añadirEmpleado();
                        break;
                    case 2:
                        ej3.consultarEmpleadoXNombre();
                        break;
                    case 3:
                        ej3.listarEmpleados();
                        break;
                    case 4:
                        ej3.eliminarEmpleadoXNombre();
                        break;
                    default:
                        System.out.println("El numero no coincide con ninguna opcion");
                }
            }
        }
    }

