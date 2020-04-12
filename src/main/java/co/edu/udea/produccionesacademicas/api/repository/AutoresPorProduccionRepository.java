package co.edu.udea.produccionesacademicas.api.repository;

import co.edu.udea.produccionesacademicas.api.model.AutoresPorProducciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoresPorProduccionRepository extends JpaRepository<AutoresPorProducciones, Integer> {
}
