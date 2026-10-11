import java.util.Scanner;
public class Nr
{
    private static final int MIN_ROMANO = 1;
    private static final int MAX_ROMANO = 5;

    public static void main(String[] args)
    {
        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println("=== Conversor de Números Romanos (1 al 5) ===");

            int numero = leerNumeroSeguro(teclado);

            String resultadoRomano = obtenerRomano(numero);

            System.out.println("Equivalente romano: " + resultadoRomano);
        }
    }

    private static int leerNumeroSeguro(Scanner scanner)
    {
        int valor;
        while (true)
        {
            System.out.print("Introduce un número del 1 al 5: ");
            if (scanner.hasNextInt())
            {
                valor = scanner.nextInt();
                if (valor >= MIN_ROMANO && valor <= MAX_ROMANO)
                {
                    return valor;
                }
                System.out.println("[!] Error: El número debe estar estrictamente entre 1 y 5.\n");
            }
            else
            {
                System.out.println("[!] Error: Formato incorrecto. Ingrese solo números enteros.\n");
                scanner.next();
            }
        }
    }

    private static String obtenerRomano(int num)
    {
        switch (num)
        {
            case 1:  return "I";
            case 2:  return "II";
            case 3:  return "III";
            case 4:  return "IV";
            case 5:  return "V";
            default: return "Número no válido";
        }
    }
}
