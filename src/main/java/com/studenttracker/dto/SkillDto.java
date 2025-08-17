package com.studenttracker.dto;

import jakarta.validation.constraints.*;

public class SkillDto {
    
    @NotBlank(message = "Skill name is required")
    private String name;
    
    @NotBlank(message = "Skill category is required")
    private String category;
    
    @NotNull(message = "Proficiency level is required")
    @Min(value = 1, message = "Proficiency level must be between 1 and 5")
    @Max(value = 5, message = "Proficiency level must be between 1 and 5")
    private Integer proficiencyLevel;
    
    private String description;
    private String certifications;
    private Integer yearsOfExperience;
    
    // Constructor
    public SkillDto() {}
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public Integer getProficiencyLevel() {
        return proficiencyLevel;
    }
    
    public void setProficiencyLevel(Integer proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCertifications() {
        return certifications;
    }
    
    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }
    
    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
