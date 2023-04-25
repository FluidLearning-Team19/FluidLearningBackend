package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Lecture;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.LectureDto;
import com.uiktp.finki.ukim.fluidlearning.Service.LectureService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lecture")
@CrossOrigin(value = "*")
public class LectureRestController {

    private final ModelMapper modelMapper;

    private final LectureService lectureService;

    public LectureRestController(LectureService lectureService, ModelMapper modelMapper) {
        this.lectureService = lectureService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectureDto> getLectureById(@PathVariable Integer id) {
        Lecture lecture = this.lectureService.getLectureById(id);

        LectureDto lectureDto = modelMapper.map(lecture, LectureDto.class);

        return ResponseEntity.ok().body(lectureDto);
    }

    @PostMapping
    public ResponseEntity<LectureDto> createPost(@RequestBody LectureDto lectureDto) {

        Lecture lectureToAdd = modelMapper.map(lectureDto, Lecture.class);

        Lecture lecture = lectureService.createLecture(lectureToAdd);

        LectureDto lectureResponse = modelMapper.map(lecture, LectureDto.class);

        return new ResponseEntity<>(lectureResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LectureDto> updatePost(@PathVariable int id, @RequestBody LectureDto lectureDto) {

        Lecture lectureToUpdate = modelMapper.map(lectureDto, Lecture.class);

        Lecture lecture = lectureService.updateLecture(id, lectureToUpdate);

        LectureDto lectureResponse = modelMapper.map(lecture, LectureDto.class);

        return ResponseEntity.ok().body(lectureResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        lectureService.deleteLecture(id);
        return new ResponseEntity<>("Lecture Deleted", HttpStatus.OK);
    }
}
