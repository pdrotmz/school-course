package io.github.pdrotmz.school_course.service.course;

import io.github.pdrotmz.school_course.model.Course;
import io.github.pdrotmz.school_course.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public Course registerCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    @Override
    public Optional<Course> findCourseById(String id) {
        if(repository.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Curso não encontrado");
        }
        return repository.findById(id);
    }

    @Override
    public Optional<Course> findCourseByName(String name) {
        if(repository.findCourseByName(name).isEmpty()) {
            throw new EntityNotFoundException("Curso não encontrado");
        }
        return repository.findCourseByName(name);
    }

    @Override
    public Optional<Course> updateCourseByName(Course course, String id) {
        return repository.findCourseByName(id).map(existingCourse -> {
            existingCourse.setName(course.getName());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setPrice(course.getPrice());
            return repository.save(course);
        }).map(Optional::of)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
    }

    @Override
    public Optional<Course> updateCourseById(Course course, String name) {
        return repository.findCourseByName(name).map(existingCourse -> {
            existingCourse.setName(course.getName());
            existingCourse.setDescription(course.getDescription());
            existingCourse.setPrice(course.getPrice());
            return repository.save(course);
        }).map(Optional::of)
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
    }

    @Override
    public void deleteCourseById(String id) {
        repository.deleteCourseById(id);
    }

    @Override
    public void deleteCourseByName(String name) {
        repository.deleteCourseByName(name);
    }
}
