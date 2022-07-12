#!/usr/bin/env groovy

def call (config) {

    /*
	def jenkinsCredentials = config.get('jenkinsCredentials', "jenkinsPAT")
    //  Some nested methods using enkins creds can look this up
    env.JENKINS_CREDS = jenkinsCredentials
	*/

    library identifier: 'pipeline-library-demo@12.07', retriever: modernSCM([$class: 'GitSCMSource',
		remote: 'https://github.com/Jordan-Tajheria/myproject'])
		// credentialsId: jenkinsCredentials])

    pipeline {
        parameters {
            String(name: 'chartName', description: 'name of helmchart to be created e.g. buildachart')
        }
        stages {

            stage('Stage ONE') {
            
			    steps {
				    echo "Checking pipeline has started working currently"
			    }
		    }

		    stage("Stage TWO - Create Helm Chart") {
			
			    steps {
				    sh "helm create ${params.chartName}"
			    }
		    }   

		    stage('Stage THREE - Checking info for Helm') {

			    steps {
				    sh "helm ls"
			    }
		    }

        }
    }
}