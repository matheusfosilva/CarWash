package br.com.lavajato.doisirmaos.Services;

import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Domain.Vehicle;
import br.com.lavajato.doisirmaos.Exceptions.ResourceNotFoundException;
import br.com.lavajato.doisirmaos.Repositories.VehicleRepository;
import br.com.lavajato.doisirmaos.Dto.VehicleDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserService userService;


    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Vehicle createVehicle(VehicleDto vehicle) {

        return vehicleRepository.saveAndFlush(
                vehicle.buildVehicle(
                        userService.getUser(vehicle.getUserId())
                )
        );
    }

    public Vehicle updateVehicle(Integer id, VehicleDto dto) {
        Vehicle vehicle = this.getVehicleById(id);
        if (vehicle != null) {
            vehicle.setModelo(dto.getModelo());
            vehicle.setMarca(dto.getMarca());
            vehicle.setPlaca(dto.getPlaca());
            return vehicleRepository.save(vehicle);
        }
        return null;
    }

    public void deleteVehicle(Integer id) {
        Vehicle vehicle = this.getVehicleById(id);
        vehicleRepository.deleteById(id);
    }
}
