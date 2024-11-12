package com.edu.ucentral.apphotel.persistencia.entidades;

import java.util.List;

public class Hotel {
    private Integer idHotel;
    private String direccion;
    private String sitiosInteres;
    private List<Habitacion> habitaciones;

    // Getters y setters
    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSitiosInteres() {
        return sitiosInteres;
    }

    public void setSitiosInteres(String sitiosInteres) {
        this.sitiosInteres = sitiosInteres;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
