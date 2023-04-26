package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();

    Users findUserById(int userId);

    Users createUser(Users user);

    Users updateUser(int userId, Users user);

    void deleteUser(int userId);

    Users findByUsername(String username);
}
