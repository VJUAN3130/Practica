import java.util.Scanner;
public class propinarestaurante
{
    public static void main(String[] args)
    {        Scanner teclado = new Scanner(System.in);
        double valorcuenta, propina, total;

        System.out.println("-- Bienvenido --");
        System.out.print("valor de la cuenta: ");
        valorcuenta = teclado.nextDouble();
        propina = valorcuenta * 0.10;
        total = valorcuenta + propina;

        System.out.printf("propina sugerida: $ %.0f %n", propina);
        System.out.printf("total a pagar: $ %.0f %n", total);

        teclado.close();
    }
}
