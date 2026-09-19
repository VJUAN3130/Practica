// Programa para detectar el nivel de los arroyos
import java.util.Scanner; // Esta linea sirve para que el codigo detecte lo que el usuario ingresa
public class picoyplaca
{
    public static void main(String[] args)
    {
         // Esta es la sección que da la bienvenida al usuario y pide los datos
        Scanner teclado = new Scanner(System.in);
        int ultimoDigito;
        String dia;
        boolean esPar;

        System.out.println(" Bienvenido al sistema de pico y placa");
        System.out.print("---------------------------------------");
        System.out.println("");
        System.out.print("Ingrese el ultimo digito de su placa: ");
        ultimoDigito = teclado.nextInt();
        System.out.print("");
        System.out.print("Ingrese el dia de la semana: ");
        dia = teclado.next();

        // Esta es la seccion logica del programa
        esPar = (ultimoDigito % 2 == 0);
        if (dia.equals("lunes") || dia.equals("miercoles") || dia.equals("viernes"))
        {
            if (esPar)
            {
                System.out.println("Puede circular hoy");
            }
            else
            {
                System.out.println("No puede circular hoy (placa impar)");
            }
        }
        else
        {
            if (dia.equals("martes") || dia.equals("jueves"))
            {
                if (esPar)
                {
                    System.out.println("No puede circular hoy (placa par)");
                }
                else
                {
                    System.out.println("Puede circular hoy");
                }

            }
            else
            {
                System.out.println("fin de semana: puede circular hoy");
            }

        }

    teclado.close();
    }

}
