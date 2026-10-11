import java.util.Scanner;
public class HorariaAtencion
{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        String dia;
        int hora;

        System.out.println("-- Bienvenido --");
        System.out.print("dia de la semana (lunes..domingo): ");
        dia = teclado.nextLine();
        System.out.print("hora actual (0 a 23): ");
        hora = teclado.nextInt();
        if (dia.equalsIgnoreCase("domingo"))
            {            System.out.println("resultado: cerrado, no se atiende los domingos");

            }
            else if (dia.equalsIgnoreCase("Sabado"))
                {
                    if (hora >= 8 && hora < 12)
                    {
                        System.out.println("resultado: abierto");
                    }
                    else
                        {
                            System.out.println("Resultado: cerrado");
                        }
                }
                    else
                        {
                            if (hora >= 8 && hora < 16)
                                {
                                    System.out.println("resultado: abierto");
                                }
                                else
                                    {
                                        System.out.println("resultado: cerrado");
                                    }
                        }

        teclado.close();
    }
}
