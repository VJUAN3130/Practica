import java.util.Scanner;
public class FacturaElectrica

{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        int estrato;
        double consumokwh, tarifabase, valorfactura;

        System.out.println(" Bienvenido al sistema de facturacción electrica por estrato");
        System.out.println("-------------------------------------------------------------");
        System.out.println("");
        System.out.print("Ingrese su estrato socioeconimco: ");
        estrato = teclado.nextInt();
        System.out.println("");


        teclado.close();
    }
}
