import java.util.Scanner;
public class CuotaAdministracion
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        double area, tarifaPorM2 = 3500, cuota;

        System.out.println("-- Cuota de administracion --");
        System.out.print("Area del apartamento (m2): ");
        area = teclado.nextDouble();
        cuota = area * tarifaPorM2;

        System.out.printf("Cuota de administracion a pagar: $ %.0f %n", cuota);

        teclado.close();
    }
}
