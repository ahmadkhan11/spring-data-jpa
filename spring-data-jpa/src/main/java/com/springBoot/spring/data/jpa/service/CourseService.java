package com.springBoot.spring.data.jpa.service;

import com.springBoot.spring.data.jpa.entity.Course;
import com.springBoot.spring.data.jpa.repository.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

  @Autowired
  CourseRepository courseRepository;

  public Course saveCourse( Course course){

    Course response =courseRepository.save(course);

    return response;

  }

  public List<Course>  findAll(){
    List<Course> response= courseRepository.findAll();
    //System.out.println("response = " + response);
    System.out.println("response = " + response);

    return response;
  }



}
