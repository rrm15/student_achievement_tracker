package com.studenttracker.controller;

import com.studenttracker.dto.StudentRegistrationDto;
import com.studenttracker.entity.Student;
import com.studenttracker.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @PostMapping("/register")
    public ResponseEntity<?> registerStudent(@Valid @RequestBody StudentRegistrationDto registrationDto) {
        try {
            Student student = studentService.registerStudent(registrationDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                    "message", "Student registered successfully",
                    "studentId", student.getId(),
                    "email", student.getEmail()
                ));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", e.getMessage()));
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getStudentByEmail(@PathVariable String email) {
        Optional<Student> student = studentService.getStudentByEmail(email);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam String q) {
        List<Student> students = studentService.searchStudents(q);
        return ResponseEntity.ok(students);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRegistrationDto updateDto) {
        try {
            Student updatedStudent = studentService.updateStudent(id, updateDto);
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", e.getMessage()));
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok(Map.of("message", "Student deleted successfully"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", e.getMessage()));
        }
    }
    
    @GetMapping("/{id}/resume")
    public ResponseEntity<byte[]> generateResume(
            @PathVariable Long id,
            @RequestParam(defaultValue = "modern") String template,
            @RequestParam(defaultValue = "PDF") String format) {
        
        try {
            byte[] resumeBytes = studentService.generateResume(id, template, format);
            
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "resume_" + id + ".pdf");
            headers.setContentLength(resumeBytes.length);
            
            return ResponseEntity.ok()
                .headers(headers)
                .body(resumeBytes);
                
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(("Error generating resume: " + e.getMessage()).getBytes());
        }
    }
    
    // helper method to create Map
    private java.util.Map<String, Object> Map(String key, Object value) {
        java.util.Map<String, Object> map = new java.util.HashMap<>();
        map.put(key, value);
        return map;
    }
    
    private java.util.Map<String, Object> Map(String key1, Object value1, String key2, Object value2) {
        java.util.Map<String, Object> map = new java.util.HashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        return map;
    }
}
