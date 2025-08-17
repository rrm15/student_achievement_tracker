# Student Achievement Tracker

A comprehensive full-stack application built with Java Spring Boot for tracking student achievements and generating professional, ATS-friendly resumes.

## Features

### 🎓 Comprehensive Student Profile
- **Personal Information**: Name, contact details, address, date of birth
- **Educational Background**: Multiple education entries with CGPA/percentage, board/university details
- **Skills & Competencies**: Technical skills, soft skills, languages with proficiency levels
- **Projects & Work**: Academic, personal, and professional projects with technologies used
- **Achievements & Awards**: Academic, sports, arts, leadership, and technical achievements
- **Work Experience**: Internships, part-time jobs, and professional experience

### 📄 Resume Generation
- **Multiple Templates**: Modern, Classic, Creative, and Minimal designs
- **ATS-Friendly**: Optimized for Applicant Tracking Systems
- **Multiple Formats**: PDF, DOCX, and HTML output
- **Professional Layout**: Clean, structured format suitable for job applications

### 🎨 Student-Friendly UI
- **Multi-step Registration**: Guided form completion process
- **Responsive Design**: Works on all devices and screen sizes
- **Interactive Elements**: Dynamic form fields, progress tracking
- **Modern Design**: Beautiful gradients and intuitive navigation

## Technology Stack

### Backend
- **Java 17** - Modern Java features and performance
- **Spring Boot 3.2.0** - Rapid application development
- **Spring Data JPA** - Database operations and relationships
- **Spring Security** - Authentication and authorization
- **H2 Database** - In-memory database for development
- **PostgreSQL** - Production-ready database support
- **iText 7** - Professional PDF generation

### Frontend
- **Bootstrap 5** - Responsive CSS framework
- **Font Awesome** - Beautiful icons
- **Vanilla JavaScript** - Modern ES6+ features
- **Thymeleaf** - Server-side templating

## Prerequisites

- **Java 17** or higher
- **Maven 3.6** or higher
- **Git** for version control

## Installation & Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd student_achievement_tracker
```

### 2. Build the Project
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Access the Application
- **Registration Page**: `http://localhost:8080/register`
- **Dashboard**: `http://localhost:8080/dashboard`
- **API Endpoints**: `http://localhost:8080/api/students/*`
- **H2 Console**: `http://localhost:8080/h2-console` (for development)

## API Endpoints

### Student Management
- `POST /api/students/register` - Register a new student
- `GET /api/students/{id}` - Get student by ID
- `GET /api/students/email/{email}` - Get student by email
- `GET /api/students` - Get all students
- `GET /api/students/search?q={query}` - Search students
- `PUT /api/students/{id}` - Update student
- `DELETE /api/students/{id}` - Delete student

### Resume Generation
- `GET /api/students/{id}/resume?template={template}&format={format}` - Generate resume

## Database Schema

### Core Entities
- **Student**: Main student profile with personal information
- **Education**: Educational history and qualifications
- **Skill**: Skills and competencies with proficiency levels
- **Project**: Academic and professional projects
- **Experience**: Work experience and internships
- **Achievement**: Awards, certificates, and recognitions

### Relationships
- One-to-Many relationships between Student and other entities
- Cascading operations for data integrity
- Lazy loading for performance optimization

## Usage Guide

### 1. Student Registration
1. Navigate to the registration page
2. Complete the 4-step registration process:
   - **Step 1**: Personal Information
   - **Step 2**: Educational Background
   - **Step 3**: Skills & Projects
   - **Step 4**: Achievements & Resume Settings
3. Submit the form to create your profile

### 2. Profile Management
- View your complete profile on the dashboard
- Track your achievements, skills, and projects
- Monitor your educational progress

### 3. Resume Generation
- Choose from multiple resume templates
- Select your preferred output format
- Generate and download your professional resume

## Configuration

### Application Properties
The application can be configured through `src/main/resources/application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:h2:mem:studentdb
spring.datasource.username=sa
spring.datasource.password=password

# JWT Configuration
jwt.secret=your-secret-key-here
jwt.expiration=86400000

# File Upload
spring.servlet.multipart.max-file-size=10MB
```

### Database Configuration
- **Development**: H2 in-memory database (default)
- **Production**: PostgreSQL (update properties file)

## Development

### Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/studenttracker/
│   │       ├── config/          # Configuration classes
│   │       ├── controller/      # REST and web controllers
│   │       ├── dto/            # Data Transfer Objects
│   │       ├── entity/         # JPA entities
│   │       ├── repository/     # Data access layer
│   │       └── service/        # Business logic
│   └── resources/
│       ├── templates/          # Thymeleaf templates
│       └── application.properties
└── test/                       # Test files
```

### Adding New Features
1. Create entity classes in the `entity` package
2. Add corresponding DTOs in the `dto` package
3. Implement repository interfaces
4. Create service classes for business logic
5. Add REST endpoints in controllers
6. Update frontend templates as needed

## Testing

### Run Tests
```bash
mvn test
```

### Test Coverage
The project includes comprehensive test coverage for:
- Entity validation
- Service layer business logic
- Controller endpoints
- Repository operations

## Deployment

### Production Build
```bash
mvn clean package -Pprod
```

### Docker Deployment
```bash
docker build -t student-tracker .
docker run -p 8080:8080 student-tracker
```

### Environment Variables
Set the following environment variables for production:
- `SPRING_PROFILES_ACTIVE=prod`
- `DATABASE_URL`
- `JWT_SECRET`
- `SERVER_PORT`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation

## Roadmap

### Future Enhancements
- **Authentication System**: User login and session management
- **Admin Dashboard**: Manage students and system settings
- **Analytics**: Achievement tracking and progress reports
- **Mobile App**: Native mobile application
- **Integration**: Connect with educational institutions
- **AI Features**: Smart resume suggestions and optimization

---

**Built with ❤️ for students and their career success!**
