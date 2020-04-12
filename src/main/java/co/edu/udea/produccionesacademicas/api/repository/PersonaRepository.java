package co.edu.udea.produccionesacademicas.api.repository;

import co.edu.udea.produccionesacademicas.api.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
