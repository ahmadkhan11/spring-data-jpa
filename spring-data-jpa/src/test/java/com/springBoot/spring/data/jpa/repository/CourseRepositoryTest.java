package com.springBoot.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.springBoot.spring.data.jpa.entity.Course;
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
}