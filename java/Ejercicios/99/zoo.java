import java.util.Scanner;

public class zoo
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int n, i, edad, tarifa = 0, total = 0;

        System.out.println("=========================");
        System.out.println(" Bienvenido al zoológico");
        System.out.println("=========================");
        System.out.println("¿Cuántos visitantes son?");
        n = teclado.nextInt();

        for (i = 1; i <= n; i++)
        {
            System.out.print("\nIngrese la edad del visitante " + i + ": ");
            edad = teclado.nextInt();

            // Usamos 'else if' para tener una estructura más limpia
            if (edad >= 0 && edad <= 4)
            {
                tarifa = 8000;
            } else if (edad >= 5 && edad <= 12)
            {
                tarifa = 12000;
            } else if (edad >= 13 && edad <= 60)
            {
                tarifa = 15000;
            } else
            {
                // Manejo de edades inválidas o mayores de 60
                System.out.println("No cumples con la edad requerida o la edad es inválida.");
                i--; // Restamos 1 a la 'i' para que vuelva a pedir los datos de este mismo visitante
                continue; // Salta el resto del ciclo y vuelve a empezar
            }

            total += tarifa; // Solo suma si la edad fue válida
            System.out.println("Tarifa asignada: $" + tarifa);
        }

        teclado.close();

        System.out.println("\n=============================================");
        System.out.println("El total a pagar por los " + n + " visitantes es: $" + total);
        System.out.println("=============================================");
    }
}
