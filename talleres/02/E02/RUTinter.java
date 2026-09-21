/*
Enunciado: Lea cuántos tramos tiene una ruta (Barranquilla–Sabanalarga–Sabanagrande–Santo
Tomás) y la distancia de cada tramo; calcule la distancia total.
Resultado esperado: Con tramos 25, 12, 8 km: distancia total = 45 km
*/
package E02;
import java.util.Scanner;
public class RUTinter
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        double dist, disTotal = 0;
        int tramos = 0, i;

        System.out.println("========================================================");
        System.out.println(" Bienvenido al sistema de cálculo de tramos + distancia");
        System.out.println("========================================================");
        System.out.println("\nIngrese la cantidad de tramos: ");
        tramos = teclado.nextInt();

        for (i = 1; i <= tramos; i++)
        {
            System.out.println("\nIngrese la distancia del tramo en km (" + i + "): ");
            dist = teclado.nextDouble();
            disTotal += dist;
        }

        System.out.print("\nDistancia total: " + disTotal + " km");
        System.out.print(" y la cantidad de tramos: " + tramos + ".");
        teclado.close();
    }
}
