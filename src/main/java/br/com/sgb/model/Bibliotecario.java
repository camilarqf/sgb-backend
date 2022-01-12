package br.com.sgb.model;

import br.com.sgb.dto.BibliotecarioDTO;
import br.com.sgb.model.enums.Perfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Bibliotecario extends Pessoa{
    private static final long serialVersionUID = -4348948454980699407L;

    public Bibliotecario(Integer id, String nome, String cpf, String matricula, String telefone, String email,
                         String endereco, String senha) {
        super(id, nome, cpf, matricula, telefone, email, endereco, senha);
        addPerfil(Perfil.BIBLIOTECARIO);
    }

    public Bibliotecario() {
        addPerfil(Perfil.BIBLIOTECARIO);
    }

    public Bibliotecario(BibliotecarioDTO bibliotecarioDTO) {
        this.id = bibliotecarioDTO.getId();
        this.nome = bibliotecarioDTO.getNome();
        this.cpf = bibliotecarioDTO.getCpf();
        this.matricula = bibliotecarioDTO.getMatricula();
        this.telefone = bibliotecarioDTO.getTelefone();
        this.email = bibliotecarioDTO.getEmail();
        this.endereco = bibliotecarioDTO.getEndereco();
        this.perfis = bibliotecarioDTO.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.senha = bibliotecarioDTO.getSenha();
        this.dataCriacao = bibliotecarioDTO.getDataCriacao();
        addPerfil(Perfil.BIBLIOTECARIO);
    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis(){
        return this.perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

}
