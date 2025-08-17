package com.studenttracker.service;

import com.studenttracker.dto.StudentRegistrationDto;
import com.studenttracker.entity.*;
import com.studenttracker.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private ResumeService resumeService;
    
    public Student registerStudent(StudentRegistrationDto registrationDto) {
        // Check if email already exists
        if (studentRepository.existsByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("Email already registered");
        }
        
        // create new student
        Student student = new Student();
        student.setFirstName(registrationDto.getFirstName());
        student.setLastName(registrationDto.getLastName());
        student.setEmail(registrationDto.getEmail());
        student.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        student.setPhoneNumber(registrationDto.getPhoneNumber());
        student.setDateOfBirth(registrationDto.getDateOfBirth());
        student.setAddress(registrationDto.getAddress());
        student.setCity(registrationDto.getCity());
        student.setState(registrationDto.getState());
        student.setCountry(registrationDto.getCountry());
        student.setPinCode(registrationDto.getPinCode());
        student.setResumeTemplate(registrationDto.getResumeTemplate());
        student.setPreferredFormat(registrationDto.getPreferredFormat());
        
        // save student first to get ID
        final Student finalStudent = studentRepository.save(student);
        
        // add education history
        if (registrationDto.getEducationHistory() != null) {
            List<Education> educationList = registrationDto.getEducationHistory().stream()
                .map(eduDto -> {
                    Education education = new Education();
                    education.setStudent(finalStudent);
                    education.setInstitutionName(eduDto.getInstitutionName());
                    education.setDegreeName(eduDto.getDegreeName());
                    education.setFieldOfStudy(eduDto.getFieldOfStudy());
                    education.setBoardUniversity(eduDto.getBoardUniversity());
                    education.setStartDate(eduDto.getStartDate());
                    education.setEndDate(eduDto.getEndDate());
                    education.setCgpaPercentage(eduDto.getCgpaPercentage());
                    education.setGradeScale(eduDto.getGradeScale());
                    education.setAchievements(eduDto.getAchievements());
                    education.setActivities(eduDto.getActivities());
                    education.setDescription(eduDto.getDescription());
                    return education;
                })
                .collect(Collectors.toList());
            finalStudent.setEducationHistory(educationList);
        }
        
        // add achievements
        if (registrationDto.getAchievements() != null) {
            List<Achievement> achievementList = registrationDto.getAchievements().stream()
                .map(achDto -> {
                    Achievement achievement = new Achievement();
                    achievement.setStudent(finalStudent);
                    achievement.setTitle(achDto.getTitle());
                    achievement.setDescription(achDto.getDescription());
                    achievement.setCategory(achDto.getCategory());
                    achievement.setOrganization(achDto.getOrganization());
                    achievement.setLevel(achDto.getLevel());
                    achievement.setDateReceived(achDto.getDateReceived());
                    achievement.setCertificateUrl(achDto.getCertificateUrl());
                    achievement.setPrize(achDto.getPrize());
                    achievement.setRank(achDto.getRank());
                    return achievement;
                })
                .collect(Collectors.toList());
            finalStudent.setAchievements(achievementList);
        }
        
        // add skills
        if (registrationDto.getSkills() != null) {
            List<Skill> skillList = registrationDto.getSkills().stream()
                .map(skillDto -> {
                    Skill skill = new Skill();
                    skill.setStudent(finalStudent);
                    skill.setName(skillDto.getName());
                    skill.setCategory(skillDto.getCategory());
                    skill.setProficiencyLevel(skillDto.getProficiencyLevel());
                    skill.setDescription(skillDto.getDescription());
                    skill.setCertifications(skillDto.getCertifications());
                    skill.setYearsOfExperience(skillDto.getYearsOfExperience());
                    return skill;
                })
                .collect(Collectors.toList());
            finalStudent.setSkills(skillList);
        }
        
        // add projects
        if (registrationDto.getProjects() != null) {
            List<Project> projectList = registrationDto.getProjects().stream()
                .map(projDto -> {
                    Project project = new Project();
                    project.setStudent(finalStudent);
                    project.setTitle(projDto.getTitle());
                    project.setDescription(projDto.getDescription());
                    project.setCategory(projDto.getCategory());
                    project.setStartDate(projDto.getStartDate());
                    project.setEndDate(projDto.getEndDate());
                    project.setTechnologies(projDto.getTechnologies());
                    project.setGithubUrl(projDto.getGithubUrl());
                    project.setLiveUrl(projDto.getLiveUrl());
                    project.setDocumentationUrl(projDto.getDocumentationUrl());
                    project.setTeamSize(projDto.getTeamSize());
                    project.setRole(projDto.getRole());
                    project.setChallenges(projDto.getChallenges());
                    project.setOutcomes(projDto.getOutcomes());
                    project.setImages(projDto.getImages());
                    return project;
                })
                .collect(Collectors.toList());
            finalStudent.setProjects(projectList);
        }
        
        // add experiences
        if (registrationDto.getExperiences() != null) {
            List<Experience> experienceList = registrationDto.getExperiences().stream()
                .map(expDto -> {
                    Experience experience = new Experience();
                    experience.setStudent(finalStudent);
                    experience.setCompanyName(expDto.getCompanyName());
                    experience.setJobTitle(expDto.getJobTitle());
                    experience.setJobDescription(expDto.getJobDescription());
                    experience.setExperienceType(expDto.getExperienceType());
                    experience.setStartDate(expDto.getStartDate());
                    experience.setEndDate(expDto.getEndDate());
                    experience.setLocation(expDto.getLocation());
                    experience.setTechnologies(expDto.getTechnologies());
                    experience.setAchievements(expDto.getAchievements());
                    experience.setResponsibilities(expDto.getResponsibilities());
                    experience.setSupervisorName(expDto.getSupervisorName());
                    experience.setSupervisorContact(expDto.getSupervisorContact());
                    experience.setSalary(expDto.getSalary());
                    experience.setReasonForLeaving(expDto.getReasonForLeaving());
                    return experience;
                })
                .collect(Collectors.toList());
            finalStudent.setExperiences(experienceList);
        }
        
        // save everything
        return studentRepository.save(finalStudent);
    }
    
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public List<Student> searchStudents(String searchTerm) {
        return studentRepository.searchStudents(searchTerm);
    }
    
    public Student updateStudent(Long id, StudentRegistrationDto updateDto) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        
        Student student = existingStudent.get();
        
        // Update basic information
        student.setFirstName(updateDto.getFirstName());
        student.setLastName(updateDto.getLastName());
        student.setPhoneNumber(updateDto.getPhoneNumber());
        student.setDateOfBirth(updateDto.getDateOfBirth());
        student.setAddress(updateDto.getAddress());
        student.setCity(updateDto.getCity());
        student.setState(updateDto.getState());
        student.setCountry(updateDto.getCountry());
        student.setPinCode(updateDto.getPinCode());
        student.setResumeTemplate(updateDto.getResumeTemplate());
        student.setPreferredFormat(updateDto.getPreferredFormat());
        
        // Update relationships (similar to registration logic)
        // ... (implement similar logic for updating relationships)
        
        return studentRepository.save(student);
    }
    
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
    public byte[] generateResume(Long studentId, String template, String format) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new RuntimeException("Student not found");
        }
        
        return resumeService.generateResume(student.get(), template, format);
    }
}
