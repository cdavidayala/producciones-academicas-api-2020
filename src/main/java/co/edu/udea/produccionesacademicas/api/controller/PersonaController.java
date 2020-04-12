package co.edu.udea.produccionesacademicas.api.controller;

import co.edu.udea.produccionesacademicas.api.model.Persona;
import co.edu.udea.produccionesacademicas.api.service.impl.PersonaServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    private PersonaServiceInt personaService;

    public PersonaController(PersonaServiceInt personaService){
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<Persona>> getPersonas(){
        return ResponseEntity.ok(personaService.getPersonas());
    }
}
