package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Repository.UsersRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;

    public UsersServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
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
        return this.userRepository.save(user);
    }

    @Override
    public Users updateUser(int userId, Users user) {
        Users userToUpdate = this.userRepository.findById(userId).orElseThrow(() -> new FluidNotFoundException("Could not find User with id:" + userId));

        userToUpdate.setRole(user.getRole());
        userToUpdate.setPassword(user.getPassword());
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
}
