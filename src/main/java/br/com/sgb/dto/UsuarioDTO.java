package br.com.sgb.dto;

import br.com.sgb.model.Usuario;
import br.com.sgb.model.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = -9090598024827412184L;

    protected Integer id;

    @NotNull(message = "O campo NOME é obrigatório")
    protected String nome;

    @NotNull(message = "O campo CPF é obrigatório")
    protected String cpf;

    @NotNull(message = "O campo MATRÍCULA é obrigatório")
    protected String matricula;

    @NotNull(message = "O campo TELEFONE é obrigatório")
    protected String telefone;

    @NotNull(message = "O campo EMAIL é obrigatório")
    protected String email;

    @NotNull(message = "O campo ENDEREÇO é obrigatório")
    protected String endereco;

    protected Set<Integer> perfis = new HashSet<>();

    @NotNull(message = "O campo SENHA é obrigatório")
    protected String senha;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public UsuarioDTO() {
        addPerfil(Perfil.USUARIO);
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.matricula = usuario.getMatricula();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
        this.endereco = usuario.getEndereco();
        this.perfis = usuario.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.senha = usuario.getSenha();
        this.dataCriacao = usuario.getDataCriacao();
        addPerfil(Perfil.USUARIO);
    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis(){
        return this.perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

}
