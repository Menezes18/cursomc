package com.menezesdev.services;


import com.menezesdev.dto.CategoriaDTO;
import com.menezesdev.dto.ClienteDTO;
import com.menezesdev.models.Categoria;
import com.menezesdev.models.Cliente;

import com.menezesdev.repositories.ClienteRepository;
import com.menezesdev.services.exceptions.DataIntegrityException;
import com.menezesdev.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente update(Cliente cliente)
    {
        Cliente newobj = find(cliente.getId());
        updateData(newobj, cliente);
        return repo.save(newobj);
    }
    private void updateData(Cliente newObj, Cliente obj)
    {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public void delete(Integer id){
        find(id);
        try
        {
            repo.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw  new DataIntegrityException("Não é possível excluir um Cliente que tem pedidos");
        }
    }
    public List<Cliente> findAll()
    {
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);

    }

    public Cliente fromDTO(ClienteDTO clienteDTO){
        return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
    }
}
