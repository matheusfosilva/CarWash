package br.com.lavajato.doisirmaos.Controllers;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Services.CarWashService;
import br.com.lavajato.doisirmaos.Dto.CarWashDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CarWash> createCarWash(@RequestBody CarWashDto carWash) {
        return new ResponseEntity<>(carWashService.createCarWash(carWash), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarWash> getCarWash(@PathVariable Integer id) {
        return new ResponseEntity<>(carWashService.getCarWash(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarWash>> getAllCarWashes() {
        return new ResponseEntity<>(carWashService.getAllCarWashes(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarWash> updateCarWash(@PathVariable Integer id, @RequestBody CarWashDto updatedCarWash) {
        return new ResponseEntity<>(carWashService.updateCarWash(id, updatedCarWash), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarWash(@PathVariable Integer id) {
        carWashService.deleteCarWash(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
