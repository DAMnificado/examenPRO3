package eje2;

import eje3.ej3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {

        Scanner sc;
        int num = 0;
        while (true) {
            System.out.println("**MENÚ PARA AGENDAS**");
            System.out.println("-1.Añade contacto a tu agenda");
            System.out.println("-2.Enseña el contactos");

            sc = new Scanner(System.in);
            System.out.println("Introduce una opcion");
            try {
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Dato introducido incorrecto");
                menu();
            }
            switch (num) {
                case 0:
                    System.out.println("Fin del programa");
                    return;
                case 1:
                    ej2.añadirAgenda();
                    break;
                case 2:
                    ej2.enseñarAgenda();
                    break;
            }
        }
    }
}