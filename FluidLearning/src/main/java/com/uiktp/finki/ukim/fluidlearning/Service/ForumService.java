package com.uiktp.finki.ukim.fluidlearning.Service;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Forum;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ForumDto;

import java.util.List;
import java.util.Optional;


public interface ForumService {
    Optional<Forum> findById(Integer id);

    List<Forum> findAll();

    Optional<Forum> save(String title, String description);

    Optional<Forum> save(ForumDto forumDto);

    Optional<Forum> edit(Integer id, String title, String description);

    Optional<Forum> edit(Integer id, ForumDto forumDto);

    void deleteById(Integer id);

}
