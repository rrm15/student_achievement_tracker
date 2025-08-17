package com.studenttracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "education")
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @NotBlank(message = "Institution name is required")
    private String institutionName;
    
    @NotBlank(message = "Degree/Course name is required")
    private String degreeName;
    
    @NotBlank(message = "Field of study is required")
    private String fieldOfStudy;
    
    @NotBlank(message = "Board/University is required")
    private String boardUniversity;
    
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    @NotNull(message = "CGPA/Percentage is required")
    @DecimalMin(value = "0.0", message = "CGPA/Percentage must be positive")
    @DecimalMax(value = "10.0", message = "CGPA cannot exceed 10.0")
    private Double cgpaPercentage;
    
    @NotBlank(message = "Grade scale is required")
    private String gradeScale; // e.g., "4.0", "10.0", "Percentage"
    
    private String achievements;
    private String activities;
    private String description;
    
    // Constructor
    public Education() {}
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public String getInstitutionName() {
        return institutionName;
    }
    
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    
    public String getDegreeName() {
        return degreeName;
    }
    
    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }
    
    public String getFieldOfStudy() {
        return fieldOfStudy;
    }
    
    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }
    
    public String getBoardUniversity() {
        return boardUniversity;
    }
    
    public void setBoardUniversity(String boardUniversity) {
        this.boardUniversity = boardUniversity;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public Double getCgpaPercentage() {
        return cgpaPercentage;
    }
    
    public void setCgpaPercentage(Double cgpaPercentage) {
        this.cgpaPercentage = cgpaPercentage;
    }
    
    public String getGradeScale() {
        return gradeScale;
    }
    
    public void setGradeScale(String gradeScale) {
        this.gradeScale = gradeScale;
    }
    
    public String getAchievements() {
        return achievements;
    }
    
    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
    
    public String getActivities() {
        return activities;
    }
    
    public void setActivities(String activities) {
        this.activities = activities;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isCurrentlyStudying() {
        return endDate == null;
    }
    
    public String getDuration() {
        if (startDate == null) return "";
        if (endDate == null) return startDate.getYear() + " - Present";
        return startDate.getYear() + " - " + endDate.getYear();
    }
}
