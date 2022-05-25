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

		stage('Deploy to K8s'){

			steps{
					sshagent(['k8s-jenkins'])
					{
							sh 'scp -r -o StrictHostChecking=no deployment.yaml Jordan@193.201.132.247:/path'

							script{
									try{
											sh 'ssh Jordan@193.201.132.247 kubectl apply -f /path/deployment.yaml --kubeconfig=/path/kube.yaml'
											
									}catch(error)
									{
										echo('This is an error')
									}
							}
					}
			}
		}

		stage('Clean Up') {
		
			steps {
				echo "All Finish!"
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
