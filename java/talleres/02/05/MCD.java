/*
Enunciado: Lea cuántos colegios va a consultar y la cantidad de estudiantes matriculados en
cada uno; calcule el total y el promedio.
Resultado esperado: Con 450, 620, 380: total = 1450, promedio ≈ 483.3
*/

import java.util.Scanner;
public class MCD
{
    public static void main(String[] args)
    {
        int numColegios = 0, totalEstudiantes = 0, total = 0;
        double promedio = 0.0;

        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println(" ===Matrícula en colegios del Distrito===");
            System.out.println("-------------------------------------------");

                while (true)
                {
                    System.out.println("\nIngrese la cantidad de colegios que van a reportar: ");
                    if (teclado.hasNextInt())
                    {
                        numColegios = teclado.nextInt();
                        if (numColegios >=0)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("\n[!] Error: La cantidad debe ser mayor a cero.");
                        }
                    }
                    else
                    {
                        System.out.println("\n[!] Error: Por favor ingrese un número entero válido (sin letras).");
                        teclado.next();
                    }
                }
                System.out.println("------------------------------------------------");

                for (int i = 1; i <= numColegios; i++)
                {
                    boolean datoValido = false;
                    while (!datoValido)
                    {
                        System.out.println("\nIngrese la cantidad de estudiantes del colegio " + i + " de " + numColegios + ": ");
                        if (teclado.hasNextInt())
                        {
                            totalEstudiantes = teclado.nextInt();
                            datoValido = true;
                        }
                        else
                        {
                            System.out.println("\n[!] Error: Formato incorrecto. Use formato numérico (ej: 7).");
                            teclado.next();
                        }
                        System.out.println("------------------------------------------------");
                    }
                    total += totalEstudiantes;
                }

                System.out.println("\n=============RESSULTADOS===================");
                System.out.println("El promedio de estudiantes por colegio es: " + total / numColegios);
                System.out.println("El total de estudiantes es: " + total);
                System.out.println("El número de colegios es: " + numColegios);
                System.out.println("===========================================");
        }

    }
}
