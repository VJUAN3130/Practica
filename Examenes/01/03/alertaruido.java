import java.util.Scanner; // se importa la clase Scanner para leer la entrada del usuario
public class alertaruido
{
    public static void main(String[] args)
    {

        Scanner teclado = new Scanner(System.in);
        int nivelruido;
        double hora;
        boolean dia_noche;

        // esta es el inicio del sistema y el ingreso de los datos
        System.out.println("Bienvenido al sistema de alerta de ruido");
        System.out.println("");
        System.out.println("Ingrese el nivel de ruido: ");
        nivelruido = teclado.nextInt();
        System.out.println("");
        System.out.println("Ingrese la hora: ");
        hora = teclado.nextDouble();

        dia_noche = (hora >= 22 && hora <= 5);

        if (dia_noche)
        {
            if (nivelruido > 70)
            {
                System.out.println("Esta fuera del limite de ruido nocturno");
            }
            else
            {
                System.out.println("Esta dentro del limite de ruido nocturno");
            }
        }
        else
        {
            if (nivelruido > 70)
            {
                System.out.println("Esta fuera del limite de ruido nocturno");
            }
            else
            {
                System.out.println("Esta dentro del limite de ruido nocturno");
            }
        }
        teclado.close();
    }
}
