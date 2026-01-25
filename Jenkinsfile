pipeline {
    agent any

    tools {
        maven 'maven3.9.12'
        jdk 'java17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/rajith4k-sys/jenkins-library.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Parallel Jobs') {
            parallel {

                stage('Unit Tests') {
                    steps {
                        sh 'mvn test'
                    }
                }

                stage('SonarQube Scan') {
                    steps {
                        withSonarQubeEnv('sonarqube') {
                            sh '''
                                mvn verify sonar:sonar \
                                -Dsonar.projectKey=simple-java \
                                -Dsonar.projectName=simple-java
                            '''
                        }
                    }
                }
            }
        }

        stage('Push to Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }

        stage('Post-Build') {
            steps {
                echo "Build, tests, Sonar scan, and Nexus deployment completed successfully ✅"
            }
        }
    }
}
