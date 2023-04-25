package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Lecture;

public interface LectureService {
    Lecture getLectureById(int lectureId);

    Lecture createLecture(Lecture lecture);

    Lecture updateLecture(int lectureId, Lecture lecture);

    void deleteLecture(int lectureId);
}
