pipeline {
    agent any
    environment {
        PATH = "C:/apache-maven-3.8.1/bin:$PATH"
    }
    stages {
        stage("build code"){
            steps{
                bat "mvn clean install -Dmaven.test.failure.ignore=false"
            }
        }
        stage("test code"){
            steps{
                bat "mvn test"
            }
        }
        stage("deploy code"){
            steps{
                echo "deploy code....."
            }
        }
    }
}