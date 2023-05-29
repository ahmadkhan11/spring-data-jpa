package com.springBoot.spring.data.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

  @Id
  @SequenceGenerator(
      name = "course_sequence",
      sequenceName = "course_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "course_sequence"
  )
  private Long courseId;
  private String title;
  private Integer credit;
  @OneToOne(
      cascade = CascadeType.ALL
  )
  @JoinColumn(
      name = "course_Id",
      referencedColumnName = "courseId"
  )
  private CourseMaterial courseMaterial;


}
