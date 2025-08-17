Write-Host "========================================" -ForegroundColor Cyan
Write-Host "Student Achievement Tracker Setup" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Check Java installation
Write-Host "Checking Java installation..." -ForegroundColor Yellow
try {
    $javaVersion = java -version 2>&1
    Write-Host "Java version found:" -ForegroundColor Green
    Write-Host $javaVersion[0] -ForegroundColor Green
} catch {
    Write-Host "ERROR: Java is not installed or not in PATH" -ForegroundColor Red
    Write-Host "Please install Java 17 or higher" -ForegroundColor Red
    Read-Host "Press Enter to continue"
    exit 1
}

Write-Host ""
Write-Host "Checking Maven installation..." -ForegroundColor Yellow
try {
    $mavenVersion = mvn -version 2>&1
    Write-Host "Maven version found:" -ForegroundColor Green
    Write-Host $mavenVersion[0] -ForegroundColor Green
} catch {
    Write-Host ""
    Write-Host "Maven is not installed. Installing Maven..." -ForegroundColor Yellow
    Write-Host ""
    
    # Create temp directory
    $tempDir = "maven-temp"
    if (Test-Path $tempDir) {
        Remove-Item $tempDir -Recurse -Force
    }
    New-Item -ItemType Directory -Path $tempDir | Out-Null
    
    try {
        Write-Host "Downloading Maven..." -ForegroundColor Yellow
        $mavenUrl = "https://archive.apache.org/dist/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip"
        $mavenZip = "$tempDir\maven.zip"
        Invoke-WebRequest -Uri $mavenUrl -OutFile $mavenZip
        
        Write-Host "Extracting Maven..." -ForegroundColor Yellow
        Expand-Archive -Path $mavenZip -DestinationPath $tempDir -Force
        
        Write-Host "Setting up Maven environment..." -ForegroundColor Yellow
        $mavenPath = (Get-ChildItem -Path $tempDir -Directory | Where-Object { $_.Name -like "apache-maven-*" }).FullName
        
        # Add to PATH for current session
        $env:PATH += ";$mavenPath\bin"
        
        # Set environment variables permanently
        [Environment]::SetEnvironmentVariable("MAVEN_HOME", $mavenPath, "User")
        [Environment]::SetEnvironmentVariable("PATH", $env:PATH, "User")
        
        Write-Host "Maven installed successfully!" -ForegroundColor Green
        Write-Host "Please restart your PowerShell session and run this script again." -ForegroundColor Yellow
        
        # Clean up
        Remove-Item $tempDir -Recurse -Force
        
        Read-Host "Press Enter to continue"
        exit 0
    } catch {
        Write-Host "Error installing Maven: $($_.Exception.Message)" -ForegroundColor Red
        if (Test-Path $tempDir) {
            Remove-Item $tempDir -Recurse -Force
        }
        Read-Host "Press Enter to continue"
        exit 1
    }
}

Write-Host ""
Write-Host "Building the project..." -ForegroundColor Yellow
try {
    mvn clean install
    if ($LASTEXITCODE -ne 0) {
        throw "Build failed with exit code $LASTEXITCODE"
    }
} catch {
    Write-Host ""
    Write-Host "Build failed. Please check the error messages above." -ForegroundColor Red
    Read-Host "Press Enter to continue"
    exit 1
}

Write-Host ""
Write-Host "Build successful! Starting the application..." -ForegroundColor Green
Write-Host ""
Write-Host "The application will be available at:" -ForegroundColor Cyan
Write-Host "- Registration Page: http://localhost:8080/register" -ForegroundColor White
Write-Host "- Dashboard: http://localhost:8080/dashboard" -ForegroundColor White
Write-Host "- API: http://localhost:8080/api/students" -ForegroundColor White
Write-Host "- H2 Console: http://localhost:8080/h2-console" -ForegroundColor White
Write-Host ""
Write-Host "Press Ctrl+C to stop the application" -ForegroundColor Yellow
Write-Host ""

try {
    mvn spring-boot:run
} catch {
    Write-Host "Application stopped." -ForegroundColor Yellow
}

Read-Host "Press Enter to continue"
