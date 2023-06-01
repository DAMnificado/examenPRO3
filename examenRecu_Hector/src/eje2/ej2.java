package eje2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ej2 {

    static File archivo = new File("./src/eje2/agenda.txt");
    static Scanner sc = new Scanner(System.in);

    public static void añadirAgenda() {

        System.out.println("Dime el nombre a registrar");
        String nombre = sc.next();

        boolean si = true;

        while (si) {

            try {

                System.out.println("Dime el tlf a registrar");
                String telefono = sc.next();

                comprobar(telefono);

                System.out.println("Dime el nombre a registrar");
                String name = sc.next();

                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo,true))) {
                    dos.writeUTF(name);
                    dos.writeUTF(String.valueOf(telefono));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                si = false;

            } catch (NumeroNegativo e) {
                System.out.println(e.getMessage());
                si = true;
            }
        }
    }

    private static void comprobar(String telefono) {

        int telefonoParseado = Integer.parseInt(telefono);

        if (telefonoParseado < 0) {
            throw new NumeroNegativo("El número no puede ser negativo");
        }

        if (telefono.length()!=9){
            System.out.println("Exepcion");
        }

        if (telefono.charAt(0)==1){
            System.out.println("Exepcion");
        }

    }


    public static void enseñarAgenda() {

        try (DataInputStream dis = new DataInputStream(new FileInputStream(archivo))) {
            while (true) {
                System.out.println(dis.readUTF());
            }
        } catch (EOFException e) {
            System.out.println("Fin de archivo");
        } catch (StreamCorruptedException e) {
            System.out.println();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}