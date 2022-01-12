package br.com.sgb.service;

import br.com.sgb.model.Bibliotecario;
import br.com.sgb.model.Usuario;
import br.com.sgb.model.enums.Perfil;
import br.com.sgb.repository.BibliotecarioRepository;
import br.com.sgb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public void InstanciaDB(){
        Bibliotecario bibliotecario1 = new Bibliotecario(null,"admin", "355.294.317-04",
                "48.573.875-2", "98362-3312","admin@email.com",
                "Quadra QE 2 Bloco K, 598 - Guará I", "123456");
        bibliotecario1.addPerfil(Perfil.ADMIN);
        Bibliotecario bibliotecario2 = new Bibliotecario(null,"Felipe Luiz Pires", "194.268.481-93",
                "50.288.442-3", "98562-5233","felipe@email.com",
                "Rua 10, 900 - Setor Oeste (Sobradinho II)", "123456");
        Bibliotecario bibliotecario3 = new Bibliotecario(null,"Bianca Lívia Assunção", "052.496.591-95",
                "41.359.137-2", "99708-1904","bianca@email.com",
                "Quadra QI 12 Bloco E, 498 - Guará I", "123456");
        Usuario usuario = new Usuario(null,"Augusto Calebe Raimundo Oliveira", "514.853.351-08",
                "12.636.807-7", "98447-6886","augusto@email.com",
                "Setor SHLN Bloco B1, 937 - Asa Norte", "123456");
        Usuario usuario2 = new Usuario(null,"Rafaela Jaqueline Rocha", "286.228.081-06",
                "21.572.898-1", "98447-6886","rafaela@email.com",
                "Módulo Módulo E, 681 - Setor de Mansões Mestre D'Armas (Planaltina)", "123456");
        Usuario usuario3 = new Usuario(null,"Olivia Helena Souza", "134.889.911-56",
                "49.763.284-6", "98680-7897","olivia@email.com",
                "Quadra EQNP 30/34 Bloco F, 965 - Ceilândia Sul (Ceilândia)", "123456");
        Usuario usuario4 = new Usuario(null,"Hadassa Alice Rocha", "924.237.881-00",
                "18.127.907-1", "99504-6719","hadassa@email.com",
                "Setor SHLN Bloco B1, 937 - Asa Norte", "123456");
        Usuario usuario5 = new Usuario(null,"Murilo Hugo Matheus Martins", "336.706.541-27",
                "36.489.699-1", "98529-4780","murilo@email.com",
                "Quadra QN 19 Conjunto 6, 277 - Riacho Fundo II", "123456");

         bibliotecarioRepository.saveAll(Arrays.asList(bibliotecario1,bibliotecario2,bibliotecario3));
         usuarioRepository.saveAll(Arrays.asList(usuario,usuario2,usuario3,usuario4,usuario5));

    }

}
