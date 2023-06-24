package br.com.lavajato.doisirmaos.Services;

import br.com.lavajato.doisirmaos.Domain.User;
import br.com.lavajato.doisirmaos.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Integer id, User updatedUser) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setNome(updatedUser.getNome());
            user.setEmail(updatedUser.getEmail());
            user.setTelefone(updatedUser.getTelefone());
            user.setAndress(updatedUser.getAndress());
            user.setVehicle(updatedUser.getVehicle());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
