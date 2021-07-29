package com.ajcoding.springrest.services;

import com.ajcoding.springrest.dao.CourseDao;
import com.ajcoding.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
      @Autowired
      private CourseDao courseDao;
//    List<Course>courseList;

    public CourseServiceImpl() {
//        courseList = new ArrayList<>();
//        courseList.add(new Course(100, "Java Course", "This course contains basics of Java Programming"));
//        courseList.add(new Course(101, "Spring Boot", "This course contains basics of Spring Boot"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
//        for(Course c : courseList){
//            if(c.getId()==courseId){
//                return c;
//            }
//        }
        return courseDao.getById(courseId);
    }

    @Override
    public void addNewCourse(Course c) {
//      courseList.add(c);
        courseDao.save(c);
    }

    @Override
    public void updateCourse(long courseId, Course c) {
//      for(int i=0; i<courseList.size(); i++){
//          Course course = courseList.get(i);
//          if(course.getId()==courseId){
//              courseList.set(i,c);
//              return;
//          }
//      }
        courseDao.save(c);
    }

    @Override
    public void deleteCourse(long courseId) {
//      for(int i=0; i<courseList.size(); i++){
//          Course course = courseList.get(i);
//          if(course.getId()==courseId){
//              courseList.remove(i);
//              return;
//          }
//      }
        courseDao.delete(courseDao.getById(courseId));
    }
}
