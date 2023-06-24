package br.com.lavajato.doisirmaos.Controllers;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Services.CarWashService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lava-jato")
public class CarWashController {

    private final CarWashService carWashService;

    @PostMapping
    public CarWash createCarWash(@RequestBody CarWash carWash) {
        return carWashService.createCarWash(carWash);
    }

    @GetMapping("/{id}")
    public CarWash getCarWash(@PathVariable Integer id) {
        return carWashService.getCarWash(id);
    }

    @GetMapping
    public List<CarWash> getAllCarWashes() {
        return carWashService.getAllCarWashes();
    }

    @PutMapping("/{id}")
    public CarWash updateCarWash(@PathVariable Integer id, @RequestBody CarWash updatedCarWash) {
        return carWashService.updateCarWash(id, updatedCarWash);
    }

    @DeleteMapping("/{id}")
    public void deleteCarWash(@PathVariable Integer id) {
        carWashService.deleteCarWash(id);
    }
}
