package com.uiktp.finki.ukim.fluidlearning.Repository;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.FavouriteCourse;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteCourseRepository extends JpaRepository<FavouriteCourse, Integer> {

    @Query("SELECT new com.uiktp.finki.ukim.fluidlearning.Models.dto.CourseDto(a.course.code, a.course.title, a.course.description, a.course.numberOfLectures, a.course.category.name) FROM FavouriteCourse a WHERE a.user.id = :userId")
    List<CourseDto> findAllFavouriteCoursesForUser(Integer userId);
}
