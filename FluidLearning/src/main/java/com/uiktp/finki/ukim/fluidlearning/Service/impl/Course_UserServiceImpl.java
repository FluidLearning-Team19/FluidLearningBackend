package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course_User;
import com.uiktp.finki.ukim.fluidlearning.Repository.Course_UserRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.Course_UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Course_UserServiceImpl implements Course_UserService {

    private final Course_UserRepository course_userRepository;

    public Course_UserServiceImpl(Course_UserRepository course_userRepository) {
        this.course_userRepository = course_userRepository;
    }

    @Override
    public Optional<Course_User> findById(Integer id) {
        return this.course_userRepository.findById(id);
    }

    @Override
    public List<Course_User> findAll() {
        return this.course_userRepository.findAll();
    }

    @Override
    public Course_User save(Course_User course_user) {
        return this.course_userRepository.save(course_user);
    }

    @Override
    public void deleteById(Integer id) {
        Course_User course_user = findById(id).orElseThrow(NoSuchElementException::new);
        if (course_user != null){
            this.course_userRepository.deleteById(id);
        }
    }

    @Override
    public List<Course> findAllCoursesForUser(Integer userId) {
        return this.course_userRepository.findAll().stream()
                .filter(s -> s.getUser().getId() == userId).map(Course_User::getCourse).collect(Collectors.toList());
    }
}
