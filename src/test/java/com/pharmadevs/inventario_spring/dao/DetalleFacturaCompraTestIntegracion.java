package com.pharmadevs.inventario_spring.dao;

import com.pharmadevs.inventario_spring.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class DetalleFacturaCompraTestIntegracion {
    @Autowired
    private FacturaCompra facturaCompraRepositorio;
    @Autowired
    private Producto productoRepositorio;

    @Test
    public void findAll(){
        List<DetalleFacturaCompra> detalleFacturaCompras = detalleFacturaCompra.findAll();
        assertNotNull(detalleFacturaCompras);
        assertTrue(detalleFacturaCompras.size()>0);
        for(FacturaVenta item : detalleFacturaCompras){
            System.out.println(item.toString());
        }

    }
    //Buscar una factura
    @Test
    public void finOne(){
        Optional<FacturaVenta> facturaVentaExistente = facturaVentaRepositorio.findById(1);
        assertNotNull(facturaVentaExistente.isPresent());
        assertEquals("134.79",facturaVentaExistente.orElse(null).getMontototal(),"La factura deberia existir en la BD");
        System.out.println(facturaVentaExistente.toString());
    }

    //guardar datos
    @Test
    public void save(){
        Optional<Cliente> cliente = clienteRepositorio.findById(1);
        FacturaVenta facturaVenta = new FacturaVenta(0,new Date(),"12.32", cliente.orElse(null));
        FacturaVenta facturaVentaGuardada =facturaVentaRepositorio.save(facturaVenta);
        assertNotNull(facturaVentaGuardada);
        assertEquals("12.32",facturaVentaGuardada.getMontototal());

    }

    //Actualizar cambiando cliente
    @Test
    public void update(){
        Optional<FacturaVenta> facturaVenta = facturaVentaRepositorio.findById(20);//ver en msql cual es la factura que queremos actualizar
        Optional<Cliente> cliente = clienteRepositorio.findById(2);
        facturaVenta.orElse(null).setFecha(new Date());
        facturaVenta.orElse(null).setMontototal("150.2");
        facturaVenta.orElse(null).setCliente(cliente.orElse(null));

        FacturaVenta facturaVentaActualizada = facturaVentaRepositorio.save(facturaVenta.orElse(null));

        assertNotNull(facturaVentaActualizada);
        assertEquals("150.2",facturaVentaActualizada.getMontototal());

    }
    //eliminar
    @Test
    public void delete(){
        if(facturaVentaRepositorio.existsById(20)){
            facturaVentaRepositorio.deleteById(20);
        }
        assertFalse(facturaVentaRepositorio.existsById(20));
    }
}
