package com.pharmadevs.inventario_spring.service;

import com.pharmadevs.inventario_spring.dao.ClienteRepositorio;
import com.pharmadevs.inventario_spring.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> findAll(){
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente findOne(int id) {
        Optional<Cliente> cliente = clienteRepositorio.findById (id);
        return cliente.orElse(null);
    }

    @Override
    public Cliente update(int id, Cliente cliente) {
        Cliente clienteExistente = findOne(id);
        if (clienteExistente == null) {
            return null;
        }
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setRuc(cliente.getRuc());
        return clienteRepositorio.save(clienteExistente);
    }

    @Override
    public void delete(int id){
        if(clienteRepositorio.existsById(id)){
            clienteRepositorio.deleteById(id);
        }
    }

}