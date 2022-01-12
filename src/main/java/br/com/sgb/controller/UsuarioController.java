package br.com.sgb.controller;

import br.com.sgb.dto.UsuarioDTO;
import br.com.sgb.model.Usuario;
import br.com.sgb.repository.UsuarioRepository;
import br.com.sgb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> usuarioList = usuarioService.findAll();
        List<UsuarioDTO> usuarioDTOList = usuarioList.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usuarioDTOList);
    }
}
