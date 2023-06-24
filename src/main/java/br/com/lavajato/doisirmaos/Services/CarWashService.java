package br.com.lavajato.doisirmaos.Services;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Repositories.CarWashRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarWashService {

    private final CarWashRepository carWashRepository;

    public CarWash createCarWash(CarWash carWash) {
        return carWashRepository.save(carWash);
    }

    public CarWash getCarWash(Integer id) {
        return carWashRepository.findById(id).orElse(null);
    }

    public List<CarWash> getAllCarWashes() {
        return carWashRepository.findAll();
    }

    public CarWash updateCarWash(Integer id, CarWash updatedCarWash) {
        CarWash carWash = carWashRepository.findById(id).orElse(null);
        if (carWash != null) {
            carWash.setOwner(updatedCarWash.getOwner());
            carWash.setLocale(updatedCarWash.getLocale());
            carWash.setName(updatedCarWash.getName());
            carWash.setCnpj(updatedCarWash.getCnpj());
            carWash.setPhone(updatedCarWash.getPhone());
            carWash.setSaldo(updatedCarWash.getSaldo());
            return carWashRepository.save(carWash);
        }
        return null;
    }

    public void deleteCarWash(Integer id) {
        carWashRepository.deleteById(id);
    }
}
