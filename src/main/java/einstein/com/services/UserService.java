package einstein.com.services;

import einstein.com.model.UserEntity;
import einstein.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getUserNameByEmail(String email) {
        UserEntity user = userRepository.findUserByEmail(email);
        return user.getName();
    }

    public String getUserEmailByName(String name) {
        UserEntity user = userRepository.findUserByName(name);
        return user.getEmail();
    }

    public Long findUserById(Long id) {
        UserEntity user = userRepository.findUserById(id);
        return user.getId();
    }
}
