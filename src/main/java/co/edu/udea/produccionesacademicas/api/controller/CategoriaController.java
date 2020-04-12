package co.edu.udea.produccionesacademicas.api.controller;

import co.edu.udea.produccionesacademicas.api.model.Categoria;
import co.edu.udea.produccionesacademicas.api.service.impl.CategoriaServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private CategoriaServiceInt categoriaService;

    public CategoriaController(CategoriaServiceInt categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok(categoriaService.getCategorias());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable("id") Integer id){
        return ResponseEntity.ok(categoriaService.getCategoria(id));
    }

    @GetMapping(value = "/m/{materia}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable("materia") String materia){
        return ResponseEntity.ok(categoriaService.getCategoria(materia));
    }

}
