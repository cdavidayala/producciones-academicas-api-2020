package co.edu.udea.produccionesacademicas.api.service.impl;

import co.edu.udea.produccionesacademicas.api.model.Categoria;
import co.edu.udea.produccionesacademicas.api.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements CategoriaServiceInt{

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoria(Integer id) {
        Optional<Categoria> posibleCategoria = categoriaRepository.findById(id);
        if(posibleCategoria.isPresent()){
            return posibleCategoria.get();
        }else {
            return null;        }
    }

    @Override
    public Categoria getCategoria(String materia) {
        Optional<Categoria> posibleCategoria = Optional.ofNullable(categoriaRepository.findByMateria(materia));
        if(posibleCategoria.isPresent()){
            return posibleCategoria.get();
        }else {
            return null;        }
    }
}
