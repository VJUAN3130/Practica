import java.util.Scanner;
public class OHC
{
    private static final int DIAS = 4;
    private static final double MAX_OCUPACION = 100;
    private static final double MIN_OCUPACION = 0;

    public static void main(String[] args)
    {
        double sumaOcupacion = 0;
        double ocupacionDia = 0;

        try (Scanner teclado = new Scanner(System.in))
        {
            System.out.println(" === Porcentaje de ocupación en días de carnavales ===");
            System.out.println("-------------------------------------------------------");

            for (int i = 1; i <= DIAS; i++)
            {
                // CORRECCIÓN: La variable se declara y reinicia a false cada vez que inicia un nuevo día
                boolean datosValido = false;

                while (!datosValido)
                {
                    // MEJORA: Se incluye la variable 'i' para indicar qué día se está evaluando
                    System.out.print("\nIngrese el porcentaje de ocupación del día " + i + ": ");
                    if (teclado.hasNextDouble())
                    {
                        ocupacionDia = teclado.nextDouble();

                        if (ocupacionDia >= MIN_OCUPACION && ocupacionDia <= MAX_OCUPACION)
                        {
                            datosValido = true;
                        }
                        else
                        {
                            System.out.println("[!] Error: El porcentaje debe estar entre 0 y 100.");
                        }
                    }
                    else
                    {
                        System.out.println("[!] Error: Por favor ingrese un número válido (sin letras).");
                        teclado.next();
                    }
                }

                sumaOcupacion += ocupacionDia;
            }

            double promedio = sumaOcupacion / DIAS;
            System.out.println("\n================ Resumen ================");
            System.out.println("Días evaluados        : " + DIAS);
            System.out.println("Promedio de ocupación : " + promedio + " %");
            System.out.println("=========================================");

        }
        catch (Exception e)
        {
            System.err.println("Ocurrió un error en el sistema: " + e.getMessage());
        }
    }
}
