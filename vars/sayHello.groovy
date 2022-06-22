#!/usr/bin/env groovy

def helloWorld(String name = 'human') {
    echo "Hello, ${name}."
}

def helmCreate(String helmchartName, String releaseName) {
    sh "helm create ${helmchartName}"
    sh "ls ${helmchartName}"
    sh "helm install ${releaseName} ${helmchartName}"
}
