package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Category;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.CategoryRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.CourseRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public CourseServiceImpl(CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public CourseDto save(CourseDto courseDto) {
        //TODO check if it already exists
        Category category = this.categoryRepository.findCategoryByName(courseDto.getCategory().getName());
        Course course = new Course(courseDto.getCode(), courseDto.getTitle(),
                courseDto.getDescription(),
                courseDto.getNumberOfLectures(), category);

       this.courseRepository.save(course);

       return courseDto;
    }

    @Override
    public CourseDto edit(Integer id, CourseDto courseDto) {
        Category category = this.categoryRepository.findCategoryByName(courseDto.getCategory().getName());

        Course course = findById(id).orElseThrow(NoSuchElementException::new);
        course.setCode(courseDto.getCode());
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setNumberOfLectures(courseDto.getNumberOfLectures());
        course.setCategory(category);

        this.courseRepository.save(course);
        return courseDto;
    }

    @Override
    public void deleteById(Integer id) {
        Course course = findById(id).orElseThrow(NoSuchElementException::new);
        if (course != null){
            this.courseRepository.deleteById(id);
        }
    }
}
