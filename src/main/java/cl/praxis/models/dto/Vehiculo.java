package cl.praxis.models.dto;

import java.sql.Timestamp;

public class Vehiculo {
    private int id;
    private int trabajadorId;
    private String marca;
    private String modelo;
    private int año;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Constructor, getters y setters

    public Vehiculo(int id, int trabajadorId, String marca, String modelo, int año, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.trabajadorId = trabajadorId;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters y setters existentes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(int trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}

