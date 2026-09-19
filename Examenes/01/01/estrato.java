import java.util.Scanner;
public class estrato
{
    public static void main(String[] args)
    {
        // Esta es la seccion logica del codigo
        Scanner teclado = new Scanner(System.in);
        int estrato;

        System.out.println(" Bienvenido al sistema de cobro de alumbrado publico segun es estracto");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");
        System.out.println("Ingrese el estracto: ");
        estrato = teclado.nextInt();


        if (estrato <= 2)
        {
            System.out.println("");
            System.out.println("El valor a cancelar es: $2000");
        }
        else if (estrato == 3)
        {
            System.out.println("");
            System.out.println("El valor a cancelar es: $4500");
        }
        else
        {
            System.out.println("");
            System.out.println("El valor a cancelar es: $7000 ");
        }
        teclado.close();
    }
}
