package einstein.com.controller;

import einstein.com.model.UserEntity;
import einstein.com.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/blog")
@Api(value ="API REST Blog")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    protected UserRepository userRepository;

    @GetMapping("/users")
    @ResponseBody
    @ApiOperation(value = "return all the users")
    public List<UserEntity> getUserEntityList() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{user-name}")
    @ResponseBody
    @ApiOperation(value = "return an user")
    public UserEntity getUserEntityList(@PathVariable(value = "user-name") String name) {
        return userRepository.findUserByName(name);
    }

    @PostMapping("/user")
    @ResponseBody
    @ApiOperation(value = "Return a new blog user")
    public UserEntity postUserEntity(@RequestBody UserEntity user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{user-name}")
    @ResponseBody
    @ApiOperation(value="Delete a user")
    public String deleteUserEntity(@PathVariable(value = "user-name") String name) {
        UserEntity user = userRepository.findUserByName(name);
        userRepository.delete(user);
        return "User Banned";
    }

    @PutMapping("/user")
    @ResponseBody
    @ApiOperation(value="Update a user")
    public String updateUserEntity(@RequestBody UserEntity user) {
        userRepository.save(user);
        return "User updated";
    }
}
