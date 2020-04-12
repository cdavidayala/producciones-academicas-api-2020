package co.edu.udea.produccionesacademicas.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PagingResult<Produccion> {
    @JsonProperty("rows")
    public List<Produccion> data;
    public int total;

    public PagingResult(){}

    public PagingResult(List<Produccion> data, int total) {
        this.data = data;
        this.total = total;
    }

    public List<Produccion> getData() {
        return data;
    }

    public void setData(List<Produccion> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
