package presentacion;

import dominio.Celular;
import servicio.IServicioCelulares;
import servicio.ServicioCelularesArchivo;

import java.util.Scanner;

public class CatalogoCelulares {

    public static void main(String[] args) {
        boolean salir = false;
        Scanner consola = new Scanner(System.in);

        IServicioCelulares servicioCelulares = new ServicioCelularesArchivo();

        while(!salir) {

            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioCelulares);
            } catch(Exception e) {
                System.out.println();
                System.out.println("Ocurrió un error: " + e.getMessage());
                System.out.println();
            }
        }
    }

    public static void mostrarMenu(){
        System.out.print("""
                ***** Catálogo de celulares *****
                
                1. Agregar celular
                2. Listar celulares
                3. Buscar celular
                4. Salir
                
                """);
    }

    public static boolean ejecutarOpciones(Scanner consola, IServicioCelulares servicioCelulares){
        System.out.print("Elige una opción: ");
        int opcion = Integer.parseInt(consola.nextLine());
        System.out.println();
        boolean salir = false;

        switch (opcion) {
            case 1 -> {
                System.out.print("Ingresa el nombre del celular: ");
                String nombreCelular = consola.nextLine();
                System.out.println();
                servicioCelulares.agregarCelular(new Celular(nombreCelular));
            }
            case 2 -> {
                System.out.println("Lista de celulares: ");
                servicioCelulares.listarCelulares();
                System.out.println();
            }
            case 3 -> {
                System.out.print("Ingresa el nombre del celular a buscar: ");
                String buscar = consola.nextLine();
                System.out.println();
                servicioCelulares.buscarCelular(new Celular(buscar));
            }
            case 4 -> {
                System.out.println("¡Hasta la próxima!");
                salir = true;
            }
            default -> {
                System.out.println("Opción inválida: " + opcion);
                System.out.println();
            }
        }
        return salir;
    }
}
