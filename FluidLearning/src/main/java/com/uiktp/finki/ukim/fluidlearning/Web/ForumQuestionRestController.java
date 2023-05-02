package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Forum;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ForumQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ForumDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ForumQuestionDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ForumQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forumquestion")
@CrossOrigin(value = "*")
public class ForumQuestionRestController {
    private final ForumQuestionService forumQuestionService;

    public ForumQuestionRestController(ForumQuestionService forumQuestionService) {
        this.forumQuestionService = forumQuestionService;
    }

    @GetMapping
    public List<ForumQuestion> findAll() {
        return this.forumQuestionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumQuestion> findById(@PathVariable Integer id) {
        return this.forumQuestionService.findById(id)
                .map(forumQuestion -> ResponseEntity.ok().body(forumQuestion))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<ForumQuestion> save(@RequestBody ForumQuestionDto forumQuestionDto) {
        return this.forumQuestionService.save(forumQuestionDto)
                .map(forumQuestion -> ResponseEntity.ok().body(forumQuestion))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ForumQuestion> edit(@PathVariable Integer id, @RequestBody ForumQuestionDto forumQuestionDto) {
        return this.forumQuestionService.edit(id, forumQuestionDto)
                .map(forumQuestion -> ResponseEntity.ok().body(forumQuestion))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.forumQuestionService.deleteById(id);
        if(this.forumQuestionService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}