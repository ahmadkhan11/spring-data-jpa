package com.springBoot.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.springBoot.spring.data.jpa.entity.Course;
import com.springBoot.spring.data.jpa.entity.Guardian;
import com.springBoot.spring.data.jpa.entity.Student;
import com.springBoot.spring.data.jpa.entity.Teacher;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

  @Test
  public void findAllPagination(){
    Pageable firstPagewithThreeRecords =
        PageRequest.of(0, 3);
    Pageable secondPageWithTwoRecords =
        PageRequest.of(1,2);

    List<Course> courses =
        courseRepository.findAll(secondPageWithTwoRecords)
            .getContent();

    Long totalElements = courseRepository.findAll(firstPagewithThreeRecords).getTotalElements();

    Long totalPages = Long.valueOf(courseRepository.findAll(firstPagewithThreeRecords)
        .getTotalPages());
    System.out.println("totalPages = " + totalPages);
    System.out.println("totalElements = " + totalElements);

    System.out.println("courseList = " + courses);

  }

  @Test
  public void findAllWithSorting(){

    Pageable sortByTitle =
        PageRequest.of(0,2,Sort.by("title"));

    Pageable sortByCreditDesc =
        PageRequest.of(0,2,Sort.by("credit").descending());

    Pageable sortByTitleAndCreditDesc =
        PageRequest.of(0,2,
            Sort.by("credit").descending()
                .and(Sort.by("credit")).descending()

        );

    List<Course> courses =
        courseRepository.findAll(sortByTitle).getContent();
    System.out.println("courses = " + courses);

    List<Course> coursesCredit =
        courseRepository.findAll(sortByCreditDesc).getContent();

    System.out.println("coursesCredit = " + coursesCredit);

    List<Course> coursesByTitleAndCredit =
        courseRepository.findAll(sortByTitleAndCreditDesc).getContent();

    System.out.println("coursesByTitleAndCredit = " + coursesByTitleAndCredit);

    System.out.println("sortByTitle = " + sortByTitle);
    System.out.println("sortByCreditDesc = " + sortByCreditDesc);
  }

  @Test
  public void findByTitleContaining(){

    PageRequest firstPageTenRecords =
        PageRequest.of(0,10);

    List<Course> courses =
        courseRepository.findByTitleContaining("P",firstPageTenRecords).getContent();

    System.out.println("courses = " + courses);

  }

  @Test
  public void saveCourseWithTeacherAndStudent(){

    Teacher teacher = Teacher.builder()
        .firstName("Ali")
        .LastName("Khan")
        .build();
    Guardian guardian =  Guardian.builder()
        .name("Ali")
        .email("AlikhanJadoon@gmail.com")
        .mobile("090078601").build();
    Student student = Student. builder().
        emailId("ahmadKhanjadoon@gmail.com ").
        firstName ("Muhammad Ahamd").
        lastName ("Khan").
        guardian(guardian).build();
    List<Student> studentList = new ArrayList<>();
    studentList.add(student);

    Course course = Course.builder()
        .credit(6)
        .title("Software")
        .teacher(teacher)
        .students(studentList)
       // .students((studentList
        .build();

    Course courseRepo =courseRepository.save(course);

    System.out.println("courseRepo = " + courseRepo);



  }
}