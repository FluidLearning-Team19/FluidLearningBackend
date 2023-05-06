package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course_User;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.CourseNotCompletedException;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Repository.Course_UserRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.ExamRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.Course_UserService;
import com.uiktp.finki.ukim.fluidlearning.Service.ProgressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Course_UserServiceImpl implements Course_UserService {

    private final Course_UserRepository course_userRepository;
    private final ProgressService progressService;
    private final ExamRepository examRepository;

    public Course_UserServiceImpl(Course_UserRepository course_userRepository, ProgressService progressService, ExamRepository examRepository) {
        this.course_userRepository = course_userRepository;
        this.progressService = progressService;
        this.examRepository = examRepository;
    }

    @Override
    public Optional<Course_User> findById(Integer id) {
        return this.course_userRepository.findById(id);
    }

    @Override
    public List<Course_User> findAll() {
        return this.course_userRepository.findAll();
    }

    @Override
    public Course_User save(Course_User course_user) {
        return this.course_userRepository.save(course_user);
    }

    @Override
    public void deleteById(Integer id) {
        Course_User course_user = findById(id).orElseThrow(NoSuchElementException::new);
        if (course_user != null){
            this.course_userRepository.deleteById(id);
        }
    }

    @Override
    public List<Course> findAllCoursesForUser(Integer userId) {
        return this.course_userRepository.findAll().stream()
                .filter(s -> s.getUser().getId() == userId).map(Course_User::getCourse).collect(Collectors.toList());
    }

    @Override
    public List<Exam> getAllExamsByCourseUserId(Integer id) {
        Course_User courseUser = course_userRepository.findById(id).orElseThrow(() -> new FluidNotFoundException("User has not opened this course yet."));

        if(progressService.findProgressByCourseUserId(courseUser.getCourse().getId(), courseUser.getUser().getId()).getPercentage() < 100.0)
            throw new CourseNotCompletedException();
        else
            return examRepository.findAllByCourseId(courseUser.getCourse().getId());
    }
}
