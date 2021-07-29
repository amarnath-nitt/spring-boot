package com.ajcoding.springrest.resources;

import com.ajcoding.springrest.entities.Course;
import com.ajcoding.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseResource {

    @Autowired
    CourseService courseService;
    @GetMapping("/home")
    public String home(){
        return "Welcome to the course";
    }
    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return courseService.getCourse(Long.parseLong(courseId));
    }
    @PostMapping("/courses")
    public void addNewCourse(@RequestBody Course c){
        courseService.addNewCourse(c);
    }
    @PutMapping("/courses/{courseId}")
    public void updateCourse(@PathVariable String courseId, @RequestBody Course c){
        courseService.updateCourse(Long.parseLong(courseId), c);
    }
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
