#!/usr/bin/env groovy

def helmCreate(String name, String release) {
    sh "helm create ${name}"
    sh "ls ${name}"
}