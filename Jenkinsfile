//shared lib
library (
		identifier: 'first-lib@main', // unique name of your shared lib and branch/tag specifier 
		retriever: modernSCM([$class: 'GitSCMSource',
		remote: 'https://github.com/Jordan-Tajheria/myproject.git'
		])
)

pipeline {

	agent any
	
	environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub-id')
    }
	
	stages {

		stage('Build') {
		
			steps {
				sh 'docker build -t jordantajheria/nodeapptst:latest .'
			}
		}
	
		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}
		
		stage('Deploy Image') {
			
			steps {
				sh 'docker push jordantajheria/nodeapptst:latest'
			}
		}

		stage('Clean Up') {
		
			steps {
				echo "All Finish! Image deployed"
			}
		}

		stage("hello world stage") {
			steps {
				echo "This is a test"
				helloWorld("Hey there Jordan")
			}
		}

		stage("helm create stage") {
			steps {
				echo "This is also a test"
				helmCreate('star')
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
