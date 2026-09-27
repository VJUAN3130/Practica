import java.util.Scanner;

public class SensorMalambo 
{

    public enum NivelCalidadAire { VERDE, AMARILLO, NARANJA, ROJO }
    private static final double UMBRAL_ALERTA = 100.0;

    public static void main(String[] args) 
    {
        long codigoEstacion;
        int numeroSensor;
        byte zonaIndustrial;
        short lecturasPorHora;
        float pm25Promedio;
        double indiceCalculado;
        boolean alertaActiva;
        char nivelAlerta;
        NivelCalidadAire calidad;

        try (Scanner teclado = new Scanner(System.in)) 
        {
            System.out.println("=== Sensor Malambo ===");
            System.out.print("Código Estación: "); codigoEstacion = teclado.nextLong();
            System.out.print("Número Sensor: "); numeroSensor = teclado.nextInt();
            System.out.print("Zona Industrial (1-10): "); zonaIndustrial = teclado.nextByte();
            System.out.print("Lecturas por hora: "); lecturasPorHora = teclado.nextShort();
            System.out.print("PM2.5 Promedio: "); pm25Promedio = teclado.nextFloat();

            indiceCalculado = pm25Promedio * (lecturasPorHora / 10.0);
            alertaActiva = indiceCalculado > UMBRAL_ALERTA;

            if (indiceCalculado < 50) { calidad = NivelCalidadAire.VERDE; nivelAlerta = 'V'; }
            else if (indiceCalculado < 80) { calidad = NivelCalidadAire.AMARILLO; nivelAlerta = 'A'; }
            else if (indiceCalculado <= UMBRAL_ALERTA) { calidad = NivelCalidadAire.NARANJA; nivelAlerta = 'N'; }
            else { calidad = NivelCalidadAire.ROJO; nivelAlerta = 'R'; }

            System.out.println("\n--- Reporte ---");
            System.out.println("Estación: " + codigoEstacion + " | Índice: " + indiceCalculado);
            System.out.println("Calidad: " + calidad + " [" + nivelAlerta + "] | Alerta Activa: " + alertaActiva);
        }
    }
}
