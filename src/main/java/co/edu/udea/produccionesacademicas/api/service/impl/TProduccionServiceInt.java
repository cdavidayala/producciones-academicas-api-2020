package co.edu.udea.produccionesacademicas.api.service.impl;

import co.edu.udea.produccionesacademicas.api.model.TipoProduccion;

import java.util.List;

public interface TProduccionServiceInt {
    List<TipoProduccion> getTProducciones();

    TipoProduccion getTipoProduccion(Integer id);
}
