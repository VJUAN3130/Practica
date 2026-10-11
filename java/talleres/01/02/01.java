import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class PagoEmpleado {

    // Constantes de negocio (Jornada mensual estándar y recargo extra del 25%)
    private static final BigDecimal HORAS_MES_LABORALES = new BigDecimal("240");
    private static final BigDecimal FACTOR_HORA_EXTRA = new BigDecimal("1.25");

    /**
     * Modelo de dominio inmutable para la nómina de un empleado.
     */
    public record Nomina(BigDecimal sueldoBase, int horasExtra) {
        public Nomina {
            if (sueldoBase == null || sueldoBase.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException("El sueldo base debe ser un valor positivo.");
            }
            if (horasExtra < 0) {
                throw new IllegalArgumentException("Las horas extras no pueden ser negativas.");
            }
        }

        public BigDecimal valorHoraOrdinaria() {
            return sueldoBase.divide(HORAS_MES_LABORALES, 4, RoundingMode.HALF_UP);
        }

        public BigDecimal pagoHorasExtra() {
            if (horasExtra == 0) return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
            return valorHoraOrdinaria()
                    .multiply(BigDecimal.valueOf(horasExtra))
                    .multiply(FACTOR_HORA_EXTRA)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        public BigDecimal pagoTotal() {
            return sueldoBase.add(pagoHorasExtra()).setScale(2, RoundingMode.HALF_UP);
        }
    }

    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            BigDecimal sueldoBase = leerMontoPositivo(teclado, "Ingrese el sueldo base: ");
            int horasExtra = leerEnteroPositivo(teclado, "Ingrese las horas extra trabajadas: ");

            Nomina nomina = new Nomina(sueldoBase, horasExtra);
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.of("es", "CO"));

            imprimirResumen(nomina, formatoMoneda);

        } catch (Exception e) {
            System.err.println("Error crítico en la ejecución del sistema: " + e.getMessage());
        }
    }

    private static void imprimirResumen(Nomina nomina, NumberFormat fmt) {
        System.out.println("\n=================================");
        System.out.println("       LIQUIDACIÓN DE PAGO       ");
        System.out.println("=================================");
        System.out.println("Sueldo Base:        " + fmt.format(nomina.sueldoBase()));
        System.out.println("Valor Hora Normal:  " + fmt.format(nomina.valorHoraOrdinaria()));
        System.out.println("Horas Extra (" + nomina.horasExtra() + "h):  " + fmt.format(nomina.pagoHorasExtra()));
        System.out.println("---------------------------------");
        System.out.println("PAGO TOTAL NETO:    " + fmt.format(nomina.pagoTotal()));
        System.out.println("=================================");
    }

    private static BigDecimal leerMontoPositivo(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                BigDecimal valor = new BigDecimal(entrada);
                if (valor.compareTo(BigDecimal.ZERO) >= 0) {
                    return valor;
                }
                System.out.println(" Error: El valor no puede ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println(" Error: Ingrese un valor numérico válido (ej. 1300000.00).");
            }
        }
    }

    private static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= 0) {
                    return valor;
                }
                System.out.println(" Error: Las horas no pueden ser negativas.");
            } catch (NumberFormatException e) {
                System.out.println(" Error: Ingrese un número entero válido.");
            }
        }
    }
}
