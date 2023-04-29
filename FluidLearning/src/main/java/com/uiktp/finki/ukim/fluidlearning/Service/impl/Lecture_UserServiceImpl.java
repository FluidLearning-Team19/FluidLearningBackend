package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Lecture_User;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidBadRequestException;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.FluidNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Repository.LectureRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.Lecture_UserRepository;
import com.uiktp.finki.ukim.fluidlearning.Repository.UsersRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.Lecture_UserService;
import org.springframework.stereotype.Service;

@Service
public class Lecture_UserServiceImpl implements Lecture_UserService {

    private final Lecture_UserRepository lecture_userRepository;

    private final UsersRepository usersRepository;

    private final LectureRepository lectureRepository;

    public Lecture_UserServiceImpl(Lecture_UserRepository lecture_userRepository, UsersRepository usersRepository, LectureRepository lectureRepository) {
        this.lecture_userRepository = lecture_userRepository;
        this.usersRepository = usersRepository;
        this.lectureRepository = lectureRepository;
    }

    @Override
    public Lecture_User getLecture_UserById(int lectureUserId) {
        return lecture_userRepository.findById(lectureUserId).orElseThrow(() -> new FluidNotFoundException("Could not find a Lecture User with id: " + lectureUserId));
    }

    @Override
    public Lecture_User createLecture_User(Lecture_User lectureUser) {

        if (!usersRepository.existsById(lectureUser.getUser().getId()))
            throw new FluidBadRequestException("Can't create, User does not exist");

        if (!lectureRepository.existsById(lectureUser.getLecture().getId()))
            throw new FluidBadRequestException("Can't create, Lecture does not exist");

        return lecture_userRepository.save(lectureUser);
    }

    @Override
    public Lecture_User updateLecture_User(int lectureUserId, Lecture_User lectureUser) {

        if (!usersRepository.existsById(lectureUser.getUser().getId()))
            throw new FluidBadRequestException("Can't update, User does not exist");

        if (!lectureRepository.existsById(lectureUser.getLecture().getId()))
            throw new FluidBadRequestException("Can't update, Lecture does not exist");

        Lecture_User lecture_userToUpdate = lecture_userRepository.findById(lectureUserId).orElseThrow(() -> new FluidNotFoundException("Could not find a Lecture User with id: " + lectureUserId));

        lecture_userToUpdate.setDateCompleted(lectureUser.getDateCompleted());

        return lecture_userRepository.save(lecture_userToUpdate);

    }

    @Override
    public void deleteLecture_User(int lectureUserId) {
        Lecture_User lecture_userToDelete = lecture_userRepository.findById(lectureUserId).orElseThrow(() -> new FluidNotFoundException("Could not find a Lecture User with id: " + lectureUserId));

        this.lecture_userRepository.delete(lecture_userToDelete);
    }
}
