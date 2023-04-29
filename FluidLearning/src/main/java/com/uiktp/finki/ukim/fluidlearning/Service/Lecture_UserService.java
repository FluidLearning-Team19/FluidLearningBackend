package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Lecture_User;

public interface Lecture_UserService {

    Lecture_User getLecture_UserById(int lectureUserId);

    Lecture_User createLecture_User(Lecture_User lectureUser);

    Lecture_User updateLecture_User(int lectureUserId, Lecture_User lectureUser);

    void deleteLecture_User(int lectureUserId);
}
