package com.studenttracker.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.io.font.constants.StandardFonts;
import com.studenttracker.entity.Student;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ResumeService {
    
    public byte[] generateResume(Student student, String template, String format) {
        try {
            if ("PDF".equalsIgnoreCase(format)) {
                return generatePDFResume(student, template);
            } else {
                throw new UnsupportedOperationException("Format " + format + " not supported");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error generating resume: " + e.getMessage(), e);
        }
    }
    
    private byte[] generatePDFResume(Student student, String template) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(baos);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        // Set margins
        document.setMargins(50, 50, 50, 50);
        
        // Create fonts
        PdfFont titleFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        PdfFont headingFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        PdfFont bodyFont = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        
        // Header Section
        Paragraph header = new Paragraph(student.getFullName())
            .setFont(titleFont)
            .setFontSize(24)
            .setTextAlignment(TextAlignment.CENTER)
            .setMarginBottom(10);
        document.add(header);
        
        // Contact Information
        Paragraph contactInfo = new Paragraph()
            .setFont(bodyFont)
            .setFontSize(10)
            .setTextAlignment(TextAlignment.CENTER)
            .setMarginBottom(20);
        
        contactInfo.add(student.getEmail() + " | " + student.getPhoneNumber() + "\n");
        contactInfo.add(student.getAddress() + ", " + student.getCity() + ", " + student.getState() + " " + student.getPinCode() + ", " + student.getCountry());
        document.add(contactInfo);
        
        // Education Section
        if (student.getEducationHistory() != null && !student.getEducationHistory().isEmpty()) {
            addSectionHeader(document, "EDUCATION", headingFont);
            
            for (var education : student.getEducationHistory()) {
                Paragraph eduPara = new Paragraph()
                    .setFont(headingFont)
                    .setFontSize(12)
                    .setMarginBottom(5);
                
                eduPara.add(education.getDegreeName() + " in " + education.getFieldOfStudy() + "\n");
                
                Paragraph eduDetails = new Paragraph()
                    .setFont(bodyFont)
                    .setFontSize(10)
                    .setMarginBottom(10);
                
                eduDetails.add(education.getInstitutionName() + " | " + education.getBoardUniversity() + "\n");
                eduDetails.add(education.getDuration() + " | CGPA: " + education.getCgpaPercentage() + "/" + education.getGradeScale());
                
                if (education.getAchievements() != null && !education.getAchievements().isEmpty()) {
                    eduDetails.add(" | " + education.getAchievements());
                }
                
                document.add(eduPara);
                document.add(eduDetails);
            }
        }
        
        // Skills Section
        if (student.getSkills() != null && !student.getSkills().isEmpty()) {
            addSectionHeader(document, "SKILLS", headingFont);
            
            // Group skills by category
            var skillsByCategory = student.getSkills().stream()
                .collect(java.util.stream.Collectors.groupingBy(skill -> skill.getCategory()));
            
            for (var entry : skillsByCategory.entrySet()) {
                Paragraph categoryPara = new Paragraph()
                    .setFont(headingFont)
                    .setFontSize(11)
                    .setMarginBottom(5);
                categoryPara.add(entry.getKey() + ": ");
                
                Paragraph skillsPara = new Paragraph()
                    .setFont(bodyFont)
                    .setFontSize(10)
                    .setMarginBottom(10);
                
                String skillsList = entry.getValue().stream()
                    .map(skill -> skill.getName() + " (" + skill.getProficiencyText() + ")")
                    .collect(java.util.stream.Collectors.joining(", "));
                
                skillsPara.add(skillsList);
                document.add(categoryPara);
                document.add(skillsPara);
            }
        }
        
        // Projects Section
        if (student.getProjects() != null && !student.getProjects().isEmpty()) {
            addSectionHeader(document, "PROJECTS", headingFont);
            
            for (var project : student.getProjects()) {
                Paragraph projTitle = new Paragraph()
                    .setFont(headingFont)
                    .setFontSize(12)
                    .setMarginBottom(5);
                projTitle.add(project.getTitle());
                
                Paragraph projDetails = new Paragraph()
                    .setFont(bodyFont)
                    .setFontSize(10)
                    .setMarginBottom(10);
                
                projDetails.add(project.getDescription() + "\n");
                if (project.getTechnologies() != null) {
                    projDetails.add("Technologies: " + project.getTechnologies() + "\n");
                }
                if (project.getGithubUrl() != null) {
                    projDetails.add("GitHub: " + project.getGithubUrl() + "\n");
                }
                if (project.getLiveUrl() != null) {
                    projDetails.add("Live Demo: " + project.getLiveUrl());
                }
                
                document.add(projTitle);
                document.add(projDetails);
            }
        }
        
        // Experience Section
        if (student.getExperiences() != null && !student.getExperiences().isEmpty()) {
            addSectionHeader(document, "EXPERIENCE", headingFont);
            
            for (var experience : student.getExperiences()) {
                Paragraph expTitle = new Paragraph()
                    .setFont(headingFont)
                    .setFontSize(12)
                    .setMarginBottom(5);
                expTitle.add(experience.getJobTitle() + " at " + experience.getCompanyName());
                
                Paragraph expDetails = new Paragraph()
                    .setFont(bodyFont)
                    .setFontSize(10)
                    .setMarginBottom(10);
                
                expDetails.add(experience.getDuration() + " | " + experience.getExperienceType() + "\n");
                expDetails.add(experience.getJobDescription() + "\n");
                
                if (experience.getTechnologies() != null) {
                    expDetails.add("Technologies: " + experience.getTechnologies() + "\n");
                }
                if (experience.getAchievements() != null) {
                    expDetails.add("Key Achievements: " + experience.getAchievements());
                }
                
                document.add(expTitle);
                document.add(expDetails);
            }
        }
        
        // Achievements Section
        if (student.getAchievements() != null && !student.getAchievements().isEmpty()) {
            addSectionHeader(document, "ACHIEVEMENTS & AWARDS", headingFont);
            
            for (var achievement : student.getAchievements()) {
                Paragraph achPara = new Paragraph()
                    .setFont(bodyFont)
                    .setFontSize(10)
                    .setMarginBottom(5);
                
                achPara.add("• " + achievement.getTitle() + " - " + achievement.getDescription());
                if (achievement.getOrganization() != null) {
                    achPara.add(" (" + achievement.getOrganization() + ")");
                }
                if (achievement.getLevel() != null) {
                    achPara.add(" - " + achievement.getLevel() + " Level");
                }
                
                document.add(achPara);
            }
        }
        
        document.close();
        return baos.toByteArray();
    }
    
    private void addSectionHeader(Document document, String title, PdfFont font) {
        Paragraph sectionHeader = new Paragraph(title)
            .setFont(font)
            .setFontSize(14)
            .setMarginTop(20)
            .setMarginBottom(10)
            .setTextAlignment(TextAlignment.LEFT);
        
        // Add underline
        Line line = new Line(0, 0, 500, 0);
        line.setStrokeColor(ColorConstants.BLACK);
        
        document.add(sectionHeader);
        document.add(line);
    }
}
