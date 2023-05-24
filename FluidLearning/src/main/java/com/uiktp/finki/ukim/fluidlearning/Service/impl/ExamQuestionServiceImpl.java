package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.ExamQuestionNotFound;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamQuestionDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.ExamQuestionRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamQuestionServiceImpl implements ExamQuestionService {

    private final ExamQuestionRepository examQuestionRepository;

    public ExamQuestionServiceImpl(ExamQuestionRepository examQuestionRepository) {
        this.examQuestionRepository = examQuestionRepository;
    }

    @Override
    public Optional<ExamQuestion> findById(Integer id) {
        return this.examQuestionRepository.findById(id);
    }

    @Override
    public List<ExamQuestion> findAll() {
        return this.examQuestionRepository.findAll();
    }

    @Override
    public List<ExamQuestion> getExamQuestionsByExamId(Integer examId) {
        return examQuestionRepository.getExamQuestionsByExamId(examId);
    }

    @Override
    public Optional<ExamQuestion> save(String content, int points, Exam exam) {
        ExamQuestion examQuestion = new ExamQuestion(content,points, exam);

        return Optional.of(this.examQuestionRepository.save(examQuestion));
    }

    @Override
    public Optional<ExamQuestion> save(ExamQuestionDto examQuestionDto) {
        ExamQuestion examQuestion = new ExamQuestion();
        examQuestion.setContent(examQuestionDto.getContent());
        examQuestion.setPoints(examQuestionDto.getPoints());
        examQuestion.setExam(examQuestionDto.getExam());

        return Optional.of(this.examQuestionRepository.save(examQuestion));
    }

    @Override
    public Optional<ExamQuestion> edit(Integer id, String content, int points, Exam exam) {
        ExamQuestion examQuestion = this.findById(id).orElseThrow(() -> new ExamQuestionNotFound(id));
        examQuestion.setContent(content);
        examQuestion.setPoints(points);
        examQuestion.setExam(exam);

        return Optional.of(this.examQuestionRepository.save(examQuestion));
    }

    @Override
    public Optional<ExamQuestion> edit(Integer id, ExamQuestionDto examQuestionDto) {
        ExamQuestion examQuestion = this.examQuestionRepository.findById(id).orElseThrow(
                () -> new ExamQuestionNotFound(id));
        examQuestion.setContent(examQuestionDto.getContent());
        examQuestion.setPoints(examQuestionDto.getPoints());
        examQuestion.setExam(examQuestionDto.getExam());

        return Optional.of(examQuestionRepository.save(examQuestion));
    }

    @Override
    public void deleteById(Integer id) {
        this.examQuestionRepository.deleteById(id);
    }
}
