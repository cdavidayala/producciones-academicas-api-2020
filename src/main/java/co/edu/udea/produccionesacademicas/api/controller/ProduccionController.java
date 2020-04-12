package co.edu.udea.produccionesacademicas.api.controller;

import co.edu.udea.produccionesacademicas.api.model.PagingResult;
import co.edu.udea.produccionesacademicas.api.model.Produccion;
import co.edu.udea.produccionesacademicas.api.service.impl.ProduccionServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producciones")
public class ProduccionController {

    private ProduccionServiceInt produccionService;

    public ProduccionController(ProduccionServiceInt produccionService){
        this.produccionService = produccionService;
    }

    @GetMapping
    public ResponseEntity<List<Produccion>> getProducciones(){return ResponseEntity.ok(produccionService.getProducciones());}

    @PostMapping
    public ResponseEntity<Produccion> addProduccion(@RequestBody Produccion newProduccion){
        return ResponseEntity.ok(produccionService.addProduccion(newProduccion));
    }

    @GetMapping(value = "consultar/{id}")
    public ResponseEntity<Produccion> getHero(@PathVariable("id") Integer id){
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
