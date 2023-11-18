package com.blacky.our_island.local;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLocalService {

    @Autowired
    private UserLocalRepository userLocalRepository;

    public List<UserLocal> getAllUsers() {
        return userLocalRepository.findAll();
    }

    public UserLocal getUserById(Long userId) {
        return userLocalRepository.findById(userId).orElse(null);
    }

    public UserLocal createUser(UserLocal userLocal) {
        return userLocalRepository.save(userLocal);
    }

    public UserLocal updateUser(Long userId, UserLocal updatedUserLocal) {
        UserLocal userLocal = userLocalRepository.findById(userId).orElse(null);
        if (userLocal != null) {
            userLocal.setUserName(updatedUserLocal.getUserName());
            userLocal.setNickname(updatedUserLocal.getNickname());
            userLocal.setCharacter(updatedUserLocal.getCharacter());
            userLocal.setIslandId(updatedUserLocal.getIslandId());
            return userLocalRepository.save(userLocal);
        }
        return null;
    }

    public void deleteUser(Long userId) {
        userLocalRepository.deleteById(userId);
    }
}
