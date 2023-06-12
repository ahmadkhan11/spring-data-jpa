package com.springBoot.spring.data.jpa.repository;

import com.springBoot.spring.data.jpa.entity.Course;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

  Page<Course> findByTitleContaining(String title, PageRequest pageRequest);
}
