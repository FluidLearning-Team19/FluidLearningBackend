package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.RecommendationCourse;

import java.util.List;
import java.util.Optional;

public interface RecommendationCourseService {
    Optional<RecommendationCourse> findById(Integer id);
    List<RecommendationCourse> findAll();
    RecommendationCourse save(RecommendationCourse favouriteCourse);
    RecommendationCourse edit(Integer id, RecommendationCourse courseDto);
    void deleteById(Integer id);
}
