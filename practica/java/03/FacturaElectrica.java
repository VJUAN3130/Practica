import java.util.Scanner;
public class FacturaElectrica

{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int estrato;
        double consumokwh, tarifabase, valorfactura;

        tarifabase = 800;

        System.out.println(" Bienvenido al sistema de facturacción electrica por estrato");
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
        System.out.print("Ingrese su estrato socioeconimco: ");
        estrato = teclado.nextInt();
        System.out.println("");
        System.out.print("Consumo del mes en kWh: ");
        consumokwh = teclado.nextDouble();

        if (estrato == 1)

        {
            valorfactura = consumokwh * tarifabase * 0.60;
        }
        else if (estrato == 2)
        {
            valorfactura = consumokwh * tarifabase * 0.85;
        }
        else if (estrato == 3 || estrato == 4)
        {
            valorfactura = consumokwh * tarifabase;
        }
        else if (estrato == 5)
        {
            valorfactura = consumokwh * tarifabase * 1.20;
        }
        else
        {
            valorfactura = consumokwh * tarifabase * 1.30;
        }
        System.out.printf("Valor de la factura: $%.2f%n", valorfactura);
        teclado.close();
    }
}
