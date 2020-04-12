package co.edu.udea.produccionesacademicas.api.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Producciones")
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int produccionID;
    private String titulo;
    private String resumen;
    private Date fechaPublicacion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipoProdID")
    private TipoProduccion tipoProduccion;

    @OneToMany(mappedBy = "produccion", fetch = FetchType.LAZY)
    private Set<AutoresPorProducciones> autoresPorProducciones;

    @OneToMany(mappedBy = "produccion", fetch = FetchType.LAZY)
    private Set<CategoriasPorProduccion> categoriasPorProduccion;

    public Produccion(){}

    public Produccion(int produccionID, String titulo, String resumen, Date fechaPublicacion, TipoProduccion tipoProduccion) {
        this.produccionID = produccionID;
        this.titulo = titulo;
        this.resumen = resumen;
        this.fechaPublicacion = fechaPublicacion;
        this.tipoProduccion = tipoProduccion;
    }

    public int getProduccionID() {
        return produccionID;
    }

    public void setProduccionID(int produccionID) {
        this.produccionID = produccionID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public TipoProduccion getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(TipoProduccion tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    public Set<AutoresPorProducciones> getAutoresPorProducciones() {
        return autoresPorProducciones;
    }

    public void setAutoresPorProducciones(Set<AutoresPorProducciones> autoresPorProducciones) {
        this.autoresPorProducciones = autoresPorProducciones;
    }

    public Set<CategoriasPorProduccion> getCategoriasPorProduccion() {
        return categoriasPorProduccion;
    }

    public void setCategoriasPorProduccion(Set<CategoriasPorProduccion> categoriasPorProduccion) {
        this.categoriasPorProduccion = categoriasPorProduccion;
    }
}
