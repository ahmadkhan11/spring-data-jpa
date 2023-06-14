package com.springBoot.spring.data.jpa.controller;

import com.springBoot.spring.data.jpa.entity.Course;
import com.springBoot.spring.data.jpa.service.CourseService;
import java.util.List;
import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import static org.mockito.Mockito.when;

@RestController
public class CourseController {


  @Autowired
  CourseService courseService;

  @PostMapping("/addCourse")
  public ResponseEntity<Course> saveProduct(@RequestBody Course course) throws Exception {
//    if(course == null){
//      throw new RuntimeErrorException(new Error(),"Empty");
//    }
    System.out.println("product = " + course);
    return ResponseEntity.ok(courseService.saveCourse(course));
  }

  @GetMapping("/allCourses")
  public ResponseEntity<List<Course>> getAllCourses() {

    //Mockito.when(courseService.findAll())
    List<Course> response = courseService.findAll();
    System.out.println("response = " + response);
    return ResponseEntity.ok(response);
  }





}
