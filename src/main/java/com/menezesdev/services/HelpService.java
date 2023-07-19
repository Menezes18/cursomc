package com.menezesdev.services;

import com.menezesdev.dto.CategoriaDTO;
import com.menezesdev.models.Categoria;
import com.menezesdev.models.Help;
import com.menezesdev.repositories.CategoriaRepository;
import com.menezesdev.repositories.HelpRepository;
import com.menezesdev.services.exceptions.DataIntegrityException;
import com.menezesdev.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HelpService {

    private List<Help> helpList = new ArrayList<>();
    @Autowired
    private HelpRepository repo;

    public Help insert(String metodo, String comando, String descricao) {
        if (comandoExistente(comando)) {
            throw new DataIntegrityException("Já existe um comando com o mesmo nome.");
        }

        Help help = new Help();
        help.setMetodo(metodo);
        help.setComando(comando);
        help.setDescricao(descricao);
        helpList.add(help);

        return repo.save(help);
    }
    private boolean comandoExistente(String comando) {
        for (Help help : helpList) {
            if (help.getComando().equals(comando)) {
                return true;
            }
        }
        return false;
    }
    public ResponseEntity<String> deleteByComando(@PathVariable String comando) {
        Help helpToRemove = null;
        for (Help help : helpList) {
            if (help.getComando().equals(comando)) {
                helpToRemove = help;
                break;
            }
        }
        if (helpToRemove != null) {
            helpList.remove(helpToRemove);
            return ResponseEntity.ok().body("Comando excluído com sucesso: " + comando);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List<Help> getAllHelp() {
        return helpList;
    }



}
