package einstein.com.services;

import einstein.com.model.PostEntity;
import einstein.com.model.UserEntity;
import einstein.com.repository.PostRepository;
import einstein.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostEntity> getPostsByUser(UserEntity user) {
        return postRepository.findAllByUserId(user);
    }
    public PostEntity getPostsByUserId(Long userId) {
        return postRepository.findPostByUserId(userId);
    }
    public PostEntity getPostByTime(Date time) {
        return postRepository.findPostByTime(time);
    }
    public PostEntity getPostByData(String postData) {
        return postRepository.findAllByDataContaining(postData);
    }
}
