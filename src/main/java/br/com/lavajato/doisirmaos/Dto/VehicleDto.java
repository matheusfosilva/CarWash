package br.com.lavajato.doisirmaos.Dto;

import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Domain.Vehicle;
import br.com.lavajato.doisirmaos.Domain.VehicleType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {

    @NotEmpty
    private String marca;
    private String modelo;
    @NotEmpty
    private String placa;

    private Integer userId;

    public Vehicle buildVehicle(User user){

        return Vehicle.builder()
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .user(user)
                .build();
    }
}
