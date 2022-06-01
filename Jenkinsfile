def repo = "https://github.com/Jordan-Tajheria/myproject.git"
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

		stage("Deploying Helm") {

			steps {
				sh "helm upgrade --install myhelm-1653562001  myhelm/ --values default/values.yaml"
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
