package com.uiktp.finki.ukim.fluidlearning.Security;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Users user = usersRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = User.withUsername(user.getUsername()).password(user.getPassword()).authorities("USER").build();
        return userDetails;
    }

}
