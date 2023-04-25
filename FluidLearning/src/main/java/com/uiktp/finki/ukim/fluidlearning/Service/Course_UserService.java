package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course_User;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;


import java.util.List;
import java.util.Optional;

public interface Course_UserService {
    Optional<Course_User> findById(Integer id);
    List<Course_User> findAll();
    Course_User save(Course_User course_user);
    void deleteById(Integer id);
    List<CourseDto> findAllCoursesForUser(Integer userId);

}
