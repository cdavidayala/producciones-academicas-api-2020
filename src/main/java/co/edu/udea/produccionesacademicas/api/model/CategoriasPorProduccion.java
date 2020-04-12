package co.edu.udea.produccionesacademicas.api.model;

import javax.persistence.*;

@Entity
@Table(name = "CategoriasPorProduccion")
public class CategoriasPorProduccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int rowID;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "produccionID")
    private Produccion produccion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "categoriaID")
    private Categoria categoria;

    public CategoriasPorProduccion() {
    }

    public CategoriasPorProduccion(Produccion produccion, Categoria categoria) {
        this.produccion = produccion;
        this.categoria = categoria;
    }

    public int getRowID() {
        return rowID;
    }

    public void setRowID(int rowID) {
        this.rowID = rowID;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
