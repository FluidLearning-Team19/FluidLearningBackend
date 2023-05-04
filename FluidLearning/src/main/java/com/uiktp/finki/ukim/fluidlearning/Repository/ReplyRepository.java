package com.uiktp.finki.ukim.fluidlearning.Repository;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Reply;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ReplyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Query("SELECT new com.uiktp.finki.ukim.fluidlearning.Models.dto.ReplyDto(r.content, r.datePosted, r.likes, r.user, r.forumQuestion) FROM Reply r WHERE r.forumQuestion.id = :questionId")
    List<ReplyDto> getReplyByForumQuestionId(Integer questionId);

}
