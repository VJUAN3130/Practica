import java.util.Scanner;
public class Diasiniva
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        boolean dia_sinIva;
        double preciop, topep = 800000;

        System.out.println(" Bienvenido al sistema de dia sin IVA ");
        System.out.println("--------------------------------------");
        System.out.println("");
        System.out.print("Es dia sin IVA? (true/false): ");
        dia_sinIva = teclado.nextBoolean();
        System.out.println("");
        System.out.print("Precio del producto: ");
        preciop = teclado.nextDouble();

        if (dia_sinIva && preciop < topep)
        {
            System.out.println("Producto exento de IVA");
        }
        else
        {
            System.out.println("Resultado: NO EXENTO de IVA");
        }
        teclado.close();
    }
}
