package com.uiktp.finki.ukim.fluidlearning.Web;


import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.UsersDto;
import com.uiktp.finki.ukim.fluidlearning.Service.Course_UserService;
import com.uiktp.finki.ukim.fluidlearning.Service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(value = "*")
public class UsersRestController {

    private final ModelMapper modelMapper;

    private final UsersService usersService;

    private final Course_UserService course_userService;

    public UsersRestController(ModelMapper modelMapper, UsersService usersService, Course_UserService course_userService) {
        this.modelMapper = modelMapper;
        this.usersService = usersService;
        this.course_userService = course_userService;
    }

    @GetMapping
    public List<Users> findAll() {
        return this.usersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable Integer id) {
        Users user = this.usersService.findUserById(id);

        UsersDto userDto = modelMapper.map(user, UsersDto.class);

        return ResponseEntity.ok().body(userDto);
    }

    // Can return null, username has to be exact match
    @GetMapping("/username/{username}")
    public ResponseEntity<UsersDto> getUserByUsername(@PathVariable String username) {
        Users user = this.usersService.findByUsername(username);

        UsersDto userDto = modelMapper.map(user, UsersDto.class);

        return ResponseEntity.ok().body(userDto);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseDto>> getCoursesByUserId(@PathVariable Integer id) {
        List<Course> courseForUser =  this.course_userService.findAllCoursesForUser(id);

        List<CourseDto> courseDtos = courseForUser.stream()
                .map(s -> modelMapper.map(s, CourseDto.class))
                .toList();

        return ResponseEntity.ok().body(courseDtos);
    }

    @PostMapping
    public ResponseEntity<UsersDto> createUser(@RequestBody UsersDto userDto) {

        Users userToAdd = modelMapper.map(userDto, Users.class);

        Users user = usersService.createUser(userToAdd);

        UsersDto userResponse = modelMapper.map(user, UsersDto.class);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDto> updateUser(@PathVariable int id, @RequestBody UsersDto userDto) {

        Users userToUpdate = modelMapper.map(userDto, Users.class);

        Users user = usersService.updateUser(id, userToUpdate);

        UsersDto userResponse = modelMapper.map(user, UsersDto.class);

        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        this.usersService.deleteUser(id);
        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }
}
