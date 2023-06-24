package br.com.lavajato.doisirmaos.Services;

import br.com.lavajato.doisirmaos.Domain.Wash;
import br.com.lavajato.doisirmaos.Repositories.WashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WashService {

    private final WashRepository washRepository;

    public Wash createWash(Wash wash) {
        return washRepository.save(wash);
    }

    public Wash getWash(Long id) {
        return washRepository.findById(id).orElse(null);
    }

    public List<Wash> getAllWashes() {
        return washRepository.findAll();
    }

    public Wash updateWash(Long id, Wash updatedWash) {
        Wash wash = washRepository.findById(id).orElse(null);
        if (wash != null) {
            wash.setVehicle(updatedWash.getVehicle());
            wash.setPrice(updatedWash.getPrice());
            wash.setOwner(updatedWash.getOwner());
            wash.setCarWash(updatedWash.getCarWash());
            wash.setStartingTime(updatedWash.getStartingTime());
            wash.setFinishTime(updatedWash.getFinishTime());
            wash.setPay(updatedWash.isPay());
            wash.setRetired(updatedWash.isRetired());
            return washRepository.save(wash);
        }
        return null;
    }

    public void deleteWash(Long id) {
        washRepository.deleteById(id);
    }
}
