package com.pharmadevs.inventario_spring.service;
import  com.pharmadevs.inventario_spring.model.Cliente;
import  java.util.List;
public interface ClienteService {
    public List<Cliente> findAll();
    public Cliente findOne(int id);
    public Cliente save (Cliente cliente);
    public Cliente update(int id, Cliente cliente);
    public void delete(int id);

}
