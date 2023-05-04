package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamQuestionDto;
import java.util.List;
import java.util.Optional;

public interface ExamQuestionService {
    Optional<ExamQuestion> findById(Integer id);
    List<ExamQuestion> findAll();
    Optional<ExamQuestion> save(String content, int points, Exam exam);
    Optional<ExamQuestion> save(ExamQuestionDto examQuestionDto);
    Optional<ExamQuestion> edit(Integer id, String content, int points, Exam exam);
    Optional<ExamQuestion> edit(Integer id, ExamQuestionDto examQuestionDto);
    void deleteById(Integer id);
}
