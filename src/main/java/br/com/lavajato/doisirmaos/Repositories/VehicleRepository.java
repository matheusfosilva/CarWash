package br.com.lavajato.doisirmaos.Repositories;

import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Optional<List<Vehicle>> findAllByUser(User user);
}
