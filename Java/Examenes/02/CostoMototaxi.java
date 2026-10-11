import java.util.Scanner;
public class CostoMototaxi
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        double distanciaKm, tarifaBase = 2000, valorPorKm = 500, total;

        System.out.println("--- Costo de viaje en mototaxi ---");
        System.out.print("Distancia recorrida (km): ");
         distanciaKm = teclado.nextDouble();

         total = tarifaBase + distanciaKm * valorPorKm;

         System.out.printf("Valor del viaje: $ %.0f %n", total);

         teclado.close();
    }
}
