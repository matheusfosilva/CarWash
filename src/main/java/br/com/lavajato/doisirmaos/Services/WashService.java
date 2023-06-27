package br.com.lavajato.doisirmaos.Services;

import br.com.lavajato.doisirmaos.Domain.CarWash;
import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Domain.Vehicle;
import br.com.lavajato.doisirmaos.Domain.Wash;
import br.com.lavajato.doisirmaos.Dto.WashDto;
import br.com.lavajato.doisirmaos.Exceptions.ResourceNotFoundException;
import br.com.lavajato.doisirmaos.Repositories.WashRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WashService {

    private final WashRepository washRepository;
    private final VehicleService vehicleService;
    private final CarWashService carWashService;

    public Wash createWash(WashDto dto) {
        Vehicle vehicle = vehicleService.getVehicleById(dto.getVehicleId());
        CarWash carWash = carWashService.getCarWash(dto.getCarWashId());
        return washRepository.save(dto.buildWash(vehicle, carWash));
    }

    public Wash getWash(Integer id) {
        return washRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<Wash> getAllWashes() {
        return washRepository.findAll();
    }

    public List<Wash> getAllWashesWasntRetired(Integer carWashId) {
        CarWash carWash = carWashService.getCarWash(carWashId);
        return washRepository.findAllByCarWashAndRetiredIsFalse(carWash);
    }

    public Wash updatePrice(Integer id, WashDto washDto){
        Wash wash = this.getWash(id);
        wash.setPrice(washDto.getPrice());
        return washRepository.save(wash);
    }

    public void deleteWash(Integer id) {
        washRepository.deleteById(id);
    }

    public Wash payWashSevice(Integer washId){
        Wash wash = this.getWash(washId);
        wash.setPay(true);

        CarWash carWash = carWashService.getCarWash(wash.getCarWash().getId());
        carWashService.recieveValue(carWash, wash.getPrice());

       return washRepository.saveAndFlush(wash);

    }

    public Wash retireVehicle(Integer washId){
        Wash wash = this.getWash(washId);

        if(!wash.isPay()){
            throw new RuntimeException("O Veiculo ainda não foi pago!");
        }

        wash.setRetired(true);
        wash.setFinishTime(LocalDateTime.now());

        return washRepository.saveAndFlush(wash);

    }

}
