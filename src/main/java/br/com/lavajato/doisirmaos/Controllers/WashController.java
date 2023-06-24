package br.com.lavajato.doisirmaos.Controllers;

import br.com.lavajato.doisirmaos.Domain.Wash;
import br.com.lavajato.doisirmaos.Services.WashService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lavagem")
public class WashController {

    private final WashService washService;

    @PostMapping
    public Wash createWash(@RequestBody Wash wash) {
        return washService.createWash(wash);
    }

    @GetMapping("/{id}")
    public Wash getWash(@PathVariable Long id) {
        return washService.getWash(id);
    }

    @GetMapping
    public List<Wash> getAllWashes() {
        return washService.getAllWashes();
    }

    @PutMapping("/{id}")
    public Wash updateWash(@PathVariable Long id, @RequestBody Wash updatedWash) {
        return washService.updateWash(id, updatedWash);
    }

    @DeleteMapping("/{id}")
    public void deleteWash(@PathVariable Long id) {
        washService.deleteWash(id);
    }
}
