package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamQuestion;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamQuestionDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamQuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/examQuestion")
@CrossOrigin(value = "*")
public class ExamQuestionController {
    private final ExamQuestionService examQuestionService;

    public ExamQuestionController(ExamQuestionService examQuestionService) {
        this.examQuestionService = examQuestionService;
    }

    @GetMapping
    public List<ExamQuestion> findAll() {
        return this.examQuestionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamQuestion> findById(@PathVariable Integer id) {
        return this.examQuestionService.findById(id)
                .map(examQuestion -> ResponseEntity.ok().body(examQuestion))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<ExamQuestion> save(@RequestBody ExamQuestionDto examQuestionDto) {
        return this.examQuestionService.save(examQuestionDto)
                .map(examQuestion -> ResponseEntity.ok().body(examQuestion))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ExamQuestion> edit(@PathVariable Integer id, @RequestBody ExamQuestionDto examQuestionDto) {
        return this.examQuestionService.edit(id, examQuestionDto)
                .map(examQuestion -> ResponseEntity.ok().body(examQuestion))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.examQuestionService.deleteById(id);
        if(this.examQuestionService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
