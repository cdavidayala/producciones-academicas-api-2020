package co.edu.udea.produccionesacademicas.api.model;

import javax.persistence.*;

@Entity
@Table(name="AutoresPorProducciones")
public class AutoresPorProducciones {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int autoresProdID;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn(name="personaID")
    private Persona autor;

    @ManyToOne(optional=false,fetch = FetchType.LAZY)
    @JoinColumn(name="produccionID")
    private Produccion produccion;

    public AutoresPorProducciones() {
    }

    public AutoresPorProducciones(Persona autor, Produccion produccion) {
        this.autor = autor;
        this.produccion = produccion;
    }

    public int getAutoresProdID() {
        return autoresProdID;
    }

    public void setAutoresProdID(int autoresProdID) {
        this.autoresProdID = autoresProdID;
    }

    public Persona getAutor() {
        return autor;
    }

    public void setAutor(Persona autor) {
        this.autor = autor;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }
}
