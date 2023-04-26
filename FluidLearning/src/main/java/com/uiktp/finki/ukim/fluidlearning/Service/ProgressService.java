package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Progress;

public interface ProgressService {

    Progress findProgressById(int progressId);


    Progress createProgress(Progress progress);

    Progress updateProgress(int progressId, Progress progress);

    void deleteProgress(int progressId);

    Progress findProgressByCourseUserId(int courseId, int userId);
}
