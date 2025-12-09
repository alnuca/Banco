package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cuenta cuenta = new Cuenta("12345678X", "Chan");
        int opcion = 0;
        boolean salir = false;
        do {
            System.out.println("MENU");
            System.out.println("1) Sacar dinero");
            System.out.println("2) Ingresar dinero");
            System.out.println("3) Mostrar información");
            System.out.println("4) Salir");
            System.out.println("Selecciona una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Cuanto dinero quieres sacar: ");
                    double extracto = sc.nextDouble();
                    if(cuenta.sacarDinero(extracto)){
                        System.out.println("H sacado dinero correctamente");
                    } else{
                        System.out.println("Saldo insuficiente");
                    }
                    break;
                case 2:
                    System.out.println("Cuanto quieres ingresar: ");
                    double ingreso = sc.nextDouble();
                    cuenta.ingresarDinero(ingreso);
                    break;
                case 3:
                    System.out.println("Te mostraré tu información");
                    System.out.println(cuenta.mostrarInformacion());
                    break;
                case 4:
                    System.out.println("Saliendo");
                    salir = true;
                    break;
            }


        } while (!salir);
    }
}