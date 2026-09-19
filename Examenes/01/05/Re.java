import java.util.Scanner;
public class Re
{
    public static void main(String[] args)

    {
        Scanner teclado = new Scanner(System.in);
        double porcentajeAsistencia;

        System.out.println("--- Riesgo de desercion escolar ---");
        System.out.print("Porcentaje de asistencia en el semestre: ");
        porcentajeAsistencia = teclado.nextDouble();

        if (porcentajeAsistencia < 80)
        {
            System.out.println("Clasificacion: EN RIESGO de desercion escolar");
        }
        else
        {
            System.out.println("Clasificacion: SIN RIESGO de desercion escolar");
        }
        teclado.close();
    }
}
