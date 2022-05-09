pipeline {
    environment {
        registry = "jordantajheria/getting-started"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    agent any 
    stages {
        stage('Checkout external proj') {
            steps {
                git branch: 'main',
                    credentialsId: 'github_id',
                    url: 'https//git@github.com:Jordan-Tajheria/myproject.git'

                sh "ls -lat"
            }
        }
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
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