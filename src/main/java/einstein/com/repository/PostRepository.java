package einstein.com.repository;

import einstein.com.model.PostEntity;
import einstein.com.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, String> {
    List<PostEntity> findAllByUserId(UserEntity user);
    PostEntity findPostByUserId(Long userId);
    PostEntity findPostByTime(Date time);
    PostEntity findAllByDataContaining(String postData);

    void delete(PostEntity post);

}
