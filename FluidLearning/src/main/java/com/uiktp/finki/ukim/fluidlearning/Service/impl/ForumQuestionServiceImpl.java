package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Forum;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ForumQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.ForumQuestionNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ForumQuestionDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.ForumQuestionRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ForumQuestionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ForumQuestionServiceImpl implements ForumQuestionService {

    private final ForumQuestionRepository forumQuestionRepository;

    public ForumQuestionServiceImpl(ForumQuestionRepository forumQuestionRepository) {
        this.forumQuestionRepository = forumQuestionRepository;
    }

    @Override
    public Optional<ForumQuestion> findById(Integer id) {
        return this.forumQuestionRepository.findById(id);
    }

    @Override
    public List<ForumQuestion> findAll() {
        return this.forumQuestionRepository.findAll();
    }

    @Override
    public Optional<ForumQuestion> save(String content, LocalDateTime datePosted, int likes, Users user, Forum forum) {
        ForumQuestion forumQuestion = new ForumQuestion();
        forumQuestion.setContent(content);
        forumQuestion.setDatePosted(datePosted);
        forumQuestion.setLikes(likes);
        forumQuestion.setUser(user);
        forumQuestion.setForum(forum);
        return Optional.of(this.forumQuestionRepository.save(forumQuestion));
    }

    @Override
    public Optional<ForumQuestion> save(ForumQuestionDto forumQuestionDto) {
        //TODO: How to check if it exists
        ForumQuestion forumQuestion = new ForumQuestion();
        forumQuestion.setContent(forumQuestionDto.getContent());
        forumQuestion.setDatePosted(forumQuestionDto.getDatePosted());
        forumQuestion.setLikes(forumQuestionDto.getLikes());
        forumQuestion.setUser(forumQuestionDto.getUser());
        forumQuestion.setForum(forumQuestion.getForum());
        return Optional.of(this.forumQuestionRepository.save(forumQuestion));
    }

    @Override
    public Optional<ForumQuestion> edit(Integer id, String content, LocalDateTime datePosted, int likes, Users user, Forum forum) {
        ForumQuestion forumQuestion = this.forumQuestionRepository.findById(id).orElseThrow(() -> new ForumQuestionNotFoundException(id));
        forumQuestion.setContent(content);
        forumQuestion.setDatePosted(datePosted);
        forumQuestion.setLikes(likes);
        forumQuestion.setUser(user);
        forumQuestion.setForum(forum);
        return Optional.of(this.forumQuestionRepository.save(forumQuestion));
    }

    @Override
    public Optional<ForumQuestion> edit(Integer id, ForumQuestionDto forumQuestionDto) {
        ForumQuestion forumQuestion = this.forumQuestionRepository.findById(id).orElseThrow(() -> new ForumQuestionNotFoundException(id));
        forumQuestion.setContent(forumQuestionDto.getContent());
        forumQuestion.setDatePosted(forumQuestionDto.getDatePosted());
        forumQuestion.setLikes(forumQuestionDto.getLikes());
        forumQuestion.setUser(forumQuestionDto.getUser());
        forumQuestion.setForum(forumQuestion.getForum());
        return Optional.of(this.forumQuestionRepository.save(forumQuestion));
    }

    @Override
    public void deleteById(Integer id) {
        this.forumQuestionRepository.deleteById(id);
    }
}
