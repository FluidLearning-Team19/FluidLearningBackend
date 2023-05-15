package com.uiktp.finki.ukim.fluidlearning.Web;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.FavouriteCourse;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.Exam_UserDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.FavouriteCourseDto;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.UsersDto;
import com.uiktp.finki.ukim.fluidlearning.Service.Course_UserService;
import com.uiktp.finki.ukim.fluidlearning.Service.Exam_UserService;
import com.uiktp.finki.ukim.fluidlearning.Service.FavouriteCourseService;
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

    private final FavouriteCourseService favouriteCourseService;

    private final Exam_UserService exam_userService;

    public UsersRestController(ModelMapper modelMapper, UsersService usersService, Course_UserService course_userService, FavouriteCourseService favouriteCourseService, Exam_UserService exam_userService) {
        this.modelMapper = modelMapper;
        this.usersService = usersService;
        this.course_userService = course_userService;
        this.favouriteCourseService = favouriteCourseService;
        this.exam_userService = exam_userService;
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

    @GetMapping("/{id}/favouriteCourses")
    public ResponseEntity<List<CourseDto>> getFavouriteCoursesByUserId(@PathVariable Integer id) {
        List<CourseDto> favouriteCoursesForUser =  this.favouriteCourseService.findAllFavouriteCoursesForUser(id);

        return ResponseEntity.ok().body(favouriteCoursesForUser);
    }

    @PostMapping("/exam/{examId}")
    public ResponseEntity createExam_User(@PathVariable int examId, @RequestBody Exam_UserDto exam_userDto) {
        exam_userService.create(examId, exam_userDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/addFavouriteCourse")
    public ResponseEntity<FavouriteCourse> addFavouriteCourseForUser(@RequestBody FavouriteCourseDto favouriteCourseDto) {
        FavouriteCourse favouriteCourse = favouriteCourseService.save(favouriteCourseDto);
        return ResponseEntity.ok().body(favouriteCourse);
    }
}
