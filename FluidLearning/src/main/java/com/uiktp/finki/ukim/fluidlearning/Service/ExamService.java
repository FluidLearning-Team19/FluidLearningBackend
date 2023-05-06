package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamDto;

import java.util.List;

public interface ExamService {

    List<Exam> findAll();
    Exam findById(Integer id);
    void create(ExamDto examDto);
    void update(Integer id, ExamDto examDto);
    void delete(Integer id);
}
