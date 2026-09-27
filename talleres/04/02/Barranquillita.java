import java.util.Scanner;

public class Barranquillita 
{

    public enum NivelVentas { BAJA, MEDIA, ALTA }
    private static final long META_DIARIA = 500000L;

    public static void main(String[] args) 
    {
        String nombreProducto;
        short numeroPuesto;
        int cantidadVendida;
        float precioUnitario;
        long totalVentas;
        boolean registradoFormalmente;
        boolean superoMeta;
        double impuestoCalculado;
        char categoriaVenta;
        NivelVentas nivel;

        try (Scanner teclado = new Scanner(System.in)) 
        {
            System.out.println("=== Puesto Barranquillita ===");
            System.out.print("Producto: "); nombreProducto = teclado.nextLine();
            System.out.print("Puesto #: "); numeroPuesto = teclado.nextShort();
            System.out.print("Cantidad vendida: "); cantidadVendida = teclado.nextInt();
            System.out.print("Precio unitario: $"); precioUnitario = teclado.nextFloat();
            System.out.print("¿Registrado formalmente? (true/false): "); registradoFormalmente = teclado.nextBoolean();

            totalVentas = (long) (cantidadVendida * precioUnitario);
            superoMeta = totalVentas > META_DIARIA;
            impuestoCalculado = registradoFormalmente ? (totalVentas * 0.05) : 0.0;

            if (totalVentas < 200000) 
            {
                nivel = NivelVentas.BAJA;
                categoriaVenta = 'B';
            }
            else if (totalVentas < META_DIARIA) 
            {
                nivel = NivelVentas.MEDIA;
                categoriaVenta = 'M';
            }
            else 
            {
                nivel = NivelVentas.ALTA;
                categoriaVenta = 'A';
            }

            System.out.println("\n--- Ficha ---");
            System.out.println("Producto: " + nombreProducto + " | Total: $" + totalVentas);
            System.out.println("Nivel: " + nivel + " [" + categoriaVenta + "]");
            System.out.println("Impuesto: $" + impuestoCalculado + " | Superó meta: " + superoMeta);
        }
    }
}
