package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Repository.UsersRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Users findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
