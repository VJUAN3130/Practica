import java.util.Scanner;
public class Maraton
{
    private static final int EDAD_MIN_MARATON = 18;
    private static final int MAX_JUVENIL = 19;
    private static final int MAX_ADULTO = 39;
    private static final int MAX_MASTER = 49;
    private static final int EDAD_MAX_PERMITIDA = 100;

    private static final double DISTANCIA_MARATON = 42.195;
    private static final double LIMITE_TIEMPO_HORAS = 6.0;

    public static void main(String[] args)
    {
        String nombre;
        String documentoIdentidad;
        String categoria = "";

        int edad;
        int numeroDorsal;

        double kmEntrenamiento;
        double tiempoParcial21;
        double tiempoFinal;
        double ritmoPromedio;

        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println(" === Maraton de Barranquilla ===");
            System.out.println("---------------------------------");

            while (true)
            {
                System.out.print("Ingrese su nombre: ");
                nombre = teclado.nextLine().trim();

                if (nombre.isEmpty())
                {
                    System.out.println("\n[!] Error: El nombre no puede estar vacío.\n");
                }
                else if (nombre.matches(".*\\d.*"))
                {
                    System.out.println("\n[!] Error: El nombre no puede contener números.\n");
                }
                else
                {
                    break;
                }
            }

            while (true)
            {
                System.out.print("Documento de identidad: ");
                documentoIdentidad = teclado.nextLine();

                if (documentoIdentidad.isEmpty())
                {
                    System.out.println("\n[!] Error: El documento de identidad no puede estar vacío.\n");
                }
                else
                {
                    break;
                }
            }

        }
    }
}
