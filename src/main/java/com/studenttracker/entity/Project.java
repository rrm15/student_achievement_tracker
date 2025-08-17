package com.studenttracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
    
    @NotBlank(message = "Project title is required")
    private String title;
    
    @NotBlank(message = "Project description is required")
    @Column(length = 1000)
    private String description;
    
    @NotBlank(message = "Project category is required")
    private String category; // like Academic, Personal, Professional
    
    private LocalDate startDate;
    private LocalDate endDate;
    private String technologies;
    private String githubUrl;
    private String liveUrl;
    private String documentationUrl;
    private String teamSize;
    private String role;
    private String challenges;
    private String outcomes;
    private String images;
    
    public Project() {}
    
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
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
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
    
    public String getTechnologies() {
        return technologies;
    }
    
    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }
    
    public String getGithubUrl() {
        return githubUrl;
    }
    
    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }
    
    public String getLiveUrl() {
        return liveUrl;
    }
    
    public void setLiveUrl(String liveUrl) {
        this.liveUrl = liveUrl;
    }
    
    public String getDocumentationUrl() {
        return documentationUrl;
    }
    
    public void setDocumentationUrl(String documentationUrl) {
        this.documentationUrl = documentationUrl;
    }
    
    public String getTeamSize() {
        return teamSize;
    }
    
    public void setTeamSize(String teamSize) {
        this.teamSize = teamSize;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getChallenges() {
        return challenges;
    }
    
    public void setChallenges(String challenges) {
        this.challenges = challenges;
    }
    
    public String getOutcomes() {
        return outcomes;
    }
    
    public void setOutcomes(String outcomes) {
        this.outcomes = outcomes;
    }
    
    public String getImages() {
        return images;
    }
    
    public void setImages(String images) {
        this.images = images;
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
