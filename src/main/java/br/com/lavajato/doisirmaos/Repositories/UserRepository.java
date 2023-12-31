package br.com.lavajato.doisirmaos.Repositories;

import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<Vehicle> findAllVehiclesById(User user);
}
