package br.com.sgb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

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
}
