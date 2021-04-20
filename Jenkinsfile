pipeline {
agent any
environment {
PATH = "C:/apache-maven-3.8.1/bin:$PATH"
JAVA_HOME = "C:/Program Files/Java/jdk1.8.0_221"
}
stages {
stage("clone code"){
steps{
git credentialsId: 'git_credentials', url: 'https://github.com/mohammadn0man/HRM-client.git'
}
}
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

}
}