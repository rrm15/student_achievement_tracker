package com.studenttracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Column(unique = true)
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
    
    // student's education, skills, projects, etc
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Education> educationHistory;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Achievement> achievements;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Skill> skills;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Project> projects;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Experience> experiences;
    
    // for resume generation
    private String resumeTemplate = "modern";
    private String preferredFormat = "PDF";
    
    // when student was created/updated
    private LocalDate createdAt;
    private LocalDate updatedAt;
    
    public Student() {
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }
    
    // getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
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
    
    public List<Education> getEducationHistory() {
        return educationHistory;
    }
    
    public void setEducationHistory(List<Education> educationHistory) {
        this.educationHistory = educationHistory;
    }
    
    public List<Achievement> getAchievements() {
        return achievements;
    }
    
    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }
    
    public List<Skill> getSkills() {
        return skills;
    }
    
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    
    public List<Project> getProjects() {
        return projects;
    }
    
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
    public List<Experience> getExperiences() {
        return experiences;
    }
    
    public void setExperiences(List<Experience> experiences) {
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
    
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDate.now();
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
