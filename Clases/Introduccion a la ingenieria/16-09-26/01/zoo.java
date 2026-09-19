import java.util.Scanner;
public class zoo
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int n, i, edad, tarifa, total;
        total = 0;

        System.out.println(" Bienvenido al zoologico");
        System.out.println("-------------------------");
        System.out.println("Cuantos visitantes son?");
        n = teclado.nextInt();

        for (int i = 1; i <= n; i++)
        {
            System.out.println("Ingrese la edad del visitante " + i + ":");
            edad = teclado.nextInt();

            if (edad <=4)
            {
                tarifa = 8000;
            }
            else
            {
                if (edad <=5 && edad >=12)
                {
                    tarifa = 12000;
                }
                else
                {
                    if (edad <=13 && edad >=60)
                    {
                        tarifa = 15000;
                    }
                    else
                    {
                        System.out.println("No cumples con la edad requerida");
                        edad = teclado.nextInt();
                    }
                }
            }
            total += tarifa;
        }
        teclado.close();
    }
}
