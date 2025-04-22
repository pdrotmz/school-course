package io.github.pdrotmz.school_course.service.course;

import io.github.pdrotmz.school_course.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course registerCourse(Course course);
    List<Course> findAllCourses();
    Optional<Course> findCourseById(String id);
    Optional<Course> findCourseByName(String name);
    Optional<Course> updateCourseByName(Course course, String id);
    Optional<Course> updateCourseById(Course course, String name);
    void deleteCourseById(String id);
    void deleteCourseByName(String name);
}
