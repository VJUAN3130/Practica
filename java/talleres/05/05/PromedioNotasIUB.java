/**
 * 📝 ENUNCIADO:
 * Calcular el promedio de tres notas de un estudiante de la IUB.
 *
 * 🎯 OBJETIVO / TEMAS:
 * - Creación de funciones con retorno numérico (double).
 * - Manejo de múltiples parámetros.
 * - Operaciones aritméticas y jerarquía de operadores (uso de paréntesis).
 *
 * 🚀 NIVEL: Básico
 *
 * @author VJUAN3130
 */

import java.util.Scanner;
public class PromedioNotasIUB
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println(" === Sistema de Calificaciones IUB ===");
        System.out.print("Ingrese la primera nota: ");
        double nota1 = teclado.nextDouble();
        System.out.print("Ingrese la segunda nota: ");
        double nota2 = teclado.nextDouble();
        System.out.print("Ingrese la tercera nota: ");
        double nota3 = teclado.nextDouble();
        System.out.println("\nProcesando notas...\n");

        double promedioFinal = calcularPromedio(nota1, nota2, nota3);

        System.out.println("El promedio definitivo del estudiante es: " + promedioFinal);

        if (promedioFinal >= 3.0) {
            System.out.println("Estado: APROBADO ✅");
        }
        else
        {
            System.out.println("Estado: REPROBADO ❌");
        }

        teclado.close();
    }

    public static double calcularPromedio(double n1, double n2, double n3)
    {
        double sumaTotal = (n1 + n2 + n3);
        double promedio = sumaTotal / 3.0;

        return promedio;
    }
}
