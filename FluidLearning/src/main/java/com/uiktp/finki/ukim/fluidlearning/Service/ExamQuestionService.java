package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;
import java.util.List;
import java.util.Optional;

public interface ExamQuestionService {
    Optional<ExamQuestion> findById(Integer id);
    List<ExamQuestion> findAll();
    Optional<ExamQuestion> save(String content, int points, Exam exam);
    Optional<ExamQuestion> edit(Integer id, String content, int points, Exam exam);
    void deleteById(Integer id);
}
