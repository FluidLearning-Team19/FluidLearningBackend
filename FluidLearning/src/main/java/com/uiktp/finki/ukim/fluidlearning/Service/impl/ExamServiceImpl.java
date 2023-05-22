package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.ExamNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.Course_UserRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.ExamRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamService;
import com.uiktp.finki.ukim.fluidlearning.Service.ProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final Course_UserRepository courseUserRepository;
    private final ProgressService progressService;

    @Override
    public Exam findById(Integer id) {
        return examRepository.findById(id).orElseThrow(() -> new ExamNotFoundException(id));
    }

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }



    @Override
    public void create(ExamDto examDto) {
        Exam exam = new Exam(examDto);

        examRepository.save(exam);
    }

    @Override
    public void update(Integer id, ExamDto examDto) {
        Exam exam = findById(id);

        exam.modifyExam(examDto);

        examRepository.save(exam);
    }

    @Override
    public void delete(Integer id) {
        Exam exam = findById(id);

        examRepository.delete(exam);
    }
}
