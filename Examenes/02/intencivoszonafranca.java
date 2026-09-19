import java.util.Scanner;
public class intencivoszonafranca
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        String actividad;
        System.out.println("-- Bienvenido --");
        System.out.print("Tipo de actividad (industrial / logistica / comercial): ");
        actividad = teclado.nextLine();

         if (actividad.equalsIgnoreCase("industrial") ||
             actividad.equalsIgnoreCase("logistica"))
        {
            System.out.println("resultado: accede a los beneficios tributarios");
        }
        else
        {
            System.out.println("resultado: no accede a los beneficios tributarios");
        }
        teclado.close();
    }
}
