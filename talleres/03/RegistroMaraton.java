import java.util.Scanner;
import java.util.Locale;

public class RegistroMaraton {

    // 1. REGLAS DE NEGOCIO (Constantes)
    private static final int EDAD_MIN_MARATON = 18;
    private static final int MAX_JUVENIL = 19;
    private static final int MAX_ADULTO = 39;
    private static final int MAX_MASTER = 49;
    private static final int EDAD_MAX_PERMITIDA = 100;

    private static final double DISTANCIA_MARATON = 42.195; // Km oficiales

    public static void main(String[] args) {
        String categoria = "";

        try (Scanner teclado = new Scanner(System.in)) {
            teclado.useLocale(Locale.US); // Evitamos el problema de la coma y el punto

            System.out.println("=== SISTEMA DE REGISTRO - MARATÓN BARRANQUILLA ===");

            // 2. ENTRADA DE DATOS (Usando métodos Pro para no repetir código)
            System.out.print("Nombre del corredor: ");
            String nombre = teclado.nextLine();

            System.out.print("Documento de identidad: ");
            String documentoIdentidad = teclado.nextLine();

            // Llamamos a nuestra herramienta defensiva para pedir enteros y decimales seguros
            int edad = leerEntero(teclado, "Edad del corredor: ", EDAD_MIN_MARATON, EDAD_MAX_PERMITIDA);
            int numeroDorsal = leerEntero(teclado, "Número de dorsal: ", 1, 99999);

            double kmEntrenamiento = leerDecimal(teclado, "Kilómetros de entrenamiento previos: ", 0, 1000);
            double tiempoParcial21 = leerDecimal(teclado, "Tiempo parcial en km 21 (horas): ", 0.5, 5.0);
            double tiempoFinal = leerDecimal(teclado, "Tiempo final (horas): ", 1.5, 10.0);

            // 3. PROCESAMIENTO (Lógica pura, sin interrupciones visuales)
            if (edad <= MAX_JUVENIL) {
                categoria = "Juvenil";
            } else if (edad <= MAX_ADULTO) {
                categoria = "Adulto";
            } else if (edad <= MAX_MASTER) {
                categoria = "Máster";
            } else {
                categoria = "Gran Máster";
            }

            // Cálculo del rendimiento: Minutos que tarda en hacer un solo kilómetro (Pace)
            // Multiplicamos por 60 para convertir las horas en minutos
            double ritmoPromedio = (tiempoFinal * 60) / DISTANCIA_MARATON;

            // 4. SALIDA: El Dashboard Final
            System.out.println("\n================= FICHA DEL CORREDOR =================");
            System.out.println("Corredor       : " + nombre + " (ID: " + documentoIdentidad + ")");
            System.out.println("Dorsal         : #" + numeroDorsal);
            System.out.println("Edad           : " + edad + " años");
            System.out.println("Categoría      : " + categoria);
            System.out.println("------------------------------------------------------");
            System.out.println("Km entrenados  : " + kmEntrenamiento + " km");
            System.out.println("Tiempo medio   : " + tiempoParcial21 + " h");
            System.out.println("Tiempo final   : " + tiempoFinal + " h");
            System.out.printf("Rendimiento    : %.2f min/km (Ritmo Promedio)\n", ritmoPromedio);
            System.out.println("======================================================");

        } catch (Exception e) {
            System.err.println("[!] Error fatal en el sistema: " + e.getMessage());
        }
    }

    // =================================================================================
    // MÉTODOS UTILITARIOS (Ocultamos toda la validación compleja aquí abajo)
    // =================================================================================

    private static int leerEntero(Scanner scanner, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine(); // Consumir el "Enter" residual para que no salte líneas después
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("  [!] Error: El valor debe estar entre " + min + " y " + max + ".");
            } else {
                System.out.println("  [!] Error: Formato incorrecto. Ingrese un número válido sin letras.");
                scanner.next(); // Limpiar el error del buffer
            }
        }
    }

    private static double leerDecimal(Scanner scanner, String mensaje, double min, double max) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consumir el "Enter" residual
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("  [!] Error: El valor debe estar entre " + min + " y " + max + ".");
            } else {
                System.out.println("  [!] Error: Formato incorrecto. Ingrese un número válido.");
                scanner.next();
            }
        }
    }
}
