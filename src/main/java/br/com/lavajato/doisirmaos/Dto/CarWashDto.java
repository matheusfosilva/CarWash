package br.com.lavajato.doisirmaos.Dto;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Domain.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarWashDto {

    @NotNull
    private Integer ownerId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String cnpj;
    @NotEmpty
    private String phone;

    public CarWash buildCarWash(User user){
        return CarWash.builder()
                .owner(user)
                .cnpj(this.getCnpj())
                .phone(this.getPhone())
                .name(this.getName())
                .saldo(0.0)
                .build();
    }

}
