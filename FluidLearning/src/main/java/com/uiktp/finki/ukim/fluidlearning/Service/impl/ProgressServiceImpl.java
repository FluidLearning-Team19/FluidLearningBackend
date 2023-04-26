package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Progress;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidBadRequestException;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Repository.Course_UserRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.ProgressRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ProgressService;
import org.springframework.stereotype.Service;

@Service
public class ProgressServiceImpl implements ProgressService {

    private final ProgressRepository progressRepository;
    private final Course_UserRepository course_userRepository;

    public ProgressServiceImpl(ProgressRepository progressRepository, Course_UserRepository course_userRepository) {
        this.progressRepository = progressRepository;
        this.course_userRepository = course_userRepository;
    }

    @Override
    public Progress findProgressById(int progressId) {
        return this.progressRepository.findById(progressId).orElseThrow(() -> new FluidNotFoundException("Could not find Progress with id:" + progressId));
    }

    @Override
    public Progress createProgress(Progress progress) {
        if (course_userRepository.existsById(progress.getCourse_user().getId()))
        {
            return this.progressRepository.save(progress);
        }
        else
        {
            throw new FluidBadRequestException("Could not create Progress for nonexisting CourseUser");
        }
    }

    @Override
    public Progress updateProgress(int progressId, Progress progress) {
        Progress progressToUpdate = this.progressRepository.findById(progressId).orElseThrow(() -> new FluidNotFoundException("Could not find Progress with id:" + progressId));

        progressToUpdate.setPercentage(progress.getPercentage());
        progressToUpdate.setStatus(progress.getStatus());

        return this.progressRepository.save(progressToUpdate);
    }

    @Override
    public void deleteProgress(int progressId) {
        Progress progressToDelete = this.progressRepository.findById(progressId).orElseThrow(() -> new FluidNotFoundException("Could not find Progress with id:" + progressId));

        this.progressRepository.delete(progressToDelete);
    }

    @Override
    public Progress findProgressByCourseUserId(int courseId, int userId) {
        return this.progressRepository.findAll().stream()
                .filter(progress ->
                        progress.getCourse_user().getUser().getId() == userId
                        && progress.getCourse_user().getCourse().getId() == courseId).findFirst()
                .orElseThrow(() -> new FluidNotFoundException("Could not find Progress for Course with id " + courseId + " and User with id: "+  userId));
    }


}
