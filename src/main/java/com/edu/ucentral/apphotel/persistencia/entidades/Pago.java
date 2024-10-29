package com.edu.ucentral.apphotel.persistencia.entidades;

public class Pago {
    private int idPago;
    private double monto;
    private String estadoPago;

    // Constructor
    public Pago(int idPago, double monto, String estadoPago) {
        this.idPago = idPago;
        this.monto = monto;
        this.estadoPago = estadoPago;
    }

    // Getters y Setters
    public int getIdPago() { return idPago; }
    public void setIdPago(int idPago) { this.idPago = idPago; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getEstadoPago() { return estadoPago; }
    public void setEstadoPago(String estadoPago) { this.estadoPago = estadoPago; }
}
