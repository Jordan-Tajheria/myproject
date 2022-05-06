pipeline {
    environment {
        registry = "Dockerhubaccount/repo"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    gent any 
    stages {
        stage('Cloning our Git') {
            steps {
                git '#####'
            }
        }
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}