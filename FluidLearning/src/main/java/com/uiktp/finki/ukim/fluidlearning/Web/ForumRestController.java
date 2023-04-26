package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Forum;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ForumDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ForumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/forum")
@CrossOrigin(value = "*")
public class ForumRestController {
    private final ForumService forumService;

    public ForumRestController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping
    public List<Forum> findAll() {
        return this.forumService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Forum> findById(@PathVariable Integer id) {
        return this.forumService.findById(id).map(forum -> ResponseEntity.ok().body(forum)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Forum> save(@RequestBody ForumDto forumDto) {
        return this.forumService.save(forumDto).map(forum -> ResponseEntity.ok().body(forum)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Forum> edit(@PathVariable Integer id, @RequestBody ForumDto forumDto) {
        return this.forumService.edit(id, forumDto).map(forum -> ResponseEntity.ok().body(forum)).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.forumService.deleteById(id);
        if (this.forumService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
