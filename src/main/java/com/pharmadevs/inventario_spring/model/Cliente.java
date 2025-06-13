package com.pharmadevs.inventario_spring.model;

import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Cliente")
    private int idCliente;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Dirección")
    private String direccion;
    @Column(name = "Teléfono")
    private String telefono;
    @Column(name = "Email")
    private String email;
    @Column(name = "DNI_RUC")
    private String ruc;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String direccion, String telefono, String email, String ruc) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ruc = ruc;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", Nombre='" + nombre + '\'' +
                ", Direccion='" + direccion + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", Email='" + email + '\'' +
                ", Ruc='" + ruc + '\'' +
                '}';
    }

}
