@echo off
echo ========================================
echo Student Achievement Tracker Setup
echo ========================================
echo.

echo Checking Java installation...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java 17 or higher
    pause
    exit /b 1
)

echo.
echo Checking Maven installation...
mvn -version
if %errorlevel% neq 0 (
    echo.
    echo Maven is not installed. Installing Maven...
    echo.
    
    echo Downloading Maven...
    powershell -Command "Invoke-WebRequest -Uri 'https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip' -OutFile 'maven.zip'"
    
    echo Extracting Maven...
    powershell -Command "Expand-Archive -Path 'maven.zip' -DestinationPath '.' -Force"
    
    echo Setting up Maven environment...
    setx MAVEN_HOME "%cd%\apache-maven-3.9.6"
    setx PATH "%PATH%;%cd%\apache-maven-3.9.6\bin"
    
    echo Maven installed successfully!
    echo Please restart your command prompt and run this script again.
    pause
    exit /b 0
)

echo.
echo Building the project...
mvn clean install

if %errorlevel% neq 0 (
    echo.
    echo Build failed. Please check the error messages above.
    pause
    exit /b 1
)

echo.
echo Build successful! Starting the application...
echo.
echo The application will be available at:
echo - Registration Page: http://localhost:8080/register
echo - Dashboard: http://localhost:8080/dashboard
echo - API: http://localhost:8080/api/students
echo - H2 Console: http://localhost:8080/h2-console
echo.
echo Press Ctrl+C to stop the application
echo.

mvn spring-boot:run

pause
