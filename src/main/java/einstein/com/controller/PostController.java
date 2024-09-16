package einstein.com.controller;

import einstein.com.model.PostEntity;
import einstein.com.model.UserEntity;
import einstein.com.repository.PostRepository;
import einstein.com.repository.UserRepository;
import einstein.com.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// http://localhost:4406/blog/posts/user/conrado
@RestController
@RequestMapping(value="/blog")
@Api(value ="API REST Blog Posts")
@CrossOrigin(origins="*")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/posts")
    @ResponseBody
    @ApiOperation(value = "Return all posts")
    public List<PostEntity> getPostEntityList() {
        return postRepository.findAll();
    }

    @GetMapping("/posts/user/{userName}")
    @ResponseBody
    @ApiOperation(value = "Return posts for a user by their name")
    public List<PostEntity> getPostsByUserName(@PathVariable(value = "userName") String name) {
        UserEntity user = userRepository.findUserByName(name);
        return postService.getPostsByUser(user);
    }

    @PostMapping("/post")
    @ResponseBody
    @ApiOperation(value = "Create a new blog post")
    public PostEntity createPostEntity(@RequestBody PostEntity post) {
        return postRepository.save(post);
    }

    @DeleteMapping("/post/{userId}")
    @ResponseBody
    @ApiOperation(value="Delete a post by ID")
    public String deletePostEntity(@PathVariable(value = "userId") Long postId) {
        PostEntity post = postService.getPostsByUserId(postId);
        postRepository.delete(post);
        return "Post Deleted!";
    }

    @PutMapping("/post")
    @ResponseBody
    @ApiOperation(value="Update an existing post")
    public PostEntity updatePostEntity(@RequestBody PostEntity post) {
        return postRepository.save(post);
    }
}
