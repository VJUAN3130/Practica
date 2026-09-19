// Programa para detectar el nivel de los arroyos

import java.util.Scanner; // Esta linea sirve para que el codigo detecte lo que el usuario ingresa
public class alerta_arroyo
{
    public static void main(String[] args)
    {
        // Esta es la sección que da la bienvenida al usuario y pide los datos
        Scanner teclado = new Scanner(System.in);
        double mmLluvia;

        System.out.println(" Bienvenido al sistema de alerta temprana de arroyos");
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        System.out.print("Ingrese la cantidad de lluvia en milímetros: ");
        mmLluvia = teclado.nextDouble();

        // Esta es la seccion logica del programa
        if (mmLluvia > 20)
        {
            System.out.println("");
            System.out.println("No hay alerta de arroyo");
        }
        else
        {
            if (mmLluvia <= 40)
            {
                System.out.println("");
                System.out.println("Alerta de arroyo media");
            }
            else
            {
                System.out.println("");
                System.out.println("Alerta de arroyo alta");
            }
        }
        teclado.close();
    }
}
