import java.util.Scanner;
public class NumeroNegativo
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        double num;

        System.out.println("Ingrese un número: ");
        num = teclado.nextDouble();

        if (num < 0)
        {
            System.out.println("El número es negativo.");
        }
        else
        {
            System.out.println("El número es positivo o cero.");
        }
        teclado.close();
    }
}
