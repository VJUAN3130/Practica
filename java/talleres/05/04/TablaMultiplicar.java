/**
 * 📝 ENUNCIADO:
 * Mostrar por pantalla una tabla de multiplicar completa de un número dado.
 *
 * 🎯 OBJETIVO / TEMAS:
 * - Creación de procedimientos (métodos void).
 * - Uso de bucles for para iterar del 1 al 10.
 * - Concatenación de variables y texto en la salida.
 *
 * 🚀 NIVEL: Básico
 *
 * @author VJUAN3130
 */

import java.util.Scanner;

public class TablaMultiplicar
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println(" === Generador de Tablas de Multiplicar ===");
        System.out.print("\n¿Qué tabla de multiplicar desea ver? Ingrese un número: ");

        int numeroElegido = teclado.nextInt();

        System.out.println("\nCalculando...\n");

        mostrarTablaCompleta(numeroElegido);

        teclado.close();
    }

    public static void mostrarTablaCompleta(int numeroBase)
    {

        System.out.println("============================");
        System.out.println("       TABLA DEL " + numeroBase);
        System.out.println("============================");

        for (int multiplicador = 1; multiplicador <= 10; multiplicador++)
        {

            int resultado = numeroBase * multiplicador;

            System.out.println("    " + numeroBase + " x " + multiplicador + " = " + resultado);
        }

        System.out.println("============================");
    }
}
