package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.*;
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
    private final ForumRepository forumRepository;
    private final ForumQuestionRepository forumQuestionRepository;
    private final NoteRepository noteRepository;
    private final ReplyRepository replyRepository;

    public UsersRestController(UsersService usersService, ExamRepository examRepository, ExamQuestionRepository examQuestionRepository, ExamAnswerRepository examAnswerRepository, Exam_UserRepository exam_userRepository, CertificateRepository certificateRepository, LectureRepository lectureRepository, Course_UserRepository course_userRepository, Lecture_UserRepository lecture_userRepository, FavouriteCourseRepository favouriteCourseRepository, ProgressRepository progressRepository, ForumRepository forumRepository, ForumQuestionRepository forumQuestionRepository, NoteRepository noteRepository, ReplyRepository replyRepository) {
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
        this.forumRepository = forumRepository;
        this.forumQuestionRepository = forumQuestionRepository;
        this.noteRepository = noteRepository;
        this.replyRepository = replyRepository;
    }

    @GetMapping
    public List<Users> findAll() {
        return this.usersService.findAll();
    }

    //*************TESTING REPOSITORIES**********
    @GetMapping("/exam")
    public List<Exam> findAllExamsTest() {
        return this.examRepository.findAll();
    }

    @GetMapping("/examquestion")
    public List<ExamQuestion> findAllExamQuestions() {
        return this.examQuestionRepository.findAll();
    }

    @GetMapping("/examanswer")
    public List<ExamAnswer> findAllExamAnswers() {
        return this.examAnswerRepository.findAll();
    }

    @GetMapping("/examuser")
    public List<Exam_User> findAllExamUsers() {
        return this.exam_userRepository.findAll();
    }

    @GetMapping("/certificate")
    public List<Certificate> findAllCertificates() {
        return this.certificateRepository.findAll();
    }

    @GetMapping("/lecture")
    public List<Lecture> findAllLectures() {
        return this.lectureRepository.findAll();
    }

    @GetMapping("/courseuser")
    public List<Course_User> findAllCourseUsers() {
        return this.course_userRepository.findAll();
    }

    @GetMapping("/lectureuser")
    public List<Lecture_User> findAllLectureUsers() {
        return this.lecture_userRepository.findAll();
    }

    @GetMapping("/favouritecourse")
    public List<FavouriteCourse> findAllFavouireCourses() {
        return this.favouriteCourseRepository.findAll();
    }

    @GetMapping("/progress")
    public List<Progress> findAllProgressForUserCourse() {
        return this.progressRepository.findAll();
    }

    @GetMapping("/forum")
    public List<Forum> findAllForum() {
        return this.forumRepository.findAll();
    }

    @GetMapping("/forumquestion")
    public List<ForumQuestion> findAllForumQuestion() {
        return this.forumQuestionRepository.findAll();
    }

    @GetMapping("/note")
    public List<Note> findAllNotes() {
        return this.noteRepository.findAll();
    }

    @GetMapping("/replies")
    public List<Reply> findAllReplies() {
        return this.replyRepository.findAll();
    }


}
