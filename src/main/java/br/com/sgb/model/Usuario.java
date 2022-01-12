package br.com.sgb.model;

import br.com.sgb.dto.UsuarioDTO;
import br.com.sgb.model.enums.Perfil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Usuario extends Pessoa{
    private static final long serialVersionUID = -1951697171540809418L;

    public Usuario(Integer id, String nome, String cpf, String matricula, String telefone, String email, String endereco,
                   String senha) {
        super(id, nome, cpf, matricula, telefone, email, endereco, senha);
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.cpf = usuarioDTO.getCpf();
        this.matricula = usuarioDTO.getMatricula();
        this.telefone = usuarioDTO.getTelefone();
        this.email = usuarioDTO.getEmail();
        this.endereco = usuarioDTO.getEndereco();
        this.perfis = usuarioDTO.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.senha = usuarioDTO.getSenha();
        this.dataCriacao = usuarioDTO.getDataCriacao();
    }
}
