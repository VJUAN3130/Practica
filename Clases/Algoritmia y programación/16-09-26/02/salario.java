import java.util.Scanner;
public class salario
{
    public static void main(String[] args)
    {
        // Definición de variables
        Scanner teclado = new Scanner(System.in);
        String cedula, nombres, apellidos;
        int salbro;
        double pen, salud, parafis, desc, salnet, salnet5, salnet10, bon1, bon2;

        // Ingreso de datos
        System.out.println(" Bienvenido");
        System.out.println("-------------");
        System.out.println("");
        System.out.println("Ingrese su cédula:");
        cedula = teclado.nextLine();
        System.out.println("");
        System.out.println("Ingrese sus nombres:");
        nombres = teclado.nextLine();
        System.out.println("");
        System.out.println("Ingrese sus apellidos:");
        apellidos = teclado.nextLine();
        System.out.println("");
        System.out.println("Ingrese su salario bruto:");
        salbro = teclado.nextInt();
        System.out.println("");

        // Logica del programa
        pen = (salbro * 0.04);
        salud = (salbro * 0.04);
        parafis = (salbro * 0.02);
        desc = pen + salud + parafis;
        salnet = salbro - desc;

        System.out.println("Salario neto a pagar es: " + salnet);

        if (salnet <= 2000000)
        {
            bon1 = salnet * 0.1;
            salnet10 = salnet + bon1;
            System.out.println("Salario neto con bonificación del 10% es: " + salnet10);
        }
        if (salnet >= 2000000)
        {
            bon2 = salnet * 0.05;
            salnet5 = salnet + bon2;
            System.out.println("Salario neto con bonificación del 5% es: " + salnet5);
        }

        teclado.close();
    }
}
