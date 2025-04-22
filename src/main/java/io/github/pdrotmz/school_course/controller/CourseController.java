package io.github.pdrotmz.school_course.controller;

import io.github.pdrotmz.school_course.model.Course;
import io.github.pdrotmz.school_course.service.course.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    @Autowired
    private CourseServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<Course> registerCourse(@RequestBody Course course) {
        Course registeredCourse = service.registerCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredCourse);
    }
}
