package br.com.lavajato.doisirmaos.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Wash {

    @Id
    private Long id;
    @OneToOne
    private Vehicle vehicle;
    private Double price;
    @OneToOne
    private User owner;
    @OneToOne
    private CarWash carWash;
    private LocalDateTime startingTime;
    private LocalDateTime finishTime;
    private boolean pay;
    private boolean retired;
}
