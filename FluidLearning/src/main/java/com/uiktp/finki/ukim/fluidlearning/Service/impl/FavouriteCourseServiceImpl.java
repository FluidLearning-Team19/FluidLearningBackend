package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.FavouriteCourse;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.FavouriteCourseDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.FavouriteCourseRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.CourseService;
import com.uiktp.finki.ukim.fluidlearning.Service.FavouriteCourseService;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FavouriteCourseServiceImpl implements FavouriteCourseService {

    private final FavouriteCourseRepository favouriteCourseRepository;
    private final CourseService courseService;
    private final UsersService usersService;

    public FavouriteCourseServiceImpl(FavouriteCourseRepository favouriteCourseRepository, CourseService courseService, UsersService usersService) {
        this.favouriteCourseRepository = favouriteCourseRepository;
        this.courseService = courseService;
        this.usersService = usersService;
    }

    @Override
    public Optional<FavouriteCourse> findById(Integer id) {
        return this.favouriteCourseRepository.findById(id);
    }

    @Override
    public List<FavouriteCourse> findAll() {
        return this.favouriteCourseRepository.findAll();
    }

    @Override
    public FavouriteCourse save(FavouriteCourseDto favouriteCourseDto) {
        Course course = this.courseService.findById(favouriteCourseDto.getCourseId()).orElseThrow(NoSuchElementException::new);
        Users user = this.usersService.findUserById(favouriteCourseDto.getUserId());
        FavouriteCourse favouriteCourse = new FavouriteCourse(course, user, LocalDateTime.now());
        return this.favouriteCourseRepository.save(favouriteCourse);
    }

    @Override
    public void deleteById(Integer id) {
        if (id !=null) {
            this.favouriteCourseRepository.deleteById(id);
        }
    }

    @Override
    public List<CourseDto> findAllFavouriteCoursesForUser(Integer userId) {
        return this.favouriteCourseRepository.findAllFavouriteCoursesForUser(userId);
    }

}
