package br.com.sgb.controller;

import br.com.sgb.dto.BibliotecarioDTO;
import br.com.sgb.model.Bibliotecario;
import br.com.sgb.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bibliotecarios")
public class BibliotecarioController {

    @Autowired
    private BibliotecarioService bibliotecarioService;

    @GetMapping
    public ResponseEntity<List<BibliotecarioDTO>> findAll(){
        List<Bibliotecario> bibliotecarioList = bibliotecarioService.findAll();
        List<BibliotecarioDTO> bibliotecarioDTOList = bibliotecarioList.stream().map(x -> new BibliotecarioDTO(x))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(bibliotecarioDTOList);
    }
}
