package com.menezesdev.controller;

import com.menezesdev.models.Help;
import com.menezesdev.repositories.HelpRepository;
import com.menezesdev.services.CategoriaService;
import com.menezesdev.services.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/help")
public class HelpController {

    @Autowired
    private HelpService service;




    // Mapa para armazenar os comandos e suas descrições
    //private Map<String, Help> commands = new HashMap<>();

    @PostMapping("/addhelp")
    public ResponseEntity<Help> addHelp(@RequestBody Help help) {
        Help addedHelp = service.insert(help.getMetodo(), help.getComando(), help.getDescricao());
        return ResponseEntity.ok().body(addedHelp);
    }
    @GetMapping("/viewhelp")
    public ResponseEntity<String> viewHelp() {
        List<Help> helpList = service.getAllHelp();

        StringBuilder helpMessage = new StringBuilder();
        for (Help help : helpList) {
            helpMessage.append("Comando: ").append(help.getMetodo()).append(" ")
                    .append(help.getComando()).append(" ")
                    .append(help.getDescricao()).append("\n");
        }

        return ResponseEntity.ok().body(helpMessage.toString());
    }
    @DeleteMapping("/delete/{comando}")
    public ResponseEntity<String> deleteByComando(@PathVariable String comando) {
        service.deleteByComando(comando);

        return ResponseEntity.ok().body("Comando excluído com sucesso: " + comando);

    }
    /*
    @GetMapping("/viewhelp")
    public ResponseEntity<String> viewHelp() {
        StringBuilder helpMessage = new StringBuilder(); //construir a representação
        commands.forEach((comando, help) -> {
            helpMessage.append(help.getMetodo()).append(" /").append(help.getComando()).append(" \"").append(help.getDescricao()).append("\"\n");
        });
        return ResponseEntity.ok().body(helpMessage.toString());
    }*/
}



