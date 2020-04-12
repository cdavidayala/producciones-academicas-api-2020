package co.edu.udea.produccionesacademicas.api.model;

import javax.persistence.*;

@Entity
@Table (name="Personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personaID;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String numIdentificacion;

    @ManyToOne (optional = false, fetch = FetchType.LAZY)
    @JoinColumn (name = "tipoIID")
    private TipoIdentificacion tipoIdentificacion;

    public Persona() {
    }

    public Persona(int personaID, String nombres, String apellidos, String direccion, String telefono, String email, String numIdentificacion, TipoIdentificacion tipoIdentificacion) {
        this.personaID = personaID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.numIdentificacion = numIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getPersonaID() {
        return personaID;
    }

    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
}
