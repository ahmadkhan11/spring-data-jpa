package com.springBoot.spring.data.jpa.repository;


import com.springBoot.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository  extends JpaRepository<Student,Long> {

  public List<Student> findByFirstName(String firstName);
  public List<Student> findByFirstNameContaining(String firstName);

  public List<Student> findByLastNameNotNull();
  public List<Student> findByGuardianName(String guardianName);

//  @Query("SELECT * FROM Student WHERE emailId LIKE '%ahmadKhanjadoon11@gmail.com%';")
//  Student getStudentByEmailId(String emailId);
//  @Query(value = "SELECT * FROM tbl_student WHERE email_address = :emailId", nativeQuery = true)
//  Student getStudentByEmailId(@Param("emailId") String emailId);
  @Query(value = "SELECT * FROM tbl_student WHERE TRIM(email_address) = TRIM(:emailId)", nativeQuery = true)
  Student getStudentByEmailId(@Param("emailId") String emailId);

  @Query(value = "SELECT * FROM tbl_student WHERE TRIM(guardian_email) = TRIM(:guardian_email)", nativeQuery = true)
  Student getStudentByGuardianEmailId(@Param("guardian_email") String guardian_email);

//  @Modifying
//  @Transactional
//  @Query(value = "UPDATE tbl_student set firstName= :firstName WHERE TRIM(emailId) = TRIM(:emailId)", nativeQuery = true)
//  int updateStudentByEmailId(@Param("emailId") String emailId,@Param("firstName") String firstName);

  @Modifying
  @Transactional
  @Query(value = "UPDATE tbl_student SET first_name = :firstName WHERE TRIM(email_address) = TRIM(:emailId)", nativeQuery = true)
  void updateStudentByEmailId(@Param("emailId") String emailId, @Param("firstName") String firstName);






}
