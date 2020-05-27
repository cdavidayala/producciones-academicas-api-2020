pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './gradlew build --scan'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        
        stage('sonarqube') {
            steps {
                sh './gradlew sonarqube'
            }
        }
        
        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                	sh './gradlew artifactoryPublish'
            }
        }
    }
}
