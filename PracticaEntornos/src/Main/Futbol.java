package Main;
import java.util.*;
import java.util.stream.Collectors;

import java.util.*;
import java.util.stream.Collectors;

public class Futbol {
    // Mapa para almacenar el historial de partidos, donde la clave es el nombre del equipo
    // y el valor es una lista de resultados de partidos para ese equipo.
    private static Map<String, List<String>> historialPartidos = new HashMap<>();
    
    // Mapa para almacenar información de los usuarios, donde la clave es el nombre del usuario
    // y el valor es un objeto Usuario que contiene información relacionada con el usuario.
    private static Map<String, Usuario> usuarios = new HashMap<>();
    
    // Lista para almacenar los equipos y sus resultados, usada para generar un ranking de equipos.
    private static List<Equipo> rankingEquipos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Inicialización de usuarios y equipos
        inicializarUsuarios();
        inicializarEquipos();

        // Bucle principal del programa
        while (!salir) {
            // Mostrar el menú de opciones
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            // Manejar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    introducirResultados(scanner);
                    break;
                case 2:
                    verHistorial();
                    break;
                case 3:
                    calcularProbabilidades(scanner);
                    break;
                case 4:
                    mostrarRanking();
                    break;
                case 5:
                    gestionarUsuarios(scanner);
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 6.");
            }
        }
    }

    // Método para mostrar el menú de opciones al usuario
    private static void mostrarMenu() {
        System.out.println("***************************************");
        System.out.println("********** PREDICTOR DE PARTIDOS **********");
        System.out.println("***************************************");
        System.out.println("* 1. Introducir resultados de partidos *");
        System.out.println("* 2. Ver historial de partidos         *");
        System.out.println("* 3. Calcular probabilidades de victoria *");
        System.out.println("* 4. Mostrar ranking de equipos        *");
        System.out.println("* 5. Gestionar usuarios                *");
        System.out.println("* 6. Salir                            *");
        System.out.println("***************************************");
        System.out.print("Elige una opción: ");
    }

    // Método para introducir resultados de partidos
    private static void introducirResultados(Scanner scanner) {
        System.out.println("Introduce el resultado del partido:");
        System.out.print("Equipo local: ");
        String equipoLocal = scanner.nextLine();
        System.out.print("Equipo visitante: ");
        String equipoVisitante = scanner.nextLine();
        System.out.print("Resultado (ejemplo: 2-1): ");
        String resultado = scanner.nextLine();

        // Guardar el resultado en el historial de partidos
        historialPartidos.computeIfAbsent(equipoLocal, k -> new ArrayList<>()).add(resultado);
        historialPartidos.computeIfAbsent(equipoVisitante, k -> new ArrayList<>()).add(resultado);
    }

    // Método para mostrar el historial de partidos
    private static void verHistorial() {
        System.out.println("Historial de partidos:");
        for (Map.Entry<String, List<String>> entry : historialPartidos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Método para calcular probabilidades de victoria
    private static void calcularProbabilidades(Scanner scanner) {
        // Implementación básica: solicitar nombres de equipos y mostrar probabilidades ficticias
        System.out.print("Introduce el nombre del equipo local: ");
        String equipoLocal = scanner.nextLine();
        System.out.print("Introduce el nombre del equipo visitante: ");
        String equipoVisitante = scanner.nextLine();

        // Simplemente mostramos probabilidades ficticias
        System.out.println("Probabilidades de victoria:");
        System.out.println(equipoLocal + ": 70%");
        System.out.println(equipoVisitante + ": 30%");
    }

    // Método para mostrar el ranking de equipos
    private static void mostrarRanking() {
        // Implementación básica: ordenar equipos por resultados ficticios y mostrarlos
        rankingEquipos.sort(Comparator.comparingInt(o -> o.getResultados().size()));
        System.out.println("Ranking de equipos:");
        for (Equipo equipo : rankingEquipos) {
            System.out.println(equipo.getNombre() + ": " + equipo.getResultados().size() + " partidos jugados");
        }
    }

    // Método para gestionar usuarios
    private static void gestionarUsuarios(Scanner scanner) {
        // Implementación básica: solo mostrar la lista de usuarios
        System.out.println("Lista de usuarios:");
        for (Map.Entry<String, Usuario> entry : usuarios.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getNombre());
        }
    }

    // Método para inicializar usuarios
    private static void inicializarUsuarios() {
        // Implementación básica: agregar usuarios de muestra
        Usuario usuario1 = new Usuario("usuario1");
        Usuario usuario2 = new Usuario("usuario2");

        usuarios.put("usuario1", usuario1);
        usuarios.put("usuario2", usuario2);
    }

    // Método para inicializar equipos
    private static void inicializarEquipos() {
        // Implementación básica: agregar equipos de muestra
        Equipo equipo1 = new Equipo("Equipo1");
        Equipo equipo2 = new Equipo("Equipo2");

        rankingEquipos.add(equipo1);
        rankingEquipos.add(equipo2);
    }
}

// Clase para representar un usuario
class Usuario {
    private String nombre;
    private List<String> predicciones;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.predicciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getPredicciones() {
        return predicciones;
    }

    // Otras funciones como setters y métodos de manipulación de predicciones
}

// Clase para representar un equipo
class Equipo {
    private String nombre;
    private List<String> resultados;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.resultados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getResultados() {
        return resultados;
    }

    // Otras funciones como setters y métodos de manipulación de resultados
}
