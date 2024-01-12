package servicio;

import dominio.Celular;

import java.io.*;

public class ServicioCelularesArchivo implements IServicioCelulares {
    private final String NOMBRE_ARCHIVO = "celulares.txt";

    public ServicioCelularesArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);

        System.out.print("Estado del archivo: ");

        try {
            if (archivo.exists()) {
                System.out.println("El archivo " + NOMBRE_ARCHIVO + " ya existe");
            } else {
                PrintWriter salida = new PrintWriter(new PrintWriter(archivo));
                salida.close();
                System.out.println("El archivo " + NOMBRE_ARCHIVO + " ha sido creado con éxito");
            }
        } catch(Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
        System.out.println();
    }

    @Override
    public void listarCelulares() {
        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));

            String linea;
            linea = entrada.readLine();

            while(linea != null) {
                Celular celular = new Celular(linea);
                System.out.println(celular);

                linea = entrada.readLine();
            }
        } catch(Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    @Override
    public void agregarCelular(Celular celular) {
        boolean anexar = false;

        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            anexar = archivo.exists();
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));

            salida.println(celular);
            salida.close();
            System.out.println("Se ha añadido el celular " + celular + " al archivo");
            System.out.println();

        } catch(Exception e){
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    @Override
    public void buscarCelular(Celular celular) {
        File archivo = new File(NOMBRE_ARCHIVO);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));

            String lineaTexto;
            lineaTexto = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;
            String celularBuscar = celular.getNombre();

            while (lineaTexto != null) {

                if(celularBuscar != null && celularBuscar.equalsIgnoreCase(lineaTexto)) {
                    encontrada = true;
                    break;
                }

                lineaTexto = entrada.readLine();
                indice++;
            }

            if (encontrada) {
                System.out.println("Celular " + lineaTexto + " encontrado en la línea " + indice);
            } else {
                System.out.println("No se encontró el celular: " + celular.getNombre());
            }

            System.out.println();
            entrada.close();
        } catch(Exception e){
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
