package co.edu.udea.produccionesacademicas.api.service.impl;

import co.edu.udea.produccionesacademicas.api.model.PagingResult;
import co.edu.udea.produccionesacademicas.api.model.Produccion;

import java.util.List;

public interface ProduccionServiceInt {

    List<Produccion> getProducciones();

    Produccion addProduccion(Produccion produccion);

    Produccion getProduccion(Integer id);

    Produccion updateProduccion(Integer id, Produccion produccionUpdate);

    void deleteProduccion(Integer id);

    PagingResult<Produccion> getProduccionesPagina(int page, int limit, String sortActive, String sortDirection);

    PagingResult<Produccion> getProduccionesPaginaTitulo(int page, int limit, String sortActive, String sortDirection, String term);

    PagingResult<Produccion> getProduccionesPaginaResumen(int page, int limit, String sortActive, String sortDirection, String term);
}
