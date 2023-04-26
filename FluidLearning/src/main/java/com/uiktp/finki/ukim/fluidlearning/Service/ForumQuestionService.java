package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Forum;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ForumQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ForumQuestionDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ForumQuestionService {
    Optional<ForumQuestion> findById(Integer id);
    List<ForumQuestion> findAll();
    Optional<ForumQuestion> save(String content, LocalDateTime datePosted, int likes, Users user, Forum forum);
    Optional<ForumQuestion> save(ForumQuestionDto forumQuestionDto);
    Optional<ForumQuestion> edit(Integer id, String content, LocalDateTime datePosted, int likes, Users user, Forum forum);
    Optional<ForumQuestion> edit(Integer id, ForumQuestionDto forumQuestionDto);
    void deleteById(Integer id);
}
