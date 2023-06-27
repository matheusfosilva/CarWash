package br.com.lavajato.doisirmaos.Services;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Repositories.CarWashRepository;
import br.com.lavajato.doisirmaos.Dto.CarWashDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CarWashService {

    private final CarWashRepository carWashRepository;
    private final UserService userService;

    public CarWash createCarWash(CarWashDto dto) {

        User user = userService.getUser(dto.getOwnerId());

        if (user == null) {
            throw new RuntimeException("Usuario não existe");
        }

        return carWashRepository.save(dto.buildCarWash(user));
    }

    public CarWash getCarWash(Integer id) {
        return carWashRepository.findById(id).orElseThrow(ResolutionException::new);
    }

    public List<CarWash> getAllCarWashes() {
        return carWashRepository.findAll();
    }

    public CarWash updateCarWash(Integer id, CarWashDto updatedCarWash) {

        CarWash carWash = carWashRepository.findById(id).orElse(null);
        User user = userService.getUser(updatedCarWash.getOwnerId());

        if (carWash != null) {
            carWash.setOwner(user);
            carWash.setName(updatedCarWash.getName());
            carWash.setCnpj(updatedCarWash.getCnpj());
            carWash.setPhone(updatedCarWash.getPhone());
            return carWashRepository.save(carWash);
        }

        return null;
    }

    public void deleteCarWash(Integer id) {
        carWashRepository.deleteById(id);
    }

    public void recieveValue(CarWash carWash, Double value){
        Double saldo = carWash.getSaldo() + value;
        carWash.setSaldo(saldo);
        carWashRepository.saveAndFlush(carWash);
    }

}
