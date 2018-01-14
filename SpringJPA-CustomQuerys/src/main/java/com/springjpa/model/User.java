package com.springjpa.model;

import javax.persistence.*;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
@Entity
@Table(name="users")
public class User {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nombre;

    private String apellido;

    private String usuario;

    private String contrasena;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public User() {}

}
