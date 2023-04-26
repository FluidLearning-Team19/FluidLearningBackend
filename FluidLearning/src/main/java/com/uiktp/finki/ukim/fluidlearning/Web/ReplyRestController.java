package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Reply;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ReplyDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ReplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reply")
@CrossOrigin(value = "*")
public class ReplyRestController {
    private final ReplyService replyService;

    public ReplyRestController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @GetMapping
    public List<Reply> findAll() {
        return this.replyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reply> findById(@PathVariable Integer id) {
        return this.replyService.findById(id)
                .map(reply -> ResponseEntity.ok().body(reply))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Reply> save(@RequestBody ReplyDto replyDto) {
        return this.replyService.save(replyDto)
                .map(reply -> ResponseEntity.ok().body(reply))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Reply> edit(@PathVariable Integer id, @RequestBody ReplyDto replyDto) {
        return this.replyService.edit(id, replyDto)
                .map(reply -> ResponseEntity.ok().body(reply))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.replyService.deleteById(id);
        if (this.replyService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
