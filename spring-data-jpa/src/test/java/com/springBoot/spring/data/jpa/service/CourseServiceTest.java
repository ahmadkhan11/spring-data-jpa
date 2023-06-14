package com.springBoot.spring.data.jpa.service;

import static org.junit.jupiter.api.Assertions.*;

import com.springBoot.spring.data.jpa.repository.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

  @MockBean
  CourseRepository courseRepository;

  @BeforeEach
  public void setup(){

  }
  @Test
  void saveCourse() {


  }

  @Test
  void findAll() {
  }
}