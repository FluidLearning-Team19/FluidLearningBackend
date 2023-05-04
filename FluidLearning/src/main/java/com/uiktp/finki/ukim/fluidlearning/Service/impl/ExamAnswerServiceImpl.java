package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamAnswer;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.ExamAnswerNotFound;
import com.uiktp.finki.ukim.fluidlearning.Repository.ExamAnswerRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamAnswerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamAnswerServiceImpl implements ExamAnswerService {

    private final ExamAnswerRepository examAnswerRepository;

    public ExamAnswerServiceImpl(ExamAnswerRepository examAnswerRepository) {
        this.examAnswerRepository = examAnswerRepository;
    }

    @Override
    public Optional<ExamAnswer> findById(Integer id) {
        return this.examAnswerRepository.findById(id);
    }

    @Override
    public List<ExamAnswer> findAll() {
        return this.examAnswerRepository.findAll();
    }

    @Override
    public Optional<ExamAnswer> save(String content, Integer isRightAnswer, ExamQuestion examQuestion) {
        ExamAnswer examAnswer = new ExamAnswer(content, isRightAnswer, examQuestion);

        return Optional.of(this.examAnswerRepository.save(examAnswer));
    }

    @Override
    public Optional<ExamAnswer> edit(Integer id, String content, Integer isRightAnswer, ExamQuestion examQuestion) {
        ExamAnswer examAnswer = this.findById(id).orElseThrow(() -> new ExamAnswerNotFound(id));
        examAnswer.setContent(content);
        examAnswer.setIsRightAnswer(isRightAnswer);
        examAnswer.setExamQuestion(examQuestion);

        return Optional.of(this.examAnswerRepository.save(examAnswer));
    }

    @Override
    public void deleteById(Integer id) {
        this.examAnswerRepository.deleteById(id);
    }
}
