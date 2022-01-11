package br.com.sgb.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"),
    BIBLIOTECARIO(1, "ROLE_BIBLIOTECARIO"),
    USUARIO(2, "ROLE_USUARIO");

    private Integer codigo;
    private String descricao;

    public static Perfil toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(Perfil x: Perfil.values()){
            if(codigo.equals(x.getCodigo())){
                return x;
            }
        }

        throw  new IllegalArgumentException("Perfil inválido");
    }
}
