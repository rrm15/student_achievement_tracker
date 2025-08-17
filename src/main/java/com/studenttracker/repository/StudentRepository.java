package com.studenttracker.repository;

import com.studenttracker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    Optional<Student> findByEmail(String email);
    
    boolean existsByEmail(String email);
    
    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %:searchTerm% OR s.lastName LIKE %:searchTerm% OR s.email LIKE %:searchTerm%")
    List<Student> searchStudents(@Param("searchTerm") String searchTerm);
    
    @Query("SELECT s FROM Student s WHERE s.city = :city")
    List<Student> findByCity(@Param("city") String city);
    
    @Query("SELECT s FROM Student s WHERE s.state = :state")
    List<Student> findByState(@Param("state") String state);
    
    @Query("SELECT s FROM Student s WHERE s.country = :country")
    List<Student> findByCountry(@Param("country") String country);
}
