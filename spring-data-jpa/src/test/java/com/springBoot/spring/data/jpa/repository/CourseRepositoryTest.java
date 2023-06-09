package com.springBoot.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.springBoot.spring.data.jpa.entity.Course;
import com.springBoot.spring.data.jpa.entity.Teacher;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseRepositoryTest {

  @Autowired
  CourseRepository courseRepository;

  @Test
  public void findAll(){
   List<Course> response= courseRepository.findAll();
    System.out.println("response = " + response);

  }

  @Test
  public void saveCourseWithTeacher(){
    Teacher teacher = Teacher.builder()
        .firstName("Muhammad")
        .LastName("Ali Khan")
        .build();

    Course course = Course.builder()
        .credit(5)
        .title("Python")
        .teacher(teacher)
        .build();

    Course response =courseRepository.save(course);
    System.out.println("response = " + response);
  }
}