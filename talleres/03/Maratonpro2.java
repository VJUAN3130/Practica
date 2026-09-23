import java.util.Scanner;

public class Maratonpro2
{
    public static void main(String[] args)
    {
        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println(" === Maraton de Barranquilla ===");
            System.out.println("---------------------------------");

            LectorDatos lector = new LectorDatos(teclado);
            Corredor corredor = lector.registrarCorredor();

            corredor.mostrarFicha();
        }
    }
}

/**
 * Representa a un corredor con todos sus datos y el comportamiento
 * que le corresponde a él mismo: clasificarse, calcular su velocidad,
 * mostrar su ficha. Ya no son variables sueltas viajando entre métodos,
 * son datos y comportamiento que viven juntos en un objeto.
 */
class Corredor
{
    private static final int MAX_JUVENIL = 19;
    private static final int MAX_ADULTO = 39;
    private static final int MAX_MASTER = 49;
    private static final double DISTANCIA_MARATON = 42.195;
    private static final double LIMITE_TIEMPO_HORAS = 6.0;

    private final String nombre;
    private final String documento;
    private final int edad;
    private final int dorsal;
    private final double kmEntrenamiento;
    private final double tiempoParcial21;
    private final double tiempoFinal;

    public Corredor(String nombre, String documento, int edad, int dorsal,
            double kmEntrenamiento, double tiempoParcial21, double tiempoFinal)
    {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.dorsal = dorsal;
        this.kmEntrenamiento = kmEntrenamiento;
        this.tiempoParcial21 = tiempoParcial21;
        this.tiempoFinal = tiempoFinal;
    }

    public String clasificarPorEdad()
    {
        if (edad <= MAX_JUVENIL) return "Juvenil";
        if (edad <= MAX_ADULTO) return "Adulto";
        if (edad <= MAX_MASTER) return "Master";
        return "Gran Master";
    }

    public char calcularLetraCategoria()
    {
        switch (clasificarPorEdad())
        {
            case "Juvenil": return 'A';
            case "Adulto": return 'B';
            case "Master": return 'C';
            default: return 'D';
        }
    }

    public boolean completoDentroDelLimite()
    {
        return tiempoFinal <= LIMITE_TIEMPO_HORAS;
    }

    public double calcularVelocidadPromedio()
    {
        return DISTANCIA_MARATON / tiempoFinal;
    }

    public void mostrarFicha()
    {
        System.out.println("\n================ Ficha del Corredor ================");
        System.out.println("Nombre                 : " + nombre);
        System.out.println("Documento de identidad  : " + documento);
        System.out.println("Edad                    : " + edad + " años");
        System.out.println("Numero de dorsal        : " + dorsal);
        System.out.printf("Km de entrenamiento     : %.2f km%n", kmEntrenamiento);
        System.out.printf("Tiempo parcial (km 21)  : %.2f horas%n", tiempoParcial21);
        System.out.printf("Tiempo final             : %.2f horas%n", tiempoFinal);
        System.out.println("Categoria de edad       : " + clasificarPorEdad());
        System.out.println("Letra de categoria      : " + calcularLetraCategoria());
        System.out.println("Dentro del limite (6h)  : " + (completoDentroDelLimite() ? "Sí" : "No"));
        System.out.printf("Velocidad promedio      : %.2f km/h%n", calcularVelocidadPromedio());
        System.out.println("======================================================");
    }
}

/**
 * Se encarga solo de leer y validar datos desde el teclado,
 * y con ellos construir un Corredor. No sabe nada de categorías
 * ni de cómo se calcula la velocidad — esa lógica es del Corredor.
 */
class LectorDatos
{
    private static final int EDAD_MIN_MARATON = 18;
    private static final int EDAD_MAX_PERMITIDA = 100;

    private final Scanner teclado;

    public LectorDatos(Scanner teclado)
    {
        this.teclado = teclado;
    }

    public Corredor registrarCorredor()
    {
        String nombre = leerTexto("Ingrese su nombre: ", false);
        String documento = leerTexto("Documento de identidad: ", true);
        int edad = leerEntero("Edad: ", EDAD_MIN_MARATON, EDAD_MAX_PERMITIDA);
        int dorsal = leerEntero("Numero de dorsal: ", 1, 99999);
        double km = leerDouble("Kilometros de entrenamiento: ", 0, 10000);
        double parcial21 = leerDouble("Tiempo parcial en el km 21 (horas): ", 0, 24);
        double tiempoFinal = leerDouble("Tiempo final de la maraton (horas): ", 0, 24);

        return new Corredor(nombre, documento, edad, dorsal, km, parcial21, tiempoFinal);
    }

    private String leerTexto(String mensaje, boolean permitirNumeros)
    {
        while (true)
        {
            System.out.print(mensaje);
            String valor = teclado.nextLine().trim();

            if (valor.isEmpty())
            {
                System.out.println("[!] Error: El campo no puede estar vacío.");
            }
            else if (!permitirNumeros && valor.matches(".*\\d.*"))
            {
                System.out.println("[!] Error: Este campo no puede contener números.");
            }
            else
            {
                return valor;
            }
        }
    }

    private int leerEntero(String mensaje, int min, int max)
    {
        while (true)
        {
            System.out.print(mensaje);

            if (!teclado.hasNextInt())
            {
                System.out.println("[!] Error: Ingrese un número entero válido.");
                teclado.next();
                continue;
            }

            int valor = teclado.nextInt();
            teclado.nextLine();

            if (valor < min || valor > max)
            {
                System.out.println("[!] Error: El valor debe estar entre " + min + " y " + max + ".");
                continue;
            }

            return valor;
        }
    }

    private double leerDouble(String mensaje, double min, double max)
    {
        while (true)
        {
            System.out.print(mensaje);

            if (!teclado.hasNextDouble())
            {
                System.out.println("[!] Error: Ingrese un número válido (use punto decimal).");
                teclado.next();
                continue;
            }

            double valor = teclado.nextDouble();
            teclado.nextLine();

            if (valor < min || valor > max)
            {
                System.out.println("[!] Error: El valor debe estar entre " + min + " y " + max + ".");
                continue;
            }

            return valor;
        }
    }
}
