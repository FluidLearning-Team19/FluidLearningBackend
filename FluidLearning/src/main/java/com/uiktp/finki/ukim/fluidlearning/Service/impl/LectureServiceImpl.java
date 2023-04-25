package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Category;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Lecture;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Repository.CategoryRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.CourseRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.LectureRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.LectureService;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public LectureServiceImpl(LectureRepository lectureRepository, CourseRepository courseRepository, CategoryRepository categoryRepository) {
        this.lectureRepository = lectureRepository;
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Lecture getLectureById(int lectureId) {
        return lectureRepository.findById(lectureId).orElseThrow(() -> new FluidNotFoundException("Could not find a Lecture with this id: " + lectureId));
    }

    @Override
    public Lecture createLecture(Lecture lecture) {
        if (!categoryRepository.existsById(lecture.getCourse().getCategory().getId()))
        {
            categoryRepository.save(lecture.getCourse().getCategory());
        }
        if (!courseRepository.existsById(lecture.getCourse().getId()))
        {
            courseRepository.save(lecture.getCourse());
        }

        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture updateLecture(int lectureId, Lecture lecture) {
        Lecture lectureToUpdate = lectureRepository.findById(lectureId).orElseThrow(() -> new FluidNotFoundException("Could not find a Lecture with this id: " + lectureId));

        lectureToUpdate.setOrdinalNumber(lecture.getOrdinalNumber());
        lectureToUpdate.setTitle(lecture.getTitle());
        lectureToUpdate.setDescription(lecture.getDescription());
        lectureToUpdate.setContentMaterials(lecture.getContentMaterials());

        Category categoryToUpdate = categoryRepository.findById(lectureToUpdate.getCourse().getCategory().getId()).orElse(new Category());
        categoryToUpdate.setDescription(lecture.getCourse().getCategory().getDescription());
        categoryToUpdate.setName(lecture.getCourse().getCategory().getName());

        categoryRepository.save(categoryToUpdate);

        Course courseToUpdate = courseRepository.findById(lectureToUpdate.getCourse().getId()).orElse(new Course());
        courseToUpdate.setDescription(lecture.getCourse().getDescription());
        courseToUpdate.setTitle(lecture.getCourse().getTitle());
        courseToUpdate.setNumberOfLectures(lecture.getCourse().getNumberOfLectures());
        courseToUpdate.setCode(lecture.getCourse().getCode());

        courseRepository.save(courseToUpdate);

        return lectureRepository.save(lectureToUpdate);
    }

    @Override
    public void deleteLecture(int lectureId) {
        Lecture lectureToDelete = lectureRepository.findById(lectureId).orElseThrow(() -> new FluidNotFoundException("Could not find a Lecture with this id: " + lectureId));

        lectureRepository.delete(lectureToDelete);
    }


}
