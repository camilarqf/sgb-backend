package br.com.sgb.service;

import br.com.sgb.model.Bibliotecario;
import br.com.sgb.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public List<Bibliotecario> findAll(){
        return bibliotecarioRepository.findAll();
    }

}
