package com.menezesdev.services;

import com.menezesdev.dto.CategoriaDTO;
import com.menezesdev.models.Categoria;
import com.menezesdev.models.Cliente;
import com.menezesdev.repositories.CategoriaRepository;
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
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;
    public Categoria find(Integer id) {
        Optional<Categoria> categoria = repo.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria categoria){

        categoria.setId(null);
        return repo.save(categoria);
    }

    public Categoria update(Categoria categoria)
    {
        Categoria newobj = find(categoria.getId());
        updateData(newobj, categoria);
        return repo.save(newobj);
    }
    private void updateData(Categoria newObj, Categoria obj)
    {
        newObj.setNome(obj.getNome());

    }

    public void delete(Integer id){
        find(id);
        try
        {
        repo.deleteById(id);

        }catch (DataIntegrityViolationException e){
            throw  new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }
    public List<Categoria> findAll()
    {
        return repo.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);

    }

    public Categoria fromDTO(CategoriaDTO categoriaDTO){
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
    }


}
