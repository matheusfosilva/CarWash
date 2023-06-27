package br.com.lavajato.doisirmaos.Repositories;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Domain.Wash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WashRepository extends JpaRepository<Wash, Integer> {
    // Add custom methods, if needed

    List<Wash> findAllByCarWashAndRetiredIsFalse(CarWash wash);
}