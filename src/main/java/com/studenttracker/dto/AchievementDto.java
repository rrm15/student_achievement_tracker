package com.studenttracker.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AchievementDto {
    
    @NotBlank(message = "Achievement title is required")
    private String title;
    
    @NotBlank(message = "Achievement description is required")
    private String description;
    
    @NotBlank(message = "Category is required")
    private String category;
    
    private String organization;
    private String level;
    private LocalDate dateReceived;
    private String certificateUrl;
    private String prize;
    private String rank;
    
    // Constructor
    public AchievementDto() {}
    
    // Getters and Setters
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
    
    public String getOrganization() {
        return organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    
    public String getLevel() {
        return level;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }
    
    public LocalDate getDateReceived() {
        return dateReceived;
    }
    
    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }
    
    public String getCertificateUrl() {
        return certificateUrl;
    }
    
    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl;
    }
    
    public String getPrize() {
        return prize;
    }
    
    public void setPrize(String prize) {
        this.prize = prize;
    }
    
    public String getRank() {
        return rank;
    }
    
    public void setRank(String rank) {
        this.rank = rank;
    }
}
