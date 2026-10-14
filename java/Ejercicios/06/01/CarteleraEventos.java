import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CarteleraEventos
{
    static class Evento
    {
        private final int id;
        private final String nombre;
        private final String fecha;
        private final double precio;
        private final String lugar;

        public Evento(int id, String nombre, String fecha, double precio, String lugar)
        {
            this.id = id;
            this.nombre = nombre;
            this.fecha = fecha;
            this.precio = precio;
            this.lugar = lugar;
        }

        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public String getFecha() { return fecha; }
        public double getPrecio() { return precio; }
        public String getLugar() { return lugar; }
    }

    private static final String SEDE_PRINCIPAL = "Malecón del Río";
    private static final NumberFormat FORMATO_MONEDA = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));

    public static void main(String[] args) {
        FORMATO_MONEDA.setMaximumFractionDigits(0);
        Scanner teclado = new Scanner(System.in);
        List<Evento> cartelera = cargarEventos();

        boolean salir = false;

        while (!salir) {
            dibujarEncabezado();
            dibujarCartelera(cartelera);

            int opcion = leerEntero(teclado, "👉 Ingrese el número del evento (0 para salir): ", 0, cartelera.size());

            if (opcion == 0) {
                dibujarCajaMensaje("¡Gracias por visitar la Cartelera! ¡Hasta pronto!");
                salir = true;
            } else {
                Evento seleccionado = cartelera.get(opcion - 1);
                mostrarDetalleEvento(seleccionado);

                int confirmacion = leerEntero(teclado, "¿Confirmas tu elección? [1 = Sí / 2 = Volver al menú]: ", 1, 2);

                if (confirmacion == 1) {
                    dibujarReservaConfirmada(seleccionado);
                    salir = true;
                } else {
                    System.out.println("\n🔄 Volviendo a la cartelera...\n");
                }
            }
        }

        teclado.close();
    }

    // Carga inicial de datos
    private static List<Evento> cargarEventos() {
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new Evento(1, "Concierto de Rock", "20/10/2026", 80000, SEDE_PRINCIPAL));
        eventos.add(new Evento(2, "Festival de Cine", "25/10/2026", 30000, SEDE_PRINCIPAL));
        eventos.add(new Evento(3, "Feria Gastronómica", "01/11/2026", 15000, SEDE_PRINCIPAL));
        eventos.add(new Evento(4, "Obra de Teatro", "08/11/2026", 45000, SEDE_PRINCIPAL));
        return eventos;
    }

    // --- COMPONENTES DE INTERFAZ EN CONSOLA ---

    private static void dibujarEncabezado() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                🎟️  CARTELERA DE EVENTOS  🎟️                    ║");
        System.out.printf("║ Sede: %-54s ║%n", SEDE_PRINCIPAL);
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    private static void dibujarCartelera(List<Evento> eventos) {
        for (Evento e : eventos) {
            String precioStr = FORMATO_MONEDA.format(e.getPrecio());
            System.out.println("┌──────────────────────────────────────────────────────────────┐");
            System.out.printf("│  [%d] %-52s │%n", e.getId(), e.getNombre());
            System.out.println("├──────────────────────────────────────────────────────────────┤");
            System.out.printf("│  📅 Fecha: %-16s │  💰 Precio: %-15s │%n", e.getFecha(), precioStr);
            System.out.println("└──────────────────────────────────────────────────────────────┘");
        }
        System.out.println("  [0] Salir del sistema\n");
    }

    private static void mostrarDetalleEvento(Evento evento) {
        String precioStr = FORMATO_MONEDA.format(evento.getPrecio());
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    RESUMEN DE SELECCIÓN                      ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Evento:  %-51s ║%n", evento.getNombre());
        System.out.printf("║ Fecha:   %-51s ║%n", evento.getFecha());
        System.out.printf("║ Precio:  %-51s ║%n", precioStr);
        System.out.printf("║ Lugar:   %-51s ║%n", evento.getLugar());
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    private static void dibujarReservaConfirmada(Evento evento) {
        System.out.println("\n┌──────────────────────────────────────────────────────────────┐");
        System.out.println("│  🎉 ¡SELECCIÓN CONFIRMADA!                                   │");
        System.out.println("├──────────────────────────────────────────────────────────────┤");
        System.out.printf("│  Te esperamos en %s el %-23s │%n", evento.getLugar(), evento.getFecha());
        System.out.println("└──────────────────────────────────────────────────────────────┘\n");
    }

    private static void dibujarCajaMensaje(String mensaje) {
        System.out.println("\n┌──────────────────────────────────────────────────────────────┐");
        System.out.printf("│  %-58s  │%n", mensaje);
        System.out.println("└──────────────────────────────────────────────────────────────┘\n");
    }

    // Lectura segura de enteros con validación
    private static int leerEntero(Scanner scanner, String mensaje, int min, int max) {
        int valor = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();

            try {
                valor = Integer.parseInt(entrada);
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("⚠️  Opción fuera de rango (debe ser de " + min + " a " + max + ").");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️  Entrada no válida. Por favor escribe un número.");
            }
        }
        return valor;
    }
}
