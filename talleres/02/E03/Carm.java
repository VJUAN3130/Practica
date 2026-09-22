import java.util.Scanner;
public class Carm
{

    // 1. CONSTANTES: Evitamos los "Magic Numbers".
    // Si la norma ambiental cambia mañana, solo editas aquí, no tienes que buscar por todo el código.
    private static final double MIN_PH = 6.5;
    private static final double MAX_PH = 8.5;

    public static void main(String[] args)
    {
        int fueraDeRango = 0;
        int cantidadMediciones = 0;

        // 2. TRY-WITH-RESOURCES: Instancia el Scanner y garantiza que se cierre automáticamente al final,
        // pase lo que pase (incluso si el programa crashea). Previene fugas de memoria.
        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println("=== Monitor de Calidad de Agua (pH) ===\n");

            // 3. VALIDACIÓN ESTRICTA (Defensive Programming): Evita que el usuario rompa el sistema ingresando letras o números negativos.
            while (true)
            {
                System.out.print("Ingrese la cantidad de mediciones a procesar: ");
                if (teclado.hasNextInt())
                {
                    cantidadMediciones = teclado.nextInt();
                    if (cantidadMediciones > 0)
                    {
                        break; // Dato válido, salimos del bucle
                    }
                    else
                    {
                        System.out.println("[!] Error: La cantidad debe ser mayor a cero.");
                    }
                }
                else
                {
                    System.out.println("[!] Error: Por favor ingrese un número entero válido (sin letras).");
                    teclado.next(); // Limpia la entrada basura del buffer para evitar un bucle infinito
                }
            }

            System.out.println("------------------------------------------------");

            for (int i = 1; i <= cantidadMediciones; i++)
            {
                double medicion = 0;
                boolean datoValido = false;

                // Validación para cada medición de pH (reemplaza el try-catch tradicional)
                while (!datoValido)
                {
                    System.out.print("Ingrese la medición " + i + " de " + cantidadMediciones + ": ");
                    if (teclado.hasNextDouble())
                    {
                        medicion = teclado.nextDouble();
                        datoValido = true;
                    }
                    else
                    {
                        System.out.println("[!] Error: Formato incorrecto. Use formato numérico (ej: 7.2).");
                        teclado.next(); // Limpia el buffer
                    }
                }

                // 4. LECTURA LIMPIA: Delegamos la lógica matemática a una función separada.
                if (esPhFueraDeRango(medicion))
                {
                    fueraDeRango++;
                }
            }

            // 5. REPORTE CLARO: Entregamos la información con el contexto necesario.
            System.out.println("\n================ Resumen ================");
            System.out.println("Total de mediciones procesadas : " + cantidadMediciones);
            System.out.println("Mediciones fuera de rango seguro : " + fueraDeRango);
            System.out.println("Rango establecido como seguro  : [" + MIN_PH + " a " + MAX_PH + "]");
            System.out.println("=========================================");

        }
        catch (Exception e)
        {
            // Captura de pánico global en caso de un error crítico no contemplado
            System.err.println("Ocurrió un error crítico en el sistema: " + e.getMessage());
        }
    }

    // MODULARIDAD (Clean Code): Separamos el 'Qué' (contar) del 'Cómo' (la regla matemática).
    // Esto permite testear la regla de negocio de forma aislada.
    private static boolean esPhFueraDeRango(double ph)
    {
        return ph < MIN_PH || ph > MAX_PH;
    }
}
