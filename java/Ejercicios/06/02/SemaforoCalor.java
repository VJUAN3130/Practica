import java.util.Scanner;

public class SemaforoCalor {

    // Enum que encapsula la lógica y metadatos de cada nivel del semáforo
    enum NivelAlerta {
        VERDE("🟢 NORMAL / SEGURO",
              "Temperatura en rango confortable.",
              new String[]{
                  "• Mantén tus actividades habituales.",
                  "• Disfruta el día con normalidad."
              }),

        AMARILLO("🟡 PRECAUCIÓN",
                 "Sensación térmica elevada.",
                 new String[]{
                     "• Mantente bien hidratado durante el día.",
                     "• Usa protector solar y ropa fresca si sales."
                 }),

        NARANJA("🟠 ALERTA ALTA",
                "Riesgo de agotamiento y deshidratación.",
                new String[]{
                    "• Evita la actividad física intensa al aire libre.",
                    "• Busca lugares frescos, ventilados o con aire.",
                    "• Bebe agua de forma constante sin esperar a tener sed."
                }),

        ROJO("🔴 PELIGRO EXTREMO",
             "¡Riesgo inminente de golpe de calor!",
             new String[]{
                 "• EVITA por completo la exposición directa al sol.",
                 "• Permanece en interiores acondicionados.",
                 "• Ante mareos, dolor de cabeza o náuseas, busca atención médica."
             });

        private final String titulo;
        private final String estado;
        private final String[] recomendaciones;

        NivelAlerta(String titulo, String estado, String[] recomendaciones) {
            this.titulo = titulo;
            this.estado = estado;
            this.recomendaciones = recomendaciones;
        }

        // Evalúa la temperatura y retorna el nivel correspondiente
        public static NivelAlerta evaluar(double temp) {
            if (temp < 28.0) {
                return VERDE;
            } else if (temp < 35.0) {
                return AMARILLO;
            } else if (temp < 41.0) {
                return NARANJA;
            } else {
                return ROJO;
            }
        }

        public String getTitulo() { return titulo; }
        public String getEstado() { return estado; }
        public String[] getRecomendaciones() { return recomendaciones; }
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            dibujarEncabezado();

            System.out.print("👉 Ingrese la temperatura ambiental actual (°C) [-99 para salir]: ");
            double temperatura = leerTemperatura(teclado);

            if (temperatura == -99) {
                dibujarCajaMensaje("Programa finalizado. ¡Cuídate del calor!");
                continuar = false;
            } else {
                NivelAlerta nivel = NivelAlerta.evaluar(temperatura);
                mostrarAlerta(temperatura, nivel);

                System.out.print("\n¿Deseas evaluar otra temperatura? [1 = Sí / 2 = No]: ");
                int opcion = leerEnteroEnRango(teclado, 1, 2);
                if (opcion == 2) {
                    dibujarCajaMensaje("¡Hasta pronto! Mantente informado y protegido.");
                    continuar = false;
                }
            }
        }

        teclado.close();
    }

    // --- COMPONENTES VISUALES EN CONSOLA ---

    private static void dibujarEncabezado() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║               🌡️  SEMÁFORO DE ALERTAS DE CALOR               ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    private static void mostrarAlerta(double temp, NivelAlerta nivel) {
        System.out.println("\n┌──────────────────────────────────────────────────────────────┐");
        System.out.printf("│  ESTADO: %-51s │%n", nivel.getTitulo());
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.printf("│  🌡️  Temperatura registrada : %-30s │%n", String.format("%.1f °C", temp));
        System.out.printf("│  📋 Diagnóstico             : %-30s │%n", nivel.getEstado());
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.println("│  💡 RECOMENDACIONES DE SEGURIDAD:                            │");
        for (String rec : nivel.getRecomendaciones()) {
            System.out.printf("│  %-58s │%n", rec);
        }
        System.out.println("└──────────────────────────────────────────────────────────────┘");
    }

    private static void dibujarCajaMensaje(String mensaje) {
        System.out.println("\n┌──────────────────────────────────────────────────────────────┐");
        System.out.printf("│  %-58s  │%n", mensaje);
        System.out.println("└──────────────────────────────────────────────────────────────┘\n");
    }

    // --- LECTURA Y VALIDACIÓN DE DATOS ---

    private static double leerTemperatura(Scanner scanner) {
        while (true) {
            String entrada = scanner.nextLine().trim().replace(',', '.');
            try {
                double valor = Double.parseDouble(entrada);
                if (valor == -99 || (valor >= -50.0 && valor <= 70.0)) {
                    return valor;
                }
                System.out.print("⚠️  Temperatura fuera de rango lógico (-50°C a 70°C). Intenta de nuevo: ");
            } catch (NumberFormatException e) {
                System.out.print("⚠️  Entrada no válida. Ingrese un valor numérico (ej. 36.5): ");
            }
        }
    }

    private static int leerEnteroEnRango(Scanner scanner, int min, int max) {
        while (true) {
            String entrada = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.print("⚠️  Opción fuera de rango (" + min + " o " + max + "): ");
            } catch (NumberFormatException e) {
                System.out.print("⚠️  Por favor ingrese un número válido: ");
            }
        }
    }
}
