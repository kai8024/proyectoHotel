package com.edu.ucentral.apphotel.persistencia.entidades;

public class Hotel {
    private int idHotel;
    private String direccionHotel;
    private String sitiosHotel;
    private List<Habitacion> habitaciones;

    // Constructor
    public Hotel(int idHotel, String direccionHotel, String sitiosHotel) {
        this.idHotel = idHotel;
        this.direccionHotel = direccionHotel;
        this.sitiosHotel = sitiosHotel;
        this.habitaciones = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdHotel() { return idHotel; }
    public void setIdHotel(int idHotel) { this.idHotel = idHotel; }

    public String getDireccionHotel() { return direccionHotel; }
    public void setDireccionHotel(String direccionHotel) { this.direccionHotel = direccionHotel; }

    public String getSitiosHotel() { return sitiosHotel; }
    public void setSitiosHotel(String sitiosHotel) { this.sitiosHotel = sitiosHotel; }

    public List<Habitacion> getHabitaciones() { return habitaciones; }
    public void addHabitacion(Habitacion habitacion) { this.habitaciones.add(habitacion); }
}
