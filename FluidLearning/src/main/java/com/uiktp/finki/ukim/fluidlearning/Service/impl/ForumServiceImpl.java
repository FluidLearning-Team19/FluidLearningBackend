package com.uiktp.finki.ukim.fluidlearning.Service.impl;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Forum;
import com.uiktp.finki.ukim.fluidlearning.Models.Exceptions.ForumNotFoundException;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ForumDto;
import com.uiktp.finki.ukim.fluidlearning.Repository.ForumRepository;
import com.uiktp.finki.ukim.fluidlearning.Service.ForumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;

    public ForumServiceImpl(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    @Override
    public Optional<Forum> findById(Integer id) {
        return this.forumRepository.findById(id);
    }

    @Override
    public List<Forum> findAll() {

        return this.forumRepository.findAll();
    }

    @Override
    public Optional<Forum> save(String title, String description) {
        Forum forum = new Forum();
        forum.setTitle(title);
        forum.setDescription(description);
        return Optional.of(this.forumRepository.save(forum));
    }

    @Override
    public Optional<Forum> save(ForumDto forumDto) {
        //TODO: How to check if it exists, by name?
        Forum forum = new Forum();
        forum.setTitle(forumDto.getTitle());
        forum.setDescription(forumDto.getDescription());
        return Optional.of(this.forumRepository.save(forum));
    }

    @Override
    public Optional<Forum> edit(Integer id, String title, String description) {
        Forum forum = this.forumRepository.findById(id).orElseThrow(() -> new ForumNotFoundException(id));
        forum.setTitle(title);
        forum.setDescription(description);
        return Optional.of(this.forumRepository.save(forum));
    }

    @Override
    public Optional<Forum> edit(Integer id, ForumDto forumDto) {
        Forum forum = this.forumRepository.findById(id).orElseThrow(() -> new ForumNotFoundException(id));
        forum.setTitle(forumDto.getTitle());
        forum.setDescription(forumDto.getDescription());
        return Optional.of(this.forumRepository.save(forum));
    }

    @Override
    public void deleteById(Integer id) {
        this.forumRepository.deleteById(id);
    }
}
