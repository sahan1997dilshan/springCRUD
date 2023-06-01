package com.firstspringtest.SpringCrud.service;

import com.firstspringtest.SpringCrud.entity.User;
import com.firstspringtest.SpringCrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User updateUser){
        Optional<User> existingUserOptional = userRepository.findById(id);
        if(existingUserOptional.isPresent()){
            User existingUser = existingUserOptional.get();
            existingUser.setName(updateUser.getName());
            existingUser.setEmail(updateUser.getEmail());
            return userRepository.save(existingUser);
        }else{

        }

        return updateUser;
    }

}
