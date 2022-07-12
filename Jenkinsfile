@Library('pipeline-library-demo')_

def jenkinsCredentials = 'jenkinsPAT'

library identifier: 'pipeline-library-demo@12.07', retriever: modernSCM([$class: 'GitSCMSpource',
		remote: 'https://github.com/Jordan-Tajheria/myproject',
		credentialsId: jenkinsCredentials])

def config = [
	/* Default to specific branch
		in this case 12.07
		however after repo gets cleaned it will be 'main'
	*/
	releaseBranch: "12.07"
	// e.g. releaseFileList: ["helm-charts/*/*.yaml"] - can leave empty
	releaseFileList: [].
	jenkinsCredentials: jenkinsCredentials
]
simpleReleaseJenkins(config)


//Pipeline - original codebase
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
				sh "helm upgrade myhelm-1653562001 myhelm"
			}
		}

		stage('Shared Library Demo') {

			steps {
                helmcreate('pumpkin', 'vegetables')  
                //helmcreate('apple', 'fruits')
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
