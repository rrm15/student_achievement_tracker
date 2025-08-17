# Quick Start Guide

## 🚀 Get Started in 5 Minutes

### Option 1: Automatic Setup (Recommended)
1. **Double-click** `setup.bat` (Windows) or run `setup.ps1` (PowerShell)
2. The script will automatically:
   - Check Java installation
   - Install Maven if needed
   - Build the project
   - Start the application

### Option 2: Manual Setup
1. **Install Maven** (if not already installed):
   - Download from: https://maven.apache.org/download.cgi
   - Extract to a folder (e.g., `C:\maven`)
   - Add `C:\maven\bin` to your PATH environment variable

2. **Build and Run**:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## 🌐 Access the Application

Once running, open your browser and navigate to:

- **🏠 Home/Registration**: http://localhost:8080/register
- **📊 Dashboard**: http://localhost:8080/dashboard
- **🔧 H2 Database Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:studentdb`
  - Username: `sa`
  - Password: `password`

## 📝 First Steps

1. **Register a Student**:
   - Go to http://localhost:8080/register
   - Fill out the 4-step registration form
   - Include your educational details, skills, projects, and achievements

2. **View Your Profile**:
   - After registration, note your Student ID
   - Go to http://localhost:8080/dashboard
   - Enter your Student ID when prompted

3. **Generate Resume**:
   - Choose your preferred template and format
   - Click "Generate Resume" to download your ATS-friendly resume

## 🛠️ Troubleshooting

### Common Issues:

**"Maven not found"**
- Run the setup script to auto-install Maven
- Or manually install Maven and add to PATH

**"Port 8080 already in use"**
- Change port in `application.properties`: `server.port=8081`
- Or stop other applications using port 8080

**"Java version error"**
- Ensure Java 17+ is installed
- Check JAVA_HOME environment variable

**"Build fails"**
- Check Java and Maven versions
- Ensure all dependencies are downloaded
- Check internet connection for Maven downloads

### Need Help?
- Check the full README.md for detailed documentation
- Review the console output for error messages
- Ensure all prerequisites are met

## 🎯 What's Next?

After getting the basic application running:

1. **Customize Templates**: Modify resume templates in the ResumeService
2. **Add Authentication**: Implement user login and session management
3. **Database**: Switch from H2 to PostgreSQL for production
4. **Deploy**: Package and deploy to a cloud platform

---

**Happy coding! 🎉**
