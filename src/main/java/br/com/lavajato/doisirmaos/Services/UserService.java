package br.com.lavajato.doisirmaos.Services;

import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Domain.Vehicle;
import br.com.lavajato.doisirmaos.Repositories.UserRepository;
import br.com.lavajato.doisirmaos.Dto.UserDto;
import br.com.lavajato.doisirmaos.Exceptions.ResourceNotFoundException;
import br.com.lavajato.doisirmaos.Repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserDto user) {
        return userRepository.saveAndFlush(user.buildUser());
    }


    public User getUser(Integer id) {
        return userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Integer id, UserDto updatedUser) {
        User user = this.getUser(id);
        if (user != null) {
            user.setNome(updatedUser.getNome());
            user.setEmail(updatedUser.getEmail());
            user.setPhone(updatedUser.getPhone());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
