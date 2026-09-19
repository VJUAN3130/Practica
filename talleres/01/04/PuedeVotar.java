import java.util.Scanner;
public class PuedeVotar
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int edad;
        boolean inscritoCenso;

        System.out.println("Ingrese la edad:");
        edad = teclado.nextInt();

        if (edad >= 18)
        {

            System.out.println("¿Está inscrito en el censo electoral? (true/false)");
            inscritoCenso = teclado.nextBoolean();

            if (inscritoCenso == true)
            {
                System.out.println("Puede votar");
            }
            else
            {
                System.out.println("No puede votar porque no está inscrito en el censo");
            }

        }
        else
        {
            System.out.println("No puede votar porque es menor de edad");
        }
        teclado.close();
    }
}
