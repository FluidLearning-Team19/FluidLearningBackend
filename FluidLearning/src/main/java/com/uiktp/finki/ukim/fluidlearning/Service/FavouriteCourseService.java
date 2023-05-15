package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.FavouriteCourse;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.FavouriteCourseDto;

import java.util.List;
import java.util.Optional;

public interface FavouriteCourseService {
    Optional<FavouriteCourse> findById(Integer id);
    List<FavouriteCourse> findAll();
    FavouriteCourse save(FavouriteCourseDto favouriteCourseDto);
    void deleteById(Integer id);
    List<CourseDto> findAllFavouriteCoursesForUser(Integer userId);
}
