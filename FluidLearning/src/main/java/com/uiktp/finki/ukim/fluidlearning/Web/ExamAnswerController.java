package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.ExamAnswer;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamAnswerDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamAnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/examAnswer")
@CrossOrigin(value = "*")
public class ExamAnswerController {

    private final ExamAnswerService examAnswerService;

    public ExamAnswerController(ExamAnswerService examAnswerService) {
        this.examAnswerService = examAnswerService;
    }

    @GetMapping
    public List<ExamAnswer> findAll() {
        return this.examAnswerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamAnswer> findById(@PathVariable Integer id) {
        return this.examAnswerService.findById(id)
                .map(examAnswer -> ResponseEntity.ok().body(examAnswer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/add")
    public ResponseEntity<ExamAnswer> save(@RequestBody ExamAnswerDto ExamAnswerDto) {
        return this.examAnswerService.save(ExamAnswerDto)
                .map(examAnswer -> ResponseEntity.ok().body(examAnswer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        this.examAnswerService.deleteById(id);
        if(this.examAnswerService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/examQuestion/{id}")
    public List<ExamAnswer> retrieveAllAnswersByQuestion(@PathVariable Integer id){
        return this.examAnswerService.findAllByExamQuestionId(id);
    }
}
