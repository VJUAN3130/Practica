import java.util.Scanner;

public class Maratonpro
{
    private static final int EDAD_MIN_MARATON = 18;
    private static final int MAX_JUVENIL = 19;
    private static final int MAX_ADULTO = 39;
    private static final int MAX_MASTER = 49;
    private static final int EDAD_MAX_PERMITIDA = 100;

    private static final double DISTANCIA_MARATON = 42.195; // km
    private static final double LIMITE_TIEMPO_HORAS = 6.0;

    public static void main(String[] args)
    {
        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println(" === Maraton de Barranquilla ===");
            System.out.println("---------------------------------");

            // -------- Captura de datos (usando los métodos reutilizables) --------
            String nombre = leerTexto(teclado, "Ingrese su nombre: ", false);
            String documentoIdentidad = leerTexto(teclado, "Documento de identidad: ", true);
            int edad = leerEntero(teclado, "Edad: ", EDAD_MIN_MARATON, EDAD_MAX_PERMITIDA);
            int numeroDorsal = leerEntero(teclado, "Numero de dorsal: ", 1, 99999);
            double kmEntrenamiento = leerDouble(teclado, "Kilometros de entrenamiento: ", 0, 10000);
            double tiempoParcial21 = leerDouble(teclado, "Tiempo parcial en el km 21 (horas): ", 0, 24);
            double tiempoFinal = leerDouble(teclado, "Tiempo final de la maraton (horas): ", 0, 24);

            // -------- Lógica de negocio --------
            String categoriaEdad = clasificarPorEdad(edad);
            char letraCategoria = calcularLetraCategoria(categoriaEdad);
            boolean dentroDelLimite = tiempoFinal <= LIMITE_TIEMPO_HORAS;
            double velocidadPromedio = DISTANCIA_MARATON / tiempoFinal;

            // -------- Ficha final --------
            mostrarFicha(nombre, documentoIdentidad, edad, numeroDorsal, kmEntrenamiento,
                    tiempoParcial21, tiempoFinal, categoriaEdad, letraCategoria,
                    dentroDelLimite, velocidadPromedio);
        }
    }

    // ==================== MÉTODOS DE LECTURA REUTILIZABLES ====================

    /**
     * Lee una línea de texto validando que no esté vacía.
     * Si permitirNumeros es false, también rechaza textos que contengan dígitos
     * (útil para nombre; para documento sí se permiten números).
     */
    private static String leerTexto(Scanner teclado, String mensaje, boolean permitirNumeros)
    {
        while (true)
        {
            System.out.print(mensaje);
            String valor = teclado.nextLine().trim();

            if (valor.isEmpty())
            {
                System.out.println("\n[!] Error: El campo no puede estar vacío.\n");
            }
            else if (!permitirNumeros && valor.matches(".*\\d.*"))
            {
                System.out.println("\n[!] Error: Este campo no puede contener números.\n");
            }
            else
            {
                return valor;
            }
        }
    }

    /** Lee un entero validando que esté dentro de un rango [min, max]. */
    private static int leerEntero(Scanner teclado, String mensaje, int min, int max)
    {
        while (true)
        {
            System.out.print(mensaje);

            if (!teclado.hasNextInt())
            {
                System.out.println("\n[!] Error: Ingrese un número entero válido.\n");
                teclado.next();
                continue;
            }

            int valor = teclado.nextInt();
            teclado.nextLine(); // limpia el salto de línea pendiente

            if (valor < min || valor > max)
            {
                System.out.println("\n[!] Error: El valor debe estar entre " + min + " y " + max + ".\n");
                continue;
            }

            return valor;
        }
    }

    /** Lee un decimal validando que esté dentro de un rango [min, max]. */
    private static double leerDouble(Scanner teclado, String mensaje, double min, double max)
    {
        while (true)
        {
            System.out.print(mensaje);

            if (!teclado.hasNextDouble())
            {
                System.out.println("\n[!] Error: Ingrese un número válido (use punto decimal).\n");
                teclado.next();
                continue;
            }

            double valor = teclado.nextDouble();
            teclado.nextLine();

            if (valor < min || valor > max)
            {
                System.out.println("\n[!] Error: El valor debe estar entre " + min + " y " + max + ".\n");
                continue;
            }

            return valor;
        }
    }

    // ==================== LÓGICA DE NEGOCIO ====================

    private static String clasificarPorEdad(int edad)
    {
        if (edad <= MAX_JUVENIL)
        {
            return "Juvenil";
        }
        else if (edad <= MAX_ADULTO)
        {
            return "Adulto";
        }
        else if (edad <= MAX_MASTER)
        {
            return "Master";
        }
        else
        {
            return "Gran Master";
        }
    }

    private static char calcularLetraCategoria(String categoriaEdad)
    {
        switch (categoriaEdad)
        {
            case "Juvenil":
                return 'A';
            case "Adulto":
                return 'B';
            case "Master":
                return 'C';
            default: // Gran Master
                return 'D';
        }
    }

    // ==================== SALIDA ====================

    private static void mostrarFicha(String nombre, String documento, int edad, int dorsal,
            double kmEntrenamiento, double tiempoParcial21, double tiempoFinal,
            String categoriaEdad, char letraCategoria, boolean dentroDelLimite,
            double velocidadPromedio)
    {
        System.out.println("\n================ Ficha del Corredor ================");
        System.out.println("Nombre                 : " + nombre);
        System.out.println("Documento de identidad  : " + documento);
        System.out.println("Edad                    : " + edad + " años");
        System.out.println("Numero de dorsal        : " + dorsal);
        System.out.printf("Km de entrenamiento     : %.2f km%n", kmEntrenamiento);
        System.out.printf("Tiempo parcial (km 21)  : %.2f horas%n", tiempoParcial21);
        System.out.printf("Tiempo final             : %.2f horas%n", tiempoFinal);
        System.out.println("Categoria de edad       : " + categoriaEdad);
        System.out.println("Letra de categoria      : " + letraCategoria);
        System.out.println("Dentro del limite (6h)  : " + (dentroDelLimite ? "Sí" : "No"));
        System.out.printf("Velocidad promedio      : %.2f km/h%n", velocidadPromedio);
        System.out.println("======================================================");
    }
}
