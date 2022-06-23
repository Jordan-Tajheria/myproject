#!/usr/bin/env groovy

/*
def helloWorld(String name) {
    echo "Hello, ${name}."
}
*/

def call(String helmchartName, String releaseName) {
    sh "helm create ${helmchartName}"
    sh "ls ${helmchartName}"
    sh "helm install ${releaseName} ${helmchartName}"
}
