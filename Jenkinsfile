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

		stage("Create Helm Chart") {
			
			steps {
				sh "helm create buildachart"
			}
		}

		stage('Checking info for Helm') {

			steps {
				sh "helm ls"
			}
		}

		stage('Helm upgrade') {

			steps {
				sh "helm upgrade -f apple ./buildachart --dry-run --debug --set repository=jordantajheria/nodeapptst"
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
