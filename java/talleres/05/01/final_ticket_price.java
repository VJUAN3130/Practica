/**
 * 📝 ENUNCIADO:
 * Calcular el precio final de una boleta del Carnaval aplicando un descuento.
 *
 * 🎯 OBJETIVO / TEMAS:
 * - Creacion de funciones con retorno
 * - Operaciones aritmeticas basicas
 *
 * 🚀 NIVEL: Básico
 *
 * @author VJUAN3130
 */

import java.util.Scanner;
public class final_ticket_price
{

    private static final double PRICE = 10000;

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        int tickets;
        double total_price;

        System.out.println(" === Bienvenido al carnaval de barranquilla ===");
        System.out.println("-------------------------------------------------");
        System.out.print("\nEl valor de los tickets es de: $" + PRICE + ".");
        System.out.println("\nSi compra más de 5 tickets tendrá un 10% de descuento en el total.");
        System.out.print("\n¿Cuántos tickets quiere? ");

        tickets = teclado.nextInt();

        // Aquí llamamos a la función que hace el cálculo
        total_price = calcularTotalConDescuento(tickets, PRICE);

        System.out.println("\nResumen de su compra:");
        System.out.println("Cantidad de tickets: " + tickets);
        System.out.println("Su total a pagar es de: $" + total_price);

        teclado.close();
    }
    public static double calcularTotalConDescuento (int cantidadTickets, double precioUnitario)
    {
        double subtotal = cantidadTickets * precioUnitario;
        double totalFinal;

        if (cantidadTickets > 5)
        {
            double descuento = subtotal * 0.10;
            totalFinal = subtotal - descuento;
            System.out.println("¡Felicidades! Se ha aplicado un descuento de: $" + descuento);
        } else
        {
            totalFinal = subtotal;
        }

        return totalFinal; // La función RETORNA el valor calculado
    }
}
