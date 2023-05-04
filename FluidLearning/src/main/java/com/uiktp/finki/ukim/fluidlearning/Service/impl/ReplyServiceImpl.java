package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ForumQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Reply;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.ReplyNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ReplyDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.ReplyRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ReplyService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;

    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public Optional<Reply> findById(Integer id) {
        return this.replyRepository.findById(id);
    }

    @Override
    public List<Reply> findAll() {
        return this.replyRepository.findAll();
    }

    @Override
    public Optional<Reply> save(String content, LocalDateTime datePosted, int likes, Users user, ForumQuestion forumQuestion) {
        Reply reply = new Reply();
        reply.setContent(content);
        reply.setDatePosted(datePosted);
        reply.setLikes(likes);
        reply.setUser(user);
        reply.setForumQuestion(forumQuestion);
        return Optional.of(this.replyRepository.save(reply));
    }

    @Override
    public Optional<Reply> save(ReplyDto replyDto) {
        Reply reply = new Reply();
        reply.setContent(replyDto.getContent());
        reply.setDatePosted(replyDto.getDatePosted());
        reply.setLikes(replyDto.getLikes());
        reply.setUser(replyDto.getUser());
        reply.setForumQuestion(replyDto.getForumQuestion());
        return Optional.of(this.replyRepository.save(reply));
    }

    @Override
    public Optional<Reply> edit(Integer id, String content, LocalDateTime datePosted, int likes, Users user, ForumQuestion forumQuestion) {
        Reply reply = this.replyRepository.findById(id).orElseThrow(() -> new ReplyNotFoundException(id));
        reply.setContent(content);
        reply.setDatePosted(datePosted);
        reply.setLikes(likes);
        reply.setUser(user);
        reply.setForumQuestion(forumQuestion);
        return Optional.of(this.replyRepository.save(reply));
    }

    @Override
    public Optional<Reply> edit(Integer id, ReplyDto replyDto) {
        Reply reply = this.replyRepository.findById(id).orElseThrow(() -> new ReplyNotFoundException(id));
        reply.setContent(replyDto.getContent());
        reply.setDatePosted(replyDto.getDatePosted());
        reply.setLikes(replyDto.getLikes());
        reply.setUser(replyDto.getUser());
        reply.setForumQuestion(replyDto.getForumQuestion());
        return Optional.of(this.replyRepository.save(reply));
    }

    @Override
    public void deleteById(Integer id) {
        this.replyRepository.deleteById(id);
    }

    @Override
    public List<ReplyDto> getAllRepliesForQuestion(Integer questionId) {
        return this.replyRepository.getReplyByForumQuestionId(questionId);
    }
}
