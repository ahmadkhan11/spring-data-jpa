package com.springBoot.spring.data.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import com.springBoot.spring.data.jpa.entity.Guardian;
import com.springBoot.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@Transactional
class StudentRepositoryTest {

 @Autowired
  private StudentRepository studentRepository;


  @BeforeEach
  public void setup() {
  }
  @DisplayName("Save Student")
  @Test
  public void saveStudent(){
    Student student = Student. builder().
        emailId("ahmadKhanjadoon11@gmail.com ").
        firstName ("ahmad").
        lastName ("Khan").
        build();
    studentRepository.save(student);
    Student savedStudent = studentRepository.save(student);

    assertNotNull(savedStudent.getStudentId());
    assertEquals(student.getEmailId(), savedStudent.getEmailId());
    assertEquals(student.getFirstName(), savedStudent.getFirstName());
    assertEquals(student.getLastName(), savedStudent.getLastName());
  }

  @DisplayName("Save Student with Guardian")
  @Test
  public void saveStudentWithGuardian(){
    Guardian guardian =  Guardian.builder()
        .name("Ali")
        .email("Ali@gmail.com")
        .mobile("090078601").build();
    Student student = Student. builder().
        emailId("ahmadKhan@gmail.com ").
        firstName ("Muhammad Ahamd").
        lastName ("Khan").
        guardian(guardian).build();

    studentRepository.save(student);

  }

  @DisplayName("View All Student")
  @Test
  public void viewAllStudent(){
    List<Student>  studentList = new ArrayList<>();
    studentList= studentRepository.findAll();
    System.out.println("studentList = " + studentList);
    
  }

  @DisplayName("Get Student by First Name")
  @Test
  public void getByName(){
    List<Student> studentList = new ArrayList<>();
    studentList = studentRepository.findByFirstName("ahmad");
    System.out.println("studentList = " + studentList);
  }


  @DisplayName("Get Student by contain Keyword")
  @Test
  public void getByNameContains(){
    List<Student> studentList = new ArrayList<>();
    studentList = studentRepository.findByFirstNameContaining("ah");
    System.out.println("studentList = " + studentList);
  }


  @DisplayName("Get Student by Last Name Not Null")
  @Test
  public void getByNotNull(){
    List<Student> studentList = new ArrayList<>();
    studentList = studentRepository.findByLastNameNotNull();
    System.out.println("studentList = " + studentList);
  }

  @DisplayName("Get Student by Guardian Name")
  @Test
  public void getByGuardianName(){
    List<Student> studentList = new ArrayList<>();
    studentList = studentRepository.findByGuardianName("ali");
    System.out.println("studentList = " + studentList);
  }

  @DisplayName("Get Student by Email Address")
  @Test
  public void getByEmailAddress(){

    Student student = studentRepository.getStudentByEmailId("ahmadKhanjadoon11@gmail.com");
    System.out.println("student = " + student);
  }

  @DisplayName("Get Student by Guardian Email Address")
  @Test
  public void getByGuardianEmailAddress(){

    Student student = studentRepository.getStudentByGuardianEmailId("Ali@gmail.com");
    System.out.println("student = " + student);
  }

  @DisplayName("Update name Student by Email Address")
  @Test
  public void updateFirstname(){

    studentRepository.updateStudentByEmailId("ahmadKhanjadoon11@gmail.com","Muhammad Ahmed Khan");
    //System.out.println("student = " + student);
  }

}