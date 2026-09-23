import java.util.Scanner;

public class Transmetro
{

    public enum TipoUsuario { NORMAL, ESTUDIANTE, ADULTO_MAYOR }

    private static final float TARIFA_BASE = 2500.0f;

    public static void main(String[] args)
    {
        String nombrePasajero;
        long numeroTarjeta;
        byte edad;
        boolean esEstudiante;
        boolean alcanzaSaldo;
        double saldoActual;
        float tarifaCalculada;
        char letraCategoria;
        TipoUsuario tipo;

        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println("=== Transmetro ===");
            System.out.println("\nIngrese los datos del pasajero:");
            System.out.print("Nombre: ");
            nombrePasajero = teclado.nextLine();
            System.out.print("Número de tarjeta: ");
            numeroTarjeta = teclado.nextLong();
            System.out.print("Edad: ");
            edad = teclado.nextByte();
            System.out.print("Es estudiante? (true/false): ");
            esEstudiante = teclado.nextBoolean();
            System.out.print("Saldo actual: ");
            saldoActual = teclado.nextDouble();



            System.out.println("Pasajero: " + nombrePasajero + " | Tarifa: " + tarifaCalculada + " | Categoría: " + letraCategoria);
        }
    }
}
