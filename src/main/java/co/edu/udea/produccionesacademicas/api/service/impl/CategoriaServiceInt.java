package co.edu.udea.produccionesacademicas.api.service.impl;

import co.edu.udea.produccionesacademicas.api.model.Categoria;
import co.edu.udea.produccionesacademicas.api.model.Produccion;

import java.util.List;

public interface CategoriaServiceInt {
    public List<Categoria> getCategorias();
    public Categoria getCategoria(Integer id);
    public Categoria getCategoria(String materia);
}
