package com.uiktp.finki.ukim.fluidlearning.Repository;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.FavouriteCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteCourseRepository extends JpaRepository<FavouriteCourse, Integer> {
}
