package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Review;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Repository.ReviewRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data/users")
@CrossOrigin(value = "*")
public class UsersRestController {

    private final UsersService usersService;

    public UsersRestController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> findAll() {
        return this.usersService.findAll();
    }
}
