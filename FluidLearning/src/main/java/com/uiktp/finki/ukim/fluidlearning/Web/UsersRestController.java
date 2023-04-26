package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Repository.*;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data/users")
@CrossOrigin(value = "*")
public class UsersRestController {

    private final UsersService usersService;
    private final ExamRepository examRepository;
    private final ExamQuestionRepository examQuestionRepository;
    private final ExamAnswerRepository examAnswerRepository;
    private final Exam_UserRepository exam_userRepository;
    private final CertificateRepository certificateRepository;
    private final LectureRepository lectureRepository;
    private final Course_UserRepository course_userRepository;
    private final Lecture_UserRepository lecture_userRepository;
    private final FavouriteCourseRepository favouriteCourseRepository;
    private final ProgressRepository progressRepository;
    private final RecommendationCourseRepository recommendationCourseRepository;

    public UsersRestController(UsersService usersService, ExamRepository examRepository, ExamQuestionRepository examQuestionRepository, ExamAnswerRepository examAnswerRepository, Exam_UserRepository exam_userRepository, CertificateRepository certificateRepository, LectureRepository lectureRepository, Course_UserRepository course_userRepository, Lecture_UserRepository lecture_userRepository, FavouriteCourseRepository favouriteCourseRepository, ProgressRepository progressRepository, RecommendationCourseRepository recommendationCourseRepository) {
        this.usersService = usersService;
        this.examRepository = examRepository;
        this.examQuestionRepository = examQuestionRepository;
        this.examAnswerRepository = examAnswerRepository;
        this.exam_userRepository = exam_userRepository;
        this.certificateRepository = certificateRepository;
        this.lectureRepository = lectureRepository;
        this.course_userRepository = course_userRepository;
        this.lecture_userRepository = lecture_userRepository;
        this.favouriteCourseRepository = favouriteCourseRepository;
        this.progressRepository = progressRepository;
        this.recommendationCourseRepository = recommendationCourseRepository;
    }

    @GetMapping
    public List<Users> findAll() {
        return this.usersService.findAll();
    }



}
