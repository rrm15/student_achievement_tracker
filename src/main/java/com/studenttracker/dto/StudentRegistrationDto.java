package com.studenttracker.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

public class StudentRegistrationDto {
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Please provide a valid phone number")
    private String phoneNumber;
    
    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;
    
    @NotBlank(message = "Address is required")
    private String address;
    
    @NotBlank(message = "City is required")
    private String city;
    
    @NotBlank(message = "State is required")
    private String state;
    
    @NotBlank(message = "Country is required")
    private String country;
    
    @NotBlank(message = "PIN code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "PIN code must be 6 digits")
    private String pinCode;
    
    // Educational Details
    private List<EducationDto> educationHistory;
    private List<AchievementDto> achievements;
    private List<SkillDto> skills;
    private List<ProjectDto> projects;
    private List<ExperienceDto> experiences;
    
    // Resume preferences
    private String resumeTemplate = "modern";
    private String preferredFormat = "PDF";
    
    // Constructor
    public StudentRegistrationDto() {}
    
    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getPinCode() {
        return pinCode;
    }
    
    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
    
    public List<EducationDto> getEducationHistory() {
        return educationHistory;
    }
    
    public void setEducationHistory(List<EducationDto> educationHistory) {
        this.educationHistory = educationHistory;
    }
    
    public List<AchievementDto> getAchievements() {
        return achievements;
    }
    
    public void setAchievements(List<AchievementDto> achievements) {
        this.achievements = achievements;
    }
    
    public List<SkillDto> getSkills() {
        return skills;
    }
    
    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }
    
    public List<ProjectDto> getProjects() {
        return projects;
    }
    
    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }
    
    public List<ExperienceDto> getExperiences() {
        return experiences;
    }
    
    public void setExperiences(List<ExperienceDto> experiences) {
        this.experiences = experiences;
    }
    
    public String getResumeTemplate() {
        return resumeTemplate;
    }
    
    public void setResumeTemplate(String resumeTemplate) {
        this.resumeTemplate = resumeTemplate;
    }
    
    public String getPreferredFormat() {
        return preferredFormat;
    }
    
    public void setPreferredFormat(String preferredFormat) {
        this.preferredFormat = preferredFormat;
    }
}
