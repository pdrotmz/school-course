package io.github.pdrotmz.school_course.repository;

import io.github.pdrotmz.school_course.model.Course;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, String> {

    @Query("SELECT c FROM course c WHERE c.name = :name")
    Optional<Course> findCourseByName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM course c WHERE c.id = :id")
    void deleteCourseById(@Param("id") String id);

    @Modifying
    @Query("DELETE FROM course c WHERE c.name = :name")
    void deleteCourseByName(@Param("name") String name);
}
