package br.com.lavajato.doisirmaos.Dto;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Domain.Vehicle;
import br.com.lavajato.doisirmaos.Domain.Wash;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WashDto {

    @NotNull
    private Integer vehicleId;
    @NotNull
    private Double price;
    @NotNull
    private Integer carWashId;


    public Wash buildWash(Vehicle vehicle, CarWash carWash){

        return Wash.builder()
                .vehicle(vehicle)
                .price(this.price)
                .carWash(carWash)
                .startingTime(LocalDateTime.now())
                .finishTime(null)
                .pay(false)
                .retired(false)
                .build();
    }


}
