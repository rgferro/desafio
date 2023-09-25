package com.rafael.desafio.services;

import com.rafael.desafio.domain.Cliente;
import com.rafael.desafio.repositories.ClienteRepository;
import com.rafael.desafio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente obj) {
        obj.setId(null);
        return clienteRepository.save(obj);
    }

    public void delete(Integer id) {
        clienteRepository.deleteById(id);
    }

    public Cliente update(Integer id, Cliente obj) {
        Cliente newObj = findById(id);
        newObj.setNome(obj.getNome());
        newObj.setEndereco(obj.getEndereco());
        return clienteRepository.save(newObj);
    }
}
