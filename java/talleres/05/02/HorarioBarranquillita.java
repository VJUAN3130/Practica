/**
 * 📝 ENUNCIADO:
 * Imprimir en pantalla el horario de atención de un puesto de Barranquillita.
 *
 * 🎯 OBJETIVO / TEMAS:
 * - Creación de procedimientos (métodos void).
 * - Salida de datos por consola (System.out.println).
 * - Manejo de variables de texto (String).
 *
 * 🚀 NIVEL: Básico
 *
 * @author VJUAN3130
 */

import java.util.Scanner;
public class HorarioBarranquillita
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println(" === Central de Abastos: Barranquillita ===");
        System.out.print("Ingrese el nombre del puesto (Ej. Verduras El Primo): ");
        String nombrePuesto = teclado.nextLine();

        System.out.println("\nGenerando cartel informativo...\n");

        imprimirHorario(nombrePuesto);

        teclado.close();
    }

    public static void imprimirHorario(String puesto)
    {
        System.out.println("*************************************************");
        System.out.println("   📍 PUESTO: " + puesto.toUpperCase());
        System.out.println("*************************************************");
        System.out.println(" ⏰ Lunes a Viernes:  4:00 AM - 2:00 PM");
        System.out.println(" ⏰ Sábados y Festivos: 4:00 AM - 12:00 PM");
        System.out.println("*************************************************");
    }
}
