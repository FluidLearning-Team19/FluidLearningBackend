package com.uiktp.finki.ukim.fluidlearning.Repository;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Course_UserRepository extends JpaRepository<Course_User, Integer> {
}
