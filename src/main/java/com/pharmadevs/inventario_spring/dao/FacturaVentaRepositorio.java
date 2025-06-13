package com.pharmadevs.inventario_spring.dao;
import com.pharmadevs.inventario_spring.model.FacturaVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaVentaRepositorio extends JpaRepository<FacturaVenta,Integer> {
}
