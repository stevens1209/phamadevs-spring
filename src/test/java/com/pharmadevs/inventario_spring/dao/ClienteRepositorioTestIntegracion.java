package com.pharmadevs.inventario_spring.dao;

import com.pharmadevs.inventario_spring.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)

public class ClienteRepositorioTestIntegracion {

    @Autowired //inyeccion de dependencias
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void findAll (){
        List<Cliente> clientes = clienteRepositorio.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size()>0);

        for (Cliente item : clientes) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Cliente> cliente =clienteRepositorio.findById(1);
        assertTrue(cliente.isPresent(), "El cliente con id=1 deberia en la base de datos");
        System.out.println(cliente.toString());


    }
    //insertar datos
    @Test
    public void save(){
        Cliente cliente =new Cliente(0,"Steven","Lumbisi","099999999","stevens@mail.com","11554545");
        Cliente clienteGuardado = clienteRepositorio.save(cliente);
        assertNotNull(clienteGuardado.getIdCliente(),"El cliente guardado debe tener un Id");
        assertEquals("Steve",clienteGuardado.getNombre());
        assertEquals("Lumbisi",clienteGuardado.getDireccion());

    }

    //actualizar
    @Test
    public void update(){
        Optional<Cliente> clienteExistente = clienteRepositorio.findById(41);
        assertTrue(clienteExistente.isPresent());

        clienteExistente.orElse(null).setNombre("Natanael");
        clienteExistente.orElse(null).setDireccion("Lumbi");
        clienteExistente.orElse(null).setTelefono("0964180843");
        clienteExistente.orElse(null).setEmail("natanael@ismac.edu.ec");
        clienteExistente.orElse(null).setRuc("natanael@ismac.edu.ec");

        Cliente clienteActualizado = clienteRepositorio.save(clienteExistente.orElse(null));

        assertEquals("Natanael",clienteActualizado.getNombre());
        assertEquals("Lumbi",clienteActualizado.getDireccion());

    }

    //Borrar
    @Test
    public void delete(){
        if(clienteRepositorio.existsById(41)){
            clienteRepositorio.deleteById(41);

        }
        assertFalse(clienteRepositorio.existsById(41),"El id=41 deberia haberse eliminado");

    }
}
