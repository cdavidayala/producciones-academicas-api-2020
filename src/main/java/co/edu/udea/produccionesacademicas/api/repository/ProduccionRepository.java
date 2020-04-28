package co.edu.udea.produccionesacademicas.api.repository;

import co.edu.udea.produccionesacademicas.api.model.Produccion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduccionRepository extends JpaRepository<Produccion, Integer> {

    Page<Produccion> findByTituloContaining(String titulo, Pageable pageableRequest);
    List<Produccion> findByTituloContaining(String titulo);
    Page<Produccion> findByResumenContaining(String resumen, Pageable pageableRequest);
    List<Produccion> findByResumenContaining(String resumen);
    //Optional<Produccion> findByID(int id);
}
