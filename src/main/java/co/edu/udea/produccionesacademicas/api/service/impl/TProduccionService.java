package co.edu.udea.produccionesacademicas.api.service.impl;

import co.edu.udea.produccionesacademicas.api.model.TipoProduccion;
import co.edu.udea.produccionesacademicas.api.repository.TProduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TProduccionService implements TProduccionServiceInt {

    @Autowired
    private TProduccionRepository tProduccionRepository;

    public TProduccionService(TProduccionRepository tProduccionRepository) {
        this.tProduccionRepository = tProduccionRepository;
    }

    public List<TipoProduccion> getTProducciones() {
        return tProduccionRepository.findAll();
    }

    @Override
    public TipoProduccion getTipoProduccion(Integer id) {
        Optional<TipoProduccion> posibleTipoProduccion = tProduccionRepository.findById(id);
        if (posibleTipoProduccion.isPresent()) {
            return posibleTipoProduccion.get();
        } else {
            return null;
        }
    }
}
