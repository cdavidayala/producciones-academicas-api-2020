package co.edu.udea.produccionesacademicas.api.service.impl;

import co.edu.udea.produccionesacademicas.api.exceptions.ProduccionNotFoundException;
import co.edu.udea.produccionesacademicas.api.model.PagingResult;
import co.edu.udea.produccionesacademicas.api.model.Produccion;
import co.edu.udea.produccionesacademicas.api.repository.AutoresPorProduccionRepository;
import co.edu.udea.produccionesacademicas.api.repository.CategoriasPorProduccionRepository;
import co.edu.udea.produccionesacademicas.api.repository.ProduccionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProduccionService implements ProduccionServiceInt{

    @Autowired
    private ProduccionRepository produccionRepository;
    private AutoresPorProduccionRepository autoresPorProduccionRepository;
    private CategoriasPorProduccionRepository categoriasPorProduccionRepository;

    public ProduccionService(ProduccionRepository produccionRepository, AutoresPorProduccionRepository autoresPorProduccionRepository, CategoriasPorProduccionRepository categoriasPorProduccionRepository){
        this.produccionRepository = produccionRepository;
        this.categoriasPorProduccionRepository = categoriasPorProduccionRepository;
        this.autoresPorProduccionRepository = autoresPorProduccionRepository;
    }

    @Override
    public List<Produccion> getProducciones(){return produccionRepository.findAll();}

    @Override
    public Produccion getProduccion(Integer id) {
        Optional<Produccion> posibleProduccion = produccionRepository.findById(id);
        posibleProduccion = produccionRepository.findById(id);
        if(posibleProduccion.isPresent()){
            return posibleProduccion.get();
        }else {
            return null;        }
    }

    public PagingResult<Produccion> getProduccionesPagina(int pageIndex, int pageSize, String sortActive, String sortDirection) {
        Sort sort = Sort.by(sortActive).ascending();
        if(sortDirection.equalsIgnoreCase("DESC")) {
            sort = Sort.by(sortActive).descending();
        }
        List<Produccion> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<Produccion> producciones = produccionRepository.findAll(pageableRequest);

        for (Produccion produccion : producciones) {
            Produccion produccionDto = new Produccion();
            BeanUtils.copyProperties(produccion, produccionDto);
            returnValue.add(produccionDto);
        }
        return new PagingResult<Produccion>(returnValue,
                produccionRepository.findAll().size());
    }

    public PagingResult<Produccion> getProduccionesPaginaTitulo(int pageIndex, int pageSize, String sortActive,
                                                                String sortDirection, String term) {
        Sort sort = Sort.by(sortActive).ascending();
        if(sortDirection.equalsIgnoreCase("DESC")) {
            sort = Sort.by(sortActive).descending();
        }
        List<Produccion> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<Produccion> producciones = produccionRepository.findByTituloContaining(term, pageableRequest);
        List<Produccion> produccionesEntidades = producciones.getContent();

        for (Produccion produccion : producciones) {
            Produccion produccionDto = new Produccion();
            BeanUtils.copyProperties(produccion, produccionDto);
            returnValue.add(produccionDto);
        }
        return new PagingResult<Produccion>(returnValue,
                produccionRepository.findByTituloContaining(term).size());
    }

    public PagingResult<Produccion> getProduccionesPaginaResumen(int pageIndex, int pageSize, String sortActive,
                                                                String sortDirection, String term) {
        Sort sort = Sort.by(sortActive).ascending();
        if(sortDirection.equalsIgnoreCase("DESC")) {
            sort = Sort.by(sortActive).descending();
        }
        List<Produccion> returnValue = new ArrayList<>();
        Pageable pageableRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<Produccion> producciones = produccionRepository.findByResumenContaining(term, pageableRequest);
        List<Produccion> produccionesEntidades = producciones.getContent();

        for (Produccion produccion : producciones) {
            Produccion produccionDto = new Produccion();
            BeanUtils.copyProperties(produccion, produccionDto);
            returnValue.add(produccionDto);
        }
        return new PagingResult<Produccion>(returnValue,
                produccionRepository.findByResumenContaining(term).size());
    }

    public Produccion addProduccion(Produccion produccion){
        System.out.println(produccion);
        /*if(produccion.getAutoresPorProducciones() != null) {
            for (AutoresPorProducciones autorPorProduccion : produccion.getAutoresPorProducciones()) {
                autoresPorProduccionRepository.save(autorPorProduccion);
            }
        }
        if(produccion.getCategoriasPorProduccion() != null) {
            for (CategoriasPorProduccion categoriasPorProduccion : produccion.getCategoriasPorProduccion()) {
                //categoriasPorProduccion.setProduccion();
                categoriasPorProduccionRepository.save(categoriasPorProduccion);
            }
        }*/
        /* ya se hace desde el front end*/
        /*TipoProduccion tempTipoProduccion = new TipoProduccion();
        tempTipoProduccion.setTipoProdID(2);
        tempTipoProduccion.setDescripcion("Trabajo de Grado");
        produccion.setTipoProduccion(tempTipoProduccion);*/
        return produccionRepository.save(produccion);
    }

    public Produccion updateProduccion(Integer id, Produccion produccionUpdate) {

        if (!id.equals(produccionUpdate.getProduccionID())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "id in URI does not match produccion id to update");
        }

        Optional<Produccion> op = produccionRepository.findById(id);

        if (!op.isPresent()) {
            throw new ProduccionNotFoundException("Produccion with ID (" + id + ") not found!");
        }
        Produccion orginalProduccion = op.get();

        BeanUtils.copyProperties(produccionUpdate, orginalProduccion);

        return produccionRepository.save(orginalProduccion);
    }

    public void deleteProduccion(Integer id) {

        Optional<Produccion> produccion = produccionRepository.findById(id);

        if (!produccion.isPresent()) {
            throw new ProduccionNotFoundException("Vehicle with VIN (" + id + ") not found!");
        }

        produccionRepository.delete(produccion.get());
    }
}
