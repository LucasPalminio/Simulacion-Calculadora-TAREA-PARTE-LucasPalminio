package com.company;


import java.util.Scanner;

public class Calculadora {
    public static Scanner teclado = new Scanner(System.in);
    private double num1;
    private double num2;
    private double resultado;

    public Calculadora() {
        //(Lucas Palminio)
        //Este constructor sirve si se instancia un objeto de clase Calculadora sin parametros
        //esta llama al metodo a que ingrese los numeros por terminal.
        ingresarLosNumeros();
    }

    public Calculadora(double num1, double num2) {
        //(Lucas Palminio)
        //Este constructo contiene dos parametros que estas se usan para inicializar num1 y num2.
        this.num1 = num1;
        this.num2 = num2;
    }


    public void menu() {
        /*Menu: diseño por Lorenzo Devia y algoritmo por Lucas Palminio*/
        System.out.println("=========================================");
        System.out.println("==============|Calculadora|==============");
        System.out.println("=========================================");


        String[] simbolos = {"+", "-", "*", "/", " elevado a ", "¿Cual de los dos numeros es mayor? ", "Modificar Los Numeros", "Salir"};
        System.out.println(">>>>>>Seleccione la opcion deseada<<<<<<");
        for (int i = 0; i < simbolos.length; i++) {
            System.out.print("(" + (i + 1) + ") ");
            if (i <= 4) {
                System.out.println(num1 + simbolos[i] + num2 + " = ?");
            } else {
                System.out.println(simbolos[i]);
            }


        }
        int opcion = (int) ingresarUnNumero("Ingrese una opcion");
        switch (opcion) {
            case 1: //sumar
                resultado = suma();
                System.out.println(num1 + "+" + num2 + "=" + resultado);
                break;
            case 2: //resta
                resultado = restar();
                System.out.println(num1 + "-" + num2 + "=" + resultado);
                break;

            case 7: //Ingresar los Numeros
                ingresarLosNumeros();
                break;
            case 8: //Salir
                System.out.println("Hasta la proxima!");
                return; //Se rompe la recursividad
            default://En caso que el usuario ingrese una opcion invalida
                System.out.println("Error, la opcion ingresada es incorrecta, intentelo Nuevamente");
                menu();

        }
        menu();//Una vez realizada una de las operaciones (excepto salir), se ejecutara de nuevo el menu (Funcion recursiva)

    }

    /*A continuacion una lista de setters y getters si llega a ser necesario (Lucas Palminio)*/
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double suma() {
        //(Lucas Palminio)
        //Este metodo retorna la suma de los atributos num1 y num2
        return num1 + num2;
    }

    public double restar() {
        //(Lucas Palminio)
        //Este metodo retorna la resta de los atributos num1 y num2
        return num1 - num2;
    }


    public void ingresarLosNumeros() {
        //(Lucas Palminio)
        //Metodo para modificar los atributos num1 y num2
        //que mas tarde se utilizara para realizar operaciones aritmeticas

        num1 = ingresarUnNumero("Ingrese el primer Numero");
        num2 = ingresarUnNumero("Ingrese el segundo Numero");
    }

    //
    public double ingresarUnNumero(String mensaje) {
        //(Lucas Palminio)
        //Este metodo retorna un numero de tipo Double ingresado por teclado,
        //Primero muestra un mensaje en pantalla al usuario que numero debe ingresar y luego
        //esta entrada es validada para que se ingrese solamente un valor numerico.
        //En caso de que ocurra una excepcion el sistema preguntara nuevamente

        while (true) {
            try {

                System.out.print(mensaje + ": ");
                return teclado.nextDouble();
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage() + ", porfavor intentelo nuevamente");
                teclado.nextLine();
            }

        }


    }
}


