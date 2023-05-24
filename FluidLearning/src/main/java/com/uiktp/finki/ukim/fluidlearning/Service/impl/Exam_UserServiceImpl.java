package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.*;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.Exam_UserDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.ExamAnswerRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.Exam_UserRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamQuestionService;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamService;
import com.uiktp.finki.ukim.fluidlearning.Service.Exam_UserService;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Exam_UserServiceImpl implements Exam_UserService {

    private final Exam_UserRepository exam_userRepository;
    private final ExamQuestionService examQuestionService;
    private final ExamAnswerRepository examAnswerRepository;
    private final ExamService examService;
    private final UsersService usersService;

    @Override
    public Exam_User findById(Integer id) {
        return exam_userRepository.findById(id).orElseThrow(() -> new FluidNotFoundException("User has not completed this exam yet."));
    }

    @Override
    public List<Exam_User> findAll() {
        return exam_userRepository.findAll();
    }

    @Override
    public void create(Integer examId, Exam_UserDto exam_userDto) {

//        Exam exam = examService.findById(examId);
//        Users user = usersService.findAuthenticatedUser();
//
//        List<ExamQuestion> questions = examQuestionService.findAll().stream().filter(question -> question.getExam().getId() == exam.getId()).toList();
//
//        Integer totalPoints = 0;
//
//        for(ExamQuestion question : questions){
//            ExamAnswer examAnswer = examAnswerRepository.findByExamQuestion_Id(question.getId());
//
//            if (examAnswer.getIsRightAnswer() == 1){
//                totalPoints += question.getPoints();
//            }
//        }
//
//        Exam_User exam_user = new Exam_User(exam, user, exam_userDto.getTotalScore());
//        exam_user.setTotalScore(totalPoints);
//
//        exam_userRepository.save(exam_user);
    }

    @Override
    public void deleteById(Integer id) {
        Exam_User exam_user = findById(id);

        exam_userRepository.delete(exam_user);
    }
}
