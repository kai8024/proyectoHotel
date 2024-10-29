package com.edu.ucentral.apphotel.persistencia.entidades;

public class Reserva {
    private int idReserva;
    private Usuario usuario;
    private Habitacion habitacion;
    private String fechaInicio;
    private String fechaFin;
    private String estadoReserva;

    // Constructor
    public Reserva(int idReserva, Usuario usuario, Habitacion habitacion, String fechaInicio, String fechaFin, String estadoReserva) {
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoReserva = estadoReserva;
    }

    // Getters y Setters
    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Habitacion getHabitacion() { return habitacion; }
    public void setHabitacion(Habitacion habitacion) { this.habitacion = habitacion; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    public String getEstadoReserva() { return estadoReserva; }
    public void setEstadoReserva(String estadoReserva) { this.estadoReserva = estadoReserva; }
}
