package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Progress;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.ProgressDto;
import com.uiktp.finki.ukim.fluidlearning.Service.ProgressService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(value = "*")
public class ProgressRestController {

    private final ModelMapper modelMapper;

    private final ProgressService progressService;

    public ProgressRestController(ModelMapper modelMapper, ProgressService progressService) {
        this.modelMapper = modelMapper;
        this.progressService = progressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgressDto> getProgressById(@PathVariable Integer id) {
        Progress progress = this.progressService.findProgressById(id);

        ProgressDto progressDto = modelMapper.map(progress, ProgressDto.class);

        return ResponseEntity.ok().body(progressDto);
    }

    @GetMapping
    public ResponseEntity<ProgressDto> getProgressByCourseUserId(@RequestParam Integer courseId, @RequestParam Integer userId ) {
        Progress progress = this.progressService.findProgressByCourseUserId(courseId, userId);

        ProgressDto progressDto = modelMapper.map(progress, ProgressDto.class);

        return ResponseEntity.ok().body(progressDto);
    }

    @PostMapping
    public ResponseEntity<ProgressDto> createProgress(@RequestBody ProgressDto progressDto) {

        Progress progressToAdd = modelMapper.map(progressDto, Progress.class);

        Progress progress = progressService.createProgress(progressToAdd);

        ProgressDto progressResponse = modelMapper.map(progress, ProgressDto.class);

        return new ResponseEntity<>(progressResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgressDto> updateProgress(@PathVariable int id, @RequestBody ProgressDto progressDto) {

        Progress progressToUpdate = modelMapper.map(progressDto, Progress.class);

        Progress progress = progressService.updateProgress(id, progressToUpdate);

        ProgressDto progressResponse = modelMapper.map(progress, ProgressDto.class);

        return ResponseEntity.ok().body(progressResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProgress(@PathVariable int id) {
        this.progressService.deleteProgress(id);
        return new ResponseEntity<>("Progress Deleted", HttpStatus.OK);
    }
}
