package br.com.sgb.dto;

import br.com.sgb.model.Bibliotecario;
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
public class BibliotecarioDTO implements Serializable {
    private static final long serialVersionUID = 4152119063333328088L;

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "O campo SENHA é obrigatório")
    protected String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public BibliotecarioDTO() {
        addPerfil(Perfil.BIBLIOTECARIO);
    }

    public BibliotecarioDTO(Bibliotecario bibliotecario) {
        this.id = bibliotecario.getId();
        this.nome = bibliotecario.getNome();
        this.cpf = bibliotecario.getCpf();
        this.matricula = bibliotecario.getMatricula();
        this.telefone = bibliotecario.getTelefone();
        this.email = bibliotecario.getEmail();
        this.endereco = bibliotecario.getEndereco();
        this.perfis = bibliotecario.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.senha = bibliotecario.getSenha();
        this.dataCriacao = bibliotecario.getDataCriacao();
        addPerfil(Perfil.BIBLIOTECARIO);
    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis(){
        return this.perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }
}
