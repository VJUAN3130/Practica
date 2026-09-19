import java.util.Scanner;
public class PagoEmpleado
{
    public static void main(String[] args)
    {

        Scanner teclado = new Scanner(System.in);

        double sueldoBase;
        int horasExtra;
        double pagoHorasExtra;
        double pagoTotal;

        System.out.println("Ingrese el sueldo base:");
        sueldoBase = teclado.nextDouble();

        System.out.println("Ingrese las horas extra:");
        horasExtra = teclado.nextInt();

        if (horasExtra > 0)
        {
            System.out.println("Ingrese el pago de las horas extra con recargo:");
            pagoHorasExtra = teclado.nextDouble();

            pagoTotal = sueldoBase + pagoHorasExtra;
        } else
        {
            pagoTotal = sueldoBase;
        }
        System.out.println("El pago total es: " + pagoTotal);
        teclado.close();
    }
}
