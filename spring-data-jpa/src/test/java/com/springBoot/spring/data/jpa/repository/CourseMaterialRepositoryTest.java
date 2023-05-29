package com.springBoot.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.springBoot.spring.data.jpa.entity.Course;
import com.springBoot.spring.data.jpa.entity.CourseMaterial;
import java.util.ArrayList;
import java.util.List;
import lombok.ToString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

  @Autowired
  CourseMaterialRepository courseMaterialRepository;

  @DisplayName("Save Course Material")
  @Test
  public void saveCourseMaterial(){

    Course course = Course.builder()
        .credit(6)
        .title("Software")
        .build();

    CourseMaterial courseMaterial = CourseMaterial.builder()
        .url("url.com")
        .course(course)
        .build();

    courseMaterialRepository.save(courseMaterial);

  }
  
  @DisplayName("View All course Material")
  @Test
  public void getAllCourseMaterial(){
    List<CourseMaterial> courseMaterialList = new ArrayList<>();
    courseMaterialList = courseMaterialRepository.findAll();
    System.out.println("courseMaterialList = " + courseMaterialList);
  }


}