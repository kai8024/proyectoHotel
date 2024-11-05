package com.edu.ucentral.apphotel.persistencia.entidades;

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String correoUsuario;
    private int numTelUsuario;

    // Constructor
    public Usuario() {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.numTelUsuario = numTelUsuario;
    }

    // Getters y Setters
    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getCorreoUsuario() { return correoUsuario; }
    public void setCorreoUsuario(String correoUsuario) { this.correoUsuario = correoUsuario; }

    public int getNumTelUsuario() { return numTelUsuario; }
    public void setNumTelUsuario(int numTelUsuario) { this.numTelUsuario = numTelUsuario; }

    public Object getPassword() {
        return null;
    }

    public Object getContraseña() {
        return null;
    }

    public void setContraseña(String contraseña) {
    }
}

