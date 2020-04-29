package co.edu.udea.produccionesacademicas.api.service.impl;

import co.edu.udea.produccionesacademicas.api.model.Categoria;

import java.util.List;

public interface CategoriaServiceInt {
    List<Categoria> getCategorias();

    Categoria getCategoria(Integer id);

    Categoria getCategoria(String materia);
}
