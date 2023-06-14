package com.springBoot.spring.data.jpa.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.springBoot.spring.data.jpa.entity.Course;
import com.springBoot.spring.data.jpa.entity.Guardian;
import com.springBoot.spring.data.jpa.entity.Student;
import com.springBoot.spring.data.jpa.entity.Teacher;
import com.springBoot.spring.data.jpa.service.CourseService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@WebMvcTest(CourseController.class)
class CourseControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  CourseService courseService;

  String getAllResponse ;

  List<Course> courseList = new ArrayList<>();

  @MockBean
  Course course;

  @BeforeEach
  public void setup(){

    getAllResponse = "[{\"courseId\":1,\"title\":\"Software\",\"credit\":6,\"teacher\":null,\"students\":[]},{\"courseId\":2,\"title\":\"newCourse\",\"credit\":6,\"teacher\":{\"teacherId\":1,\"firstName\":\"Ali\",\"lastName\":\"Khan\"},\"students\":[]},{\"courseId\":8,\"title\":\"newCourse\",\"credit\":6,\"teacher\":{\"teacherId\":5,\"firstName\":\"Ali\",\"lastName\":\"Khan\"},\"students\":[]},{\"courseId\":9,\"title\":\"Java\",\"credit\":6,\"teacher\":{\"teacherId\":5,\"firstName\":\"Ali\",\"lastName\":\"Khan\"},\"students\":[]},{\"courseId\":10,\"title\":\"Python\",\"credit\":5,\"teacher\":{\"teacherId\":6,\"firstName\":\"Ali\",\"lastName\":\"Khan\"},\"students\":[]},{\"courseId\":11,\"title\":\"Python\",\"credit\":5,\"teacher\":{\"teacherId\":7,\"firstName\":\"Muhammad\",\"lastName\":\"AliKhan\"},\"students\":[]},{\"courseId\":15,\"title\":\"Software\",\"credit\":6,\"teacher\":{\"teacherId\":11,\"firstName\":\"Ali\",\"lastName\":\"Khan\"},\"students\":[{\"studentId\":14,\"firstName\":\"MuhammadAhamd\",\"lastName\":\"Khan\",\"emailId\":\"ahmadKhanjadoon@gmail.com\",\"guardian\":{\"name\":\"Ali\",\"email\":\"AlikhanJadoon@gmail.com\",\"mobile\":\"090078601\"}}]},{\"courseId\":16,\"title\":\"Python\",\"credit\":5,\"teacher\":{\"teacherId\":12,\"firstName\":\"Muhammad\",\"lastName\":\"AliKhan\"},\"students\":[]},{\"courseId\":17,\"title\":\"Python\",\"credit\":5,\"teacher\":{\"teacherId\":13,\"firstName\":\"Muhammad\",\"lastName\":\"AliKhan\"},\"students\":[]}]";

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

     course = Course.builder()
        .credit(6)
        .title("Software")
        .teacher(teacher)
        .students(studentList)
        // .students((studentList
        .build();

    courseList.add(course);

  }

  @Test
  public void getAllCourses() throws Exception {

    when(courseService.findAll()).thenReturn(courseList);
    mvc.perform(MockMvcRequestBuilders.get("/allCourses")
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")).andExpect(status().isOk());

  }

  @Test
  public void coursesNotFound() throws Exception {

    when(courseService.findAll()).thenReturn(courseList);
    mvc.perform(MockMvcRequestBuilders.get("/allCourse")
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .characterEncoding("UTF-8")).andExpect(status().isNotFound());

  }


}