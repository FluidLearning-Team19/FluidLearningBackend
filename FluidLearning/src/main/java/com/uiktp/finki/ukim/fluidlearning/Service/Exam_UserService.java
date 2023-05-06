package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam_User;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.Exam_UserDto;

import java.util.List;

public interface Exam_UserService {

    Exam_User findById(Integer id);
    List<Exam_User> findAll();
    void create(Integer examId, Exam_UserDto exam_userDto);
    void deleteById(Integer id);
}
