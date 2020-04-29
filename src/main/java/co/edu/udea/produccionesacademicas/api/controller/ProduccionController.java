package co.edu.udea.produccionesacademicas.api.controller;

import co.edu.udea.produccionesacademicas.api.model.PagingResult;
import co.edu.udea.produccionesacademicas.api.model.Produccion;
import co.edu.udea.produccionesacademicas.api.service.impl.ProduccionServiceInt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/producciones")
public class ProduccionController {

    private ProduccionServiceInt produccionService;

    public ProduccionController(ProduccionServiceInt produccionService) {
        this.produccionService = produccionService;
    }

    @GetMapping
    public ResponseEntity<List<Produccion>> getProducciones() {
        return ResponseEntity.ok(produccionService.getProducciones());
    }

    @PostMapping(value = "add")
    public ResponseEntity<Produccion> addProduccion(@Valid @RequestBody Produccion newProduccion) {
        return new ResponseEntity<>(produccionService.addProduccion(newProduccion), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Produccion> updateProduccion(@PathVariable(value = "id") Integer id, @Valid @RequestBody Produccion produccion) {
        return new ResponseEntity<>(produccionService.updateProduccion(id, produccion), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduccion(@PathVariable(value = "id") Integer id) {

        produccionService.deleteProduccion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "consultar/{id}")
    public ResponseEntity<Produccion> getProduccion(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(produccionService.getProduccion(id));
    }

    @GetMapping("produccionesPagina")
    public ResponseEntity<PagingResult<Produccion>> getProduccionesPagina(
            @RequestParam(value = "pageIndex", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "30") int limit,
            @RequestParam(value = "sortActive", defaultValue = "titulo") String sortActive,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection){
        return ResponseEntity.ok(produccionService.getProduccionesPagina(page, limit, sortActive, sortDirection));
    }

    @GetMapping("produccionesPaginaTitulo")
    public ResponseEntity<PagingResult<Produccion>> getProduccionesPaginaTitulo(
            @RequestParam(value = "pageIndex", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "30") int limit,
            @RequestParam(value = "sortActive", defaultValue = "titulo") String sortActive,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @RequestParam(value = "term", defaultValue = " ") String term){
        return ResponseEntity.ok(produccionService.getProduccionesPaginaTitulo(page, limit, sortActive, sortDirection, term));
    }

    @GetMapping("produccionesPaginaResumen")
    public ResponseEntity<PagingResult<Produccion>> getProduccionesPaginaResumen(
            @RequestParam(value = "pageIndex", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "30") int limit,
            @RequestParam(value = "sortActive", defaultValue = "titulo") String sortActive,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection,
            @RequestParam(value = "term", defaultValue = " ") String term){
        return ResponseEntity.ok(produccionService.getProduccionesPaginaResumen(page, limit, sortActive, sortDirection, term));
    }

}
