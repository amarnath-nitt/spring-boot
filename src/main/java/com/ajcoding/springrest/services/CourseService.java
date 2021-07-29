package com.ajcoding.springrest.services;

import com.ajcoding.springrest.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourse(long courseId);

    void addNewCourse(Course c);

    void updateCourse(long courseId, Course c);

    void deleteCourse(long courseId);
}
