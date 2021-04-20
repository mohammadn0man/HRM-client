pipeline {
    agent any
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
                echo "deploying code....."
            }
        }
    }
}