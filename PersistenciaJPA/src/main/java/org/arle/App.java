package org.arle;

import org.arle.entity.Estudiante;
import org.arle.service.EstudianteService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final EstudianteService estudianteService = new EstudianteService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CRUD de Estudiantes ---");
            System.out.println("1. Crear estudiante");
            System.out.println("2. Leer estudiante");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Listar todos los estudiantes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearEstudiante();
                case 2 -> leerEstudiante();
                case 3 -> actualizarEstudiante();
                case 4 -> eliminarEstudiante();
                case 5 -> listarEstudiantes();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
        estudianteService.cerrar();
        scanner.close();
    }

    private static void crearEstudiante() {
        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Grado del estudiante: ");
        int grado = scanner.nextInt();

        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(nombre);
        estudiante.setGrado(grado);


        estudianteService.crearEstudiante(estudiante);
        System.out.println("Estudiante creado con éxito");
    }

    private static void leerEstudiante() {
        System.out.print("ID del estudiante: ");
        Long id = scanner.nextLong();
        Estudiante estudiante = estudianteService.obtenerEstudiante(id);
        if (estudiante != null) {
            System.out.println(estudiante);
        } else {
            System.out.println("Estudiante no encontrado");
        }
    }

    private static void actualizarEstudiante() {
        System.out.print("ID del producto a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Estudiante estudiante = estudianteService.obtenerEstudiante(id);
        if (estudiante != null) {
            System.out.print("Nuevo nombre (deje en blanco para mantener el actual): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                estudiante.setNombre(nombre);
            }

            System.out.print("Nuevo grado (0 para mantener el actual): ");
            int grado = scanner.nextInt();
            if (grado != 0 && grado >12) {
                estudiante.setGrado(grado);
            }
            estudianteService.actualizarEstudiante(estudiante);
            System.out.println("Estudiante actualizado con éxito");
        } else {
            System.out.println("Estudiante no encontrado");
        }
    }

    private static void eliminarEstudiante() {
        System.out.print("ID del estudiante a eliminar: ");
        Long id = scanner.nextLong();
        estudianteService.eliminarEstudiante(id);
        System.out.println("Estudiante eliminado con éxito");
    }

    private static void listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodosLosEstudiantes();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
        } else {
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        }
    }
}