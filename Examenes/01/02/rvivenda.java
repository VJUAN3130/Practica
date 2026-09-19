import java.util.Scanner; // se importa la clase Scanner para leer la entrada del usuario
public class rvivenda
{
    public static void main(String[] args)
    {

        Scanner teclado = new Scanner(System.in);
        int antiguedad, revision;

        // esta es el inicio del sistema y el ingreso de los datos
        System.out.println(" Bienvenido al sistema de detección de riesgo eléctrico en vivienda antigua");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("");
        System.out.print("Ingrese la antigüedad: ");
        antiguedad = teclado.nextInt();
        System.out.println("");
        System.out.print("Ingrese la revisión: ");
        revision = teclado.nextInt();

        // Esta es la parte logica del programa
        if (antiguedad > 35 || revision > 5)
        {
            System.out.println("");
            System.out.println("Hay un alto riesgo eléctrico en la vivienda");
        }
        else
        {
            System.out.println("");
            System.out.println("No se detecta riesgo eléctrico en la vivienda");
        }
        teclado.close();
    }
}
