package com.edu.ucentral.apphotel.persistencia.entidades;

public class Habitacion {
    private int idHabitacion;
    private String tipoHabitacion;
    private double tarifaBase;
    private String estadoHabitacion;

    // Constructor
    public Habitacion(int idHabitacion, String tipoHabitacion, double tarifaBase, String estadoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.tarifaBase = tarifaBase;
        this.estadoHabitacion = estadoHabitacion;
    }

    // Getters y Setters
    public int getIdHabitacion() { return idHabitacion; }
    public void setIdHabitacion(int idHabitacion) { this.idHabitacion = idHabitacion; }

    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }

    public double getTarifaBase() { return tarifaBase; }
    public void setTarifaBase(double tarifaBase) { this.tarifaBase = tarifaBase; }

    public String getEstadoHabitacion() { return estadoHabitacion; }
    public void setEstadoHabitacion(String estadoHabitacion) { this.estadoHabitacion = estadoHabitacion; }
}
