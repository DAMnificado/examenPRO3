package eje1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ej1 {
    static Scanner sc = new Scanner(System.in);

    public static void eje1(){
        System.out.println("Dame la dirección con la que quieres trabajar");
        String ruta = sc.next();
        File file = new File(ruta);
        File archivo = new File(ruta);
        if (file.exists()){

            //estoy creando una ruta(file) por cada archivo que haya dentro de la ruta madre
            File[] listaArchivos = file.listFiles();

            for (File f : listaArchivos) {

                    if (f.isDirectory()){
                        System.out.println("Es un directorio");
                        try {
                            System.out.println("Creamos dos ficheros");
                            f.createNewFile();
                            f.createNewFile();
                            System.out.println("Enseñamos sus nombres");
                            System.out.println(archivo.getName());
                            System.out.println(file.getName());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else if (f.isFile()){
                        System.out.println("Es un archivo");
                        if (f.canWrite()) System.out.println("Puede leer");
                        if (f.canRead()) System.out.println("Puede escribir");
                        System.out.println("Tamaño del archivo en KB: "+ f.length() / 1024 + "KB");
                    }
                }
            }else System.out.println("La ruta proporcionada no existe");
        }
    }

