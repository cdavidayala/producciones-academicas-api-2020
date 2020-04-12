package co.edu.udea.produccionesacademicas.api.model;

import javax.persistence.*;

@Entity
@Table (name="TiposProduccion")
public class TipoProduccion {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int tipoProdID;
    private String descripcion;

    public TipoProduccion() {
    }

    public TipoProduccion(int tipoProdID, String descripcion) {
        this.tipoProdID = tipoProdID;
        this.descripcion = descripcion;
    }

    public int getTipoProdID() {
        return tipoProdID;
    }

    public void setTipoProdID(int tipoProdID) {
        this.tipoProdID = tipoProdID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
