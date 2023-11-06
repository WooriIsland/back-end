package com.blacky.our_island.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.blacky.our_island.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndGetUser() {
        // Given
        User user = new User();
        user.setUserName("김진우");
        user.setNickname("jinvvoo");
        user.setCharacter("13");

        // When
        User savedUser = userRepository.save(user);
        User retrievedUser = userRepository.findById(savedUser.getUserId()).orElse(null);

        // Then
        assertNotNull(retrievedUser);
        assertEquals("김진우", retrievedUser.getUserName());
        assertEquals("jinvvoo", retrievedUser.getNickname());
        assertEquals("13", retrievedUser.getCharacter());
    }

    @Test
    public void testUpdateUser() {
        // Given
        User user = new User();
        user.setUserName("김진우");
        user.setNickname("jinwoo");
        user.setCharacter("52");

        User savedUser = userRepository.save(user);

        // When
        savedUser.setUserName("김진호 수정");
        savedUser.setNickname("jinho 수정");
        savedUser.setCharacter("52 수정");

        userRepository.save(savedUser);
        User updatedUser = userRepository.findById(savedUser.getUserId()).orElse(null);

        // Then
        assertNotNull(updatedUser);
        assertEquals("김진우 수정", updatedUser.getUserName());
        assertEquals("jinho 수정", updatedUser.getNickname());
        assertEquals("52 수정", updatedUser.getCharacter());
    }

    @Test
    public void testDeleteUser() {
        // Given
        User user = new User();
        user.setUserName("김우진 삭제");
        user.setNickname("woojin 삭제");
        user.setCharacter("789");

        User savedUser = userRepository.save(user);

        // When
        userRepository.deleteById(savedUser.getUserId());
        User deletedUser = userRepository.findById(savedUser.getUserId()).orElse(null);

        // Then
        assertNull(deletedUser);
    }
}
