package com.studenttracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "experiences")
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @NotBlank(message = "Company/Organization name is required")
    private String companyName;
    
    @NotBlank(message = "Job title is required")
    private String jobTitle;
    
    @NotBlank(message = "Job description is required")
    @Column(length = 1000)
    private String jobDescription;
    
    @NotBlank(message = "Experience type is required")
    private String experienceType; // like Internship, Part-time, Full-time
    
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private String location;
    private String technologies;
    private String achievements;
    private String responsibilities;
    private String supervisorName;
    private String supervisorContact;
    private String salary;
    private String reasonForLeaving;
    
    public Experience() {}
    
    // getters and setters
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
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public String getJobDescription() {
        return jobDescription;
    }
    
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    
    public String getExperienceType() {
        return experienceType;
    }
    
    public void setExperienceType(String experienceType) {
        this.experienceType = experienceType;
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
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getTechnologies() {
        return technologies;
    }
    
    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
    
    public String getAchievements() {
        return achievements;
    }
    
    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }
    
    public String getResponsibilities() {
        return responsibilities;
    }
    
    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }
    
    public String getSupervisorName() {
        return supervisorName;
    }
    
    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }
    
    public String getSupervisorContact() {
        return supervisorContact;
    }
    
    public void setSupervisorContact(String supervisorContact) {
        this.supervisorContact = supervisorContact;
    }
    
    public String getSalary() {
        return salary;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    public String getReasonForLeaving() {
        return reasonForLeaving;
    }
    
    public void setReasonForLeaving(String reasonForLeaving) {
        this.reasonForLeaving = reasonForLeaving;
    }
    
    public boolean isCurrentlyWorking() {
        return endDate == null;
    }
    
    public String getDuration() {
        if (startDate == null) return "";
        if (endDate == null) return startDate.getYear() + " - Present";
        return startDate.getYear() + " - " + endDate.getYear();
    }
}
