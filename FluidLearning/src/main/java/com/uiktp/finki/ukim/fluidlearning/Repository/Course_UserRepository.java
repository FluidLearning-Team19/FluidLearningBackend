package com.uiktp.finki.ukim.fluidlearning.Repository;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course;
import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Course_User;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Course_UserRepository extends JpaRepository<Course_User, Integer> {

    @Query("SELECT new com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto(a.course.code, a.course.title, a.course.description, a.course.numberOfLectures,a.course.category.name, a.course.category.description) FROM Course_User a WHERE a.user.id = :userId")
    List<CourseDto> findAllCoursesForUser(Integer userId);
}
