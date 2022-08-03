//shared lib
library (
		identifier: 'first-lib@main', // unique name of your shared lib and branch/tag specifier 
		retriever: modernSCM([$class: 'GitSCMSource',
		remote: 'https://github.com/Jordan-Tajheria/example.git'
		])
)

helloWorldFunction()

/*
pipeline {

	agent any
	
	environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub-id')
    }
	
	stages {

		stage('STAGE ONE - Build Docker Image') {
		
			steps {
				sh 'docker build -t jordantajheria/nodeapptst:latest .'
			}
		}
	
		stage('STAGE TWO - Login to DockerHub') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}
		
		stage('STAGE Three - Deploy Image') {
			
			steps {
				sh 'docker push jordantajheria/nodeapptst:latest'
			}
		}

		stage('STAGE FOUR - Clean Up') {
		
			steps {
				echo "All Finish! Image deployed"
			}
		}

		stage('STAGE FIVE - Test function') {
			steps {
				echo "This is a test"
				helloWorld("Hey there Jordan")
			}
		}

		stage('STAGE SIX - Helm Create and Helm Install') {
			steps {
				echo "This is also a test"
				helmCreate('pear')
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
*/