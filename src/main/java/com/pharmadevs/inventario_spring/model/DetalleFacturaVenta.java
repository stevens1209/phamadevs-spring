package com.pharmadevs.inventario_spring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_factura-venta")

public class DetalleFacturaVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Detalle_Venta")
    private int idDetalleventa;
    @Column(name = "Cantidad")
    private int cantidad;
    @Column(name = "Precio_Unitario")
    private float preciounitario;
    @Column(name = "IVA")
    private String iva;
    @Column(name = "Subtotal")
    private Float subtotal;
    @ManyToOne
    @JoinColumn(name = "ID_Producto")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "ID_Factura_Venta")
    private FacturaVenta facturaVenta;


    public DetalleFacturaVenta() {
    }

    public DetalleFacturaVenta(int idDetalleventa, int cantidad, float preciounitario, String iva, Float subtotal, Producto producto,FacturaVenta facturaVenta) {
        this.idDetalleventa = idDetalleventa;
        this.cantidad = cantidad;
        this.preciounitario = preciounitario;
        this.iva = iva;
        this.subtotal = subtotal;
        this.producto = producto;
        this.facturaVenta = facturaVenta;
    }

    public int getIdDetalleventa() {
        return idDetalleventa;
    }

    public void setIdDetalleventa(int idDetalleventa) {
        this.idDetalleventa = idDetalleventa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(float preciounitario) {
        this.preciounitario = preciounitario;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaVenta getFacturaventa() {
        return facturaVenta;
    }

    public void setFacturaventa(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    @Override
    public String toString() {
        return "Detallefacturaventa{" +'\'' +
                "idDetalleventa=" + idDetalleventa +'\'' +
                ", Cantidad=" + cantidad +'\'' +
                ", Preciounitario=" + preciounitario +'\'' +
                ", Iva='" + iva + '\'' +
                ", Subtotal=" + subtotal +'\'' +
                ", Producto=" + producto +'\'' +
                ", Facturaventa=" + facturaVenta +'\'' +
                '}';
    }


    }


