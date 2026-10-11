import java.util.Scanner;

public class BecaUniatlantico {

    public enum TipoBeca { COMPLETA, PARCIAL, NINGUNA }
    private static final float PROMEDIO_MINIMO = 4.0f;

    public static void main(String[] args) {
        String nombreEstudiante;
        long documento;
        long valorBeca;
        byte semestre;
        byte estrato;
        float promedioAcademico;
        double puntajeSaber11;
        int creditosAprobados;
        boolean puedeMatricularse;
        char categoriaBeca;
        TipoBeca tipoBeca;

        try (Scanner teclado = new Scanner(System.in)) {
            System.out.println("=== Becas Uniatlántico ===");
            System.out.print("Nombre: "); nombreEstudiante = teclado.nextLine();
            System.out.print("Documento: "); documento = teclado.nextLong();
            System.out.print("Semestre: "); semestre = teclado.nextByte();
            System.out.print("Estrato (1-6): "); estrato = teclado.nextByte();
            System.out.print("Promedio Académico: "); promedioAcademico = teclado.nextFloat();
            System.out.print("Puntaje Saber 11: "); puntajeSaber11 = teclado.nextDouble();
            System.out.print("Créditos Aprobados: "); creditosAprobados = teclado.nextInt();

            puedeMatricularse = creditosAprobados >= 12;

            if (promedioAcademico >= PROMEDIO_MINIMO && estrato <= 2) {
                tipoBeca = TipoBeca.COMPLETA; categoriaBeca = 'C'; valorBeca = 2000000L;
            } else if (promedioAcademico >= PROMEDIO_MINIMO && estrato <= 4) {
                tipoBeca = TipoBeca.PARCIAL; categoriaBeca = 'P'; valorBeca = 1000000L;
            } else {
                tipoBeca = TipoBeca.NINGUNA; categoriaBeca = 'N'; valorBeca = 0L;
            }

            System.out.println("\n--- Ficha Estudiante ---");
            System.out.println("Estudiante: " + nombreEstudiante + " | Beca: " + tipoBeca + " [" + categoriaBeca + "]");
            System.out.println("Valor Beca: $" + valorBeca + " | Puede matricularse: " + puedeMatricularse);
        }
    }
}
