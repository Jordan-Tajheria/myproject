pipeline {
    environment {
        registry = "jordantajheria/getting-started"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
    }
    gent any 
    stages {
        stage('Cloning our Git') {
            steps {
                git 'https://github.com/Jordan-Tajheria/myproject.git'
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