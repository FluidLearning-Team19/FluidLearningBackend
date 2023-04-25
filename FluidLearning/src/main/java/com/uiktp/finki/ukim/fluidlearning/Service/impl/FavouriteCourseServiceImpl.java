package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.FavouriteCourse;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.FavouriteCourseRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.FavouriteCourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteCourseServiceImpl implements FavouriteCourseService {

    private final FavouriteCourseRepository favouriteCourseRepository;

    public FavouriteCourseServiceImpl(FavouriteCourseRepository favouriteCourseRepository) {
        this.favouriteCourseRepository = favouriteCourseRepository;
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
    public FavouriteCourse save(FavouriteCourse favouriteCourse) {
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
