package com.edu.ucentral.apphotel.persistencia.entidades;

public class Habitacion {
    private Integer idHabitacion;
    private String tipo;
    private Double tarifaBase;
    private String estado;

    // Getters y setters
    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(Double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
