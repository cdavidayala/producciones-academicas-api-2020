package co.edu.udea.produccionesacademicas.api.controller;

import co.edu.udea.produccionesacademicas.api.model.TipoProduccion;

import co.edu.udea.produccionesacademicas.api.service.impl.TProduccionServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tproducciones")
public class TProduccionController {

    private TProduccionServiceInt tProduccionService;

    public TProduccionController(TProduccionServiceInt tProduccionService){
        this.tProduccionService = tProduccionService;
    }

    @GetMapping
    public ResponseEntity<List<TipoProduccion>> getTProducciones(){
        return ResponseEntity.ok(tProduccionService.getTProducciones());
    }
}
