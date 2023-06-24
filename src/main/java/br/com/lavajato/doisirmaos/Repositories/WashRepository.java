package br.com.lavajato.doisirmaos.Repositories;

import br.com.lavajato.doisirmaos.Domain.Wash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WashRepository extends JpaRepository<Wash, Long> {
    // Add custom methods, if needed
}