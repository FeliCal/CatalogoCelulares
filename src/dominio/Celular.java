package dominio;

import java.util.Objects;

public class Celular {
    private String nombre;

    public Celular() {
    }

    public Celular(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Celular celular = (Celular) o;

        return Objects.equals(nombre, celular.nombre);
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    /*
    public static void main(String[] args) {
        Celular celular = new Celular("iPhone 15 Pro Max");

        System.out.println(celular);
    }
    */
}
