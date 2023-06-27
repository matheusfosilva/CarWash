package br.com.lavajato.doisirmaos.Dto;

import br.com.lavajato.doisirmaos.Domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty
    private String nome;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;


    public User buildUser(){
        return User.builder()
                .nome(this.getNome())
                .email(this.getEmail())
                .phone(this.getPhone())
                .build();
    }


}
