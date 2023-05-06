package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Exam;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ExamDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ExamService;
import com.uiktp.finki.ukim.fluidlearning.Service.Exam_UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exam")
@CrossOrigin(value = "*")
@AllArgsConstructor
public class ExamRestController {

    private final ExamService examService;
    private final Exam_UserService exam_userService;

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Integer id) {
        return ResponseEntity.ok(examService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<ExamDto> createExam(@RequestBody ExamDto examDto) {
        examService.create(examDto);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ExamDto> updateExam(@PathVariable Integer id, @RequestBody ExamDto examDto) {
        examService.update(id, examDto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        examService.delete(id);

        return ResponseEntity.ok().build();
    }
}
