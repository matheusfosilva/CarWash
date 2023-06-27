package br.com.lavajato.doisirmaos.Controllers;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Domain.Wash;
import br.com.lavajato.doisirmaos.Dto.WashDto;
import br.com.lavajato.doisirmaos.Services.WashService;
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
@RequestMapping("/lavagem")
public class WashController {

    private final WashService washService;

    @PostMapping
    public ResponseEntity<Wash> createWash(@RequestBody WashDto wash) {
        return new ResponseEntity<>(washService.createWash(wash), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wash> getWash(@PathVariable Integer id) {
        return new ResponseEntity<>(washService.getWash(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Wash>> getAllWashes() {
        return new ResponseEntity<>(washService.getAllWashes(), HttpStatus.OK);
    }

    @GetMapping("/not-retired/{carWashId}")
    public ResponseEntity<List<Wash>> getAllWashesWasntRetired(@PathVariable  Integer carWashId) {
        return new ResponseEntity<>(washService.getAllWashesWasntRetired(carWashId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wash> updatePrice(@PathVariable Integer id, WashDto dto) {
        return new ResponseEntity<>(washService.updatePrice(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteWash(@PathVariable Integer id) {
        washService.deleteWash(id);
    }


    @PostMapping("/pay-wash/{id}")
    public ResponseEntity<Wash> payWash(@PathVariable Integer id) {
        return new ResponseEntity<>(washService.payWashSevice(id), HttpStatus.OK);
    }

    @PostMapping("/retire/{id}")
    public ResponseEntity<Wash> retire(@PathVariable Integer id) {
        return new ResponseEntity<>(washService.retireVehicle(id), HttpStatus.OK);
    }

}
