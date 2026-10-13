/**
 * 📝 ENUNCIADO:
 * Determinar si un número de cédula tiene el formato válido (verdadero/falso).
 *
 * 🎯 OBJETIVO / TEMAS:
 * - Creación de funciones con retorno lógico (boolean).
 * - Manejo de condicionales (if-else).
 * - Validación de cadenas de texto (longitud, caracteres).
 *
 * 🚀 NIVEL: Intermedio
 *
 * @author VJUAN3130
 */

import java.util.Scanner;

public class ValidacionCedula
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        System.out.println(" === Sistema de Validación de Documentos ===");
        System.out.print("Ingrese el número de cédula a verificar: ");
        String documentoIngresado = teclado.nextLine();
        System.out.println("\nAnalizando formato...\n");
        boolean formatoCorrecto = validarFormatoCedula(documentoIngresado);

        if (formatoCorrecto)
        {
            System.out.println("✅ RESULTADO: El formato es VÁLIDO.");
        } else {
            System.out.println("❌ RESULTADO: El formato es INVÁLIDO.");
            System.out.println("Recuerde: Solo debe contener números y tener entre 6 y 10 dígitos.");
        }

        teclado.close();
    }

    public static boolean validarFormatoCedula(String cedula)
    {

        int cantidadCaracteres = cedula.length();
        if (cantidadCaracteres < 6 || cantidadCaracteres > 10)
        {
            return false;
        }

        if (!cedula.matches("[0-9]+"))
        {
            return false;
        }

        return true;
    }
}
