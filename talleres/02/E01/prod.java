import java.util.Scanner;
public class prod
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        double produ, total = 0;
        int i, mr = 0;

        System.out.println("==============================================================");
        System.out.println(" Bienvenido al sistema de reporte de producción por municipio");
        System.out.println("==============================================================");
        System.out.println("\nCuantos municipios reportaron?");
        mr = teclado.nextInt();

        for (i = 1; i <= mr; i++)
        {
            System.out.println("\nIngrese la producción en toneladas del municipio " + i + ": ");
            produ = teclado.nextDouble();
            total += produ;
        }
        System.out.print("\nEl total de producción es: " + total + " toneladas");
        teclado.close();
        System.out.print(", y la cantidad de municipios que reportaron es: " + mr + "");
    }
}
