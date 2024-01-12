package servicio;

import dominio.Celular;

public interface IServicioCelulares {
    public void listarCelulares();

    public void agregarCelular(Celular celular);

    public void buscarCelular(Celular celular);
}
