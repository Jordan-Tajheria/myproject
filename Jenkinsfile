def jenkinsCredentials = 'jenkinsPAT'

library identifier: 'pipeline-library-demo@12.07', retriever: modernSCM([$class: 'GitSCMSource',
		remote: 'https://github.com/Jordan-Tajheria/myproject',
		credentialsId: jenkinsCredentials])

def config = [
	/* Default to specific branch
		in this case 12.07
		however after repo gets cleaned it will be 'main'
	*/
	releaseBranch: "12.07",
	// e.g. releaseFileList: ["helm-charts/*/*.yaml"] - can leave empty
	releaseFileList: [],
	jenkinsCredentials: jenkinsCredentials
]
helmcreate(config)