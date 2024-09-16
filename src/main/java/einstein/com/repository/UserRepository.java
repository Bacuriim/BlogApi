package einstein.com.repository;

import einstein.com.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, String> {
    UserEntity findUserByName(String name);
    UserEntity findUserByEmail(String email);
    UserEntity findUserById(Long id);

    void delete(UserEntity user);
}

