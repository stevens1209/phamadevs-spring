package com.pharmadevs.inventario_spring.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "factura_venta")
public class FacturaVenta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_Factura_Venta")
        private int idFacturaventa;
        @Column(name = "Fecha")
        private Date fecha;
        @Column(name ="Monto_Total")
        private String montototal;

        @ManyToOne
        @JoinColumn(name = "ID_Cliente")
        private Cliente cliente;

        public FacturaVenta() {
        }

        public FacturaVenta(int idFacturaventa, Date fecha, String montototal, Cliente cliente) {
            this.idFacturaventa = idFacturaventa;
            this.fecha = fecha;
            this.montototal = montototal;
            this.cliente = cliente;
        }

        public int getIdFacturaventa() {
            return idFacturaventa;
        }

        public void setIdFacturaventa(int idFacturaventa) {
            this.idFacturaventa = idFacturaventa;
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

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        @Override
        public String toString() {
            return "Facturaventa{" +'\'' +
                    "idFacturaventa=" + idFacturaventa +'\'' +
                    ", Fecha=" + fecha +'\'' +
                    ", Montototal='" + montototal + '\'' +
                    ", Cliente='" + cliente + '\'' +
                    '}';
        }
    }


