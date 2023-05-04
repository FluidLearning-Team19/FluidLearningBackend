package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ForumQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Reply;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ReplyDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReplyService {
    Optional<Reply> findById(Integer id);

    List<Reply> findAll();

    Optional<Reply> save(String content, LocalDateTime datePosted, int likes, Users user, ForumQuestion forumQuestion);

    Optional<Reply> save(ReplyDto replyDto);

    Optional<Reply> edit(Integer id, String content, LocalDateTime datePosted, int likes, Users user, ForumQuestion forumQuestion);

    Optional<Reply> edit(Integer id, ReplyDto replyDto);

    void deleteById(Integer id);

    List<ReplyDto> getAllRepliesForQuestion(Integer questionId);
}
