package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Repository.UsersRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data/users")
@CrossOrigin(value = "*")
public class UsersRestController {

    private final UsersRepository userRepository;

    public UsersRestController(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Users> findAll() {
        return this.userRepository.findAll();
    }
}
