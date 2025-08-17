package com.studenttracker.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class ExperienceDto {
    
    @NotBlank(message = "Company/Organization name is required")
    private String companyName;
    
    @NotBlank(message = "Job title is required")
    private String jobTitle;
    
    @NotBlank(message = "Job description is required")
    private String jobDescription;
    
    @NotBlank(message = "Experience type is required")
    private String experienceType;
    
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
    
    // Constructor
    public ExperienceDto() {}
    
    // Getters and Setters
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
}
