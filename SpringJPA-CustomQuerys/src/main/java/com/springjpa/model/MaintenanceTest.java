package com.springjpa.model;

import javax.persistence.*;

/**
 * Created by Jimmy Ismael Pena on 2/26/2017.
 */
@Entity
@Table(name="mantenimiento_prueba")
public class MaintenanceTest {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name = "descripcion")
    private String descripcion;

    public MaintenanceTest(){};

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "MaintenanceTest{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
