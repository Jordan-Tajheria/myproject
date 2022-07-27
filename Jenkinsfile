// Jenkinsfile
node{
	// Jenkins lib
	library (
		identifier: 'first-lib@main', // unique name of your shared lib and branch/tag specifier 
		retriever: modernSCM([$class: 'GitSCMSource',
		remote: 'https://github.com/Jordan-Tajheria/example.git'
		])
	)

	// environment
	environment {
        DOCKERHUB_CREDENTIALS=credentials('dockerhub-id')
    }

	//pipeline stages
	stage('Build') {
		sh 'docker build -t jordantajheria/nodeapptst:latest .'
	}
	stage('Login') {
		sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u -p $DOCKERHUB_CREDENTIALS_USR --password-stdin'
	}
	stage('Deploy Image') {
		sh 'docker push jordantajheria/nodeapptst:latest'
	}
	stage ("Stage One") {
		sh "echo This  is a test"
		helloWorld('Hello Jordan Have a good day')
	}
	stage ("Stage Two") {
		sh "echo This is also a test"
		helmCreate('cat')
	}
	stage ("Stage Three") {
		sh "echo checkout"
	}
	post {
		always {
			sh 'docker logout'
		}
	}
}