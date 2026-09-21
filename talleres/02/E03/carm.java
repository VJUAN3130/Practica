/*
Enunciado: Lea N mediciones de pH tomadas en distintos puntos del río y cuente cuántas están
fuera del rango aceptable (6.5 a 8.5).
Resultado esperado: Con N = 4: 7.0, 9.2, 6.0, 7.8: 2 mediciones fuera de rango
*/
package E03;
import java.util.Scanner;
public class carm {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int fueraDeRango = 0;
        double medicion;

        System.out.print("===Ingrese el número de mediciones: ===");
        int n = teclado.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese la medición " + i + " de " + n + ": ");
            medicion = teclado.nextDouble();

            // Si está fuera de rango (menor a 6.5 O mayor a 8.5), sumamos al contador
            if (medicion < 6.5 || medicion > 8.5)
            {
                fueraDeRango++;
            }
        }

        System.out.println("Mediciones fuera de rango: " + fueraDeRango);

        // Buena práctica: cerrar el Scanner para liberar el recurso
        teclado.close();
    }
}
