package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Lecture;

import java.util.List;

public interface LectureService {
    Lecture getLectureById(int lectureId);

    List<Lecture> getAllLecturesByCourseId(int courseId);

    Lecture createLecture(Lecture lecture);

    Lecture updateLecture(int lectureId, Lecture lecture);

    void deleteLecture(int lectureId);
}
