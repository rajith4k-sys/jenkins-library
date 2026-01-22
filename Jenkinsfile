@Library('my-shared-lib') _
pipeline {
    agent any

    tools {
        maven 'maven3.9.12' // Use the maven tool installed earlier 
        jdk 'java17'       // Use JDK 17  
    }

    stages {
        stage('Checkout') {
            steps {
                // checkout the project from the 'project-1'branch in your Github repository
                git branch: 'main', url: 'https://github.com/rajith4k-sys/jenkins-library.git'
            }
        }
        stage('Build') {
            steps {
                mavenBuild()   // calling shared library function
            }
        }

        stage('Post-Build') {
            steps {
                echo "Build completed successfully."
            }
        }
    }
}

