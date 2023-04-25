package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.RecommendationCourse;
import com.uiktp.finki.ukim.fluidlearning.Repository.RecommendationCourseRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.RecommendationCourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class RecommendationCourseServiceImpl implements RecommendationCourseService {

    private final RecommendationCourseRepository recommendationCourseRepository;

    public RecommendationCourseServiceImpl(RecommendationCourseRepository recommendationCourseRepository) {
        this.recommendationCourseRepository = recommendationCourseRepository;
    }

    @Override
    public Optional<RecommendationCourse> findById(Integer id) {
        return this.recommendationCourseRepository.findById(id);
    }

    @Override
    public List<RecommendationCourse> findAll() {
        return this.recommendationCourseRepository.findAll();
    }

    @Override
    public RecommendationCourse save(RecommendationCourse recommendationCourse) {
        return recommendationCourseRepository.save(recommendationCourse);
    }

    @Override
    public RecommendationCourse edit(Integer id, RecommendationCourse recommendationCourse) {
        RecommendationCourse recommendationCourseNew = findById(id).orElseThrow(NoSuchElementException::new);

        recommendationCourseNew.setCourse(recommendationCourse.getCourse());
        recommendationCourseNew.setRecommendedCourse(recommendationCourse.getRecommendedCourse());

        return this.recommendationCourseRepository.save(recommendationCourseNew);
    }

    @Override
    public void deleteById(Integer id) {
        RecommendationCourse recommendationCourseNew = findById(id).orElseThrow(NoSuchElementException::new);
        if (recommendationCourseNew != null){
            this.recommendationCourseRepository.deleteById(id);
        }
    }
}
