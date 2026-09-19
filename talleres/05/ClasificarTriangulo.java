import java.util.Scanner;
public class ClasificarTriangulo
{
    public static void main(String[] args)
    {

        Scanner teclado = new Scanner(System.in);

        double lado1;
        double lado2;
        double lado3;

        System.out.println("Ingrese el primer lado:");
        lado1 = teclado.nextDouble();

        System.out.println("Ingrese el segundo lado:");
        lado2 = teclado.nextDouble();

        System.out.println("Ingrese el tercer lado:");
        lado3 = teclado.nextDouble();

        if (lado1 == lado2 && lado2 == lado3) {

            System.out.println("Triángulo equilátero");
        }
        else
        {
            if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {

                System.out.println("Triángulo isósceles");
            }
            else
            {
                System.out.println("Triángulo escaleno");
            }
        }
        teclado.close();
    }
}
