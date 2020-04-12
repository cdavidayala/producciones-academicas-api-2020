package co.edu.udea.produccionesacademicas.api.repository;

import co.edu.udea.produccionesacademicas.api.model.TipoProduccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TProduccionRepository extends JpaRepository<TipoProduccion, Integer> {

}
