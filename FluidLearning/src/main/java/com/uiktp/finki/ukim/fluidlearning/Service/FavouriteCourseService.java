package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.FavouriteCourse;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface FavouriteCourseService {
    Optional<FavouriteCourse> findById(Integer id);
    List<FavouriteCourse> findAll();
    FavouriteCourse save(FavouriteCourse favouriteCourse);
    void deleteById(Integer id);
    List<CourseDto> findAllFavouriteCoursesForUser(Integer userId);
}
