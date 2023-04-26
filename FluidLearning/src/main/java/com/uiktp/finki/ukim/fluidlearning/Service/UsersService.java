package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> findAll();
    Users findByUsername(String username);
}
