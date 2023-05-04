package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamAnswer;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;

import java.util.List;
import java.util.Optional;

public interface ExamAnswerService {
    Optional<ExamAnswer> findById(Integer id);
    List<ExamAnswer> findAll();
    Optional<ExamAnswer> save(String content, Integer isRightAnswer, ExamQuestion examQuestion);
    Optional<ExamAnswer> edit(Integer id, String content, Integer isRightAnswer, ExamQuestion examQuestion);
    void deleteById(Integer id);
}
