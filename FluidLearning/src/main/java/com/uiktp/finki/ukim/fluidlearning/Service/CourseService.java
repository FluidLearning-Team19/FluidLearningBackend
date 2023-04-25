package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<Course> findById(Integer id);
    List<Course> findAll();
    CourseDto save(CourseDto favouriteCourse);
    CourseDto edit(Integer id, CourseDto courseDto);
    void deleteById(Integer id);
}
