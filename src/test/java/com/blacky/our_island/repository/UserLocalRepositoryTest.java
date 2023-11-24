//package com.blacky.our_island.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import com.blacky.our_island.local.UserLocal;
//import com.blacky.our_island.local.UserLocalRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class UserLocalRepositoryTest {
//
//    @Autowired
//    private UserLocalRepository userLocalRepository;
//
//    @Test
//    public void testSaveAndGetUser() {
//        // Given
//        UserLocal userLocal = new UserLocal();
//        userLocal.setUserName("김진우");
//        userLocal.setNickname("jinvvoo");
//        userLocal.setCharacter("13");
//
//        // When
//        UserLocal savedUserLocal = userLocalRepository.save(userLocal);
//        UserLocal retrievedUserLocal = userLocalRepository.findById(savedUserLocal.getUserId()).orElse(null);
//
//        // Then
//        assertNotNull(retrievedUserLocal);
//        assertEquals("김진우", retrievedUserLocal.getUserName());
//        assertEquals("jinvvoo", retrievedUserLocal.getNickname());
//        assertEquals("13", retrievedUserLocal.getCharacter());
//    }
//
//    @Test
//    public void testUpdateUser() {
//        // Given
//        UserLocal userLocal = new UserLocal();
//        userLocal.setUserName("김진우");
//        userLocal.setNickname("jinwoo");
//        userLocal.setCharacter("52");
//
//        UserLocal savedUserLocal = userLocalRepository.save(userLocal);
//
//        // When
//        savedUserLocal.setUserName("김진호 수정");
//        savedUserLocal.setNickname("jinho 수정");
//        savedUserLocal.setCharacter("52 수정");
//
//        userLocalRepository.save(savedUserLocal);
//        UserLocal updatedUserLocal = userLocalRepository.findById(savedUserLocal.getUserId()).orElse(null);
//
//        // Then
//        assertNotNull(updatedUserLocal);
//        assertEquals("김진우 수정", updatedUserLocal.getUserName());
//        assertEquals("jinho 수정", updatedUserLocal.getNickname());
//        assertEquals("52 수정", updatedUserLocal.getCharacter());
//    }
//
//    @Test
//    public void testDeleteUser() {
//        // Given
//        UserLocal userLocal = new UserLocal();
//        userLocal.setUserName("김우진 삭제");
//        userLocal.setNickname("woojin 삭제");
//        userLocal.setCharacter("789");
//
//        UserLocal savedUserLocal = userLocalRepository.save(userLocal);
//
//        // When
//        userLocalRepository.deleteById(savedUserLocal.getUserId());
//        UserLocal deletedUserLocal = userLocalRepository.findById(savedUserLocal.getUserId()).orElse(null);
//
//        // Then
//        assertNull(deletedUserLocal);
//    }
//}
