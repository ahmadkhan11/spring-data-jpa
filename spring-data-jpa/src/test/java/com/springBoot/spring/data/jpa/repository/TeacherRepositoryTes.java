package com.springBoot.spring.data.jpa.repository;

import com.springBoot.spring.data.jpa.entity.Course;
import com.springBoot.spring.data.jpa.entity.CourseMaterial;
import com.springBoot.spring.data.jpa.entity.Teacher;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherRepositoryTes {

  @Autowired
  TeacherRepository teacherRepository;

  @Test
  public void saveTeacher(){
    List<Course> courseList = new ArrayList<>();

    CourseMaterial courseMaterial = CourseMaterial.builder()
        .url("url")
        .build();
    Course course = Course.builder()
        .title("new Course")
        .credit(6)
        .courseMaterial(courseMaterial)
        .build();
    Course Java = Course.builder()
        .title("Java")
        .credit(6)
        .build();
    courseList.add(course);
    courseList.add(Java);

    Teacher teacher = Teacher.builder()
        .firstName("Ali")
        .LastName("Khan")
        .courseList(courseList)
        .build();
    Teacher teacher1 = teacherRepository.save(teacher);
    System.out.println("teacher1 = " + teacher1);
  }

}
