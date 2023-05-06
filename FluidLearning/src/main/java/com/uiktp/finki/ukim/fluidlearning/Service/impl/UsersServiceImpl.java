package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Repository.UsersRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UsersServiceImpl(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Users> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Users findUserById(int userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new FluidNotFoundException("Could not find User with id:" + userId));
    }

    @Override
    public Users createUser(Users user) {
        Users newUser = new Users();
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEnabled(1);
        newUser.setDateOfBirth(user.getDateOfBirth());
        newUser.setDateCreated(LocalDateTime.now());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return this.userRepository.save(newUser);
    }

    @Override
    public Users updateUser(int userId, Users user) {
        Users userToUpdate = this.userRepository.findById(userId).orElseThrow(() -> new FluidNotFoundException("Could not find User with id:" + userId));

        userToUpdate.setRole(user.getRole());
        if(user.getPassword() != null && !user.getPassword().isEmpty()) {
            userToUpdate.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setFirstName(user.getFirstName());

        return this.userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(int userId) {
        Users userToDelete = this.userRepository.findById(userId).orElseThrow(() -> new FluidNotFoundException("Could not find User with id:" + userId));

        this.userRepository.delete(userToDelete);
    }

    @Override
    public Users findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Users findAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return findByUsername((String) auth.getPrincipal());
    }


}
