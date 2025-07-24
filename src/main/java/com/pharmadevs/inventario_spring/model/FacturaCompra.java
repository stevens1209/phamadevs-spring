package com.pharmadevs.inventario_spring.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "factura_compra")

public class FacturaCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Factura_Compra")
    private int idFacturacompra;
    @Column(name = "Fecha")
    private Date fecha;
    @Column(name = "Monto_total")
    private String montototal;

    //Patron de inyeccion de dependecias
    @ManyToOne
    @JoinColumn(name = "ID_Proveedor")
    private Proveedor proveedor;

    public FacturaCompra() {
    }

    public FacturaCompra(int idFacturacompra, Date fecha, String montototal) {
        this.idFacturacompra = idFacturacompra;
        this.fecha = fecha;
        this.montototal = montototal;
        proveedor = proveedor;
    }

    public int getIdFacturacompra() {
        return idFacturacompra;
    }

    public void setIdFacturacompra(int idFacturacompra) {
        this.idFacturacompra = idFacturacompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMontototal() {
        return montototal;
    }

    public void setMontototal(String montototal) {
        this.montototal = montototal;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Facturacompra{" +
                "idFacturacompra=" + idFacturacompra +'\'' +
                ", Fecha=" + fecha +'\'' +
                ", Montototal='" + montototal + '\'' +
                ", Proveedor='" + proveedor + '\'' +
                '}';
    }
}
