package com.blacky.our_island.controller;

import com.blacky.our_island.domain.User;
import com.blacky.our_island.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setUserName(updatedUser.getUserName());
            user.setNickname(updatedUser.getNickname());
            user.setCharacter(updatedUser.getCharacter());
            user.setIslandId(updatedUser.getIslandId());
            return userRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
