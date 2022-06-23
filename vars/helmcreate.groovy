#!/usr/bin/env groovy

def call(String chartName, String releaseName) {
    sh "helm create ${chartName}"
    sh "helm ls"
    sh "helm install ${releaseName} ${chartName}"
}