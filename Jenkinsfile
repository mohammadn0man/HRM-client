pipeline {
    agent any
    environment {
        PATH = "C:/apache-maven-3.8.1/bin:$PATH"
        JAVA_HOME = "C:/Program Files/Java/jdk1.8.0_221"
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
        }stage("deploy code"){
            steps{
            echo "deploy code....."
            }
        }
    }
}