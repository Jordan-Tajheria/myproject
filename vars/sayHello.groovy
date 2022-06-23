#!/usr/bin/env groovy

def call(String name, String release) {
    sh "helm create ${name}"
    sh "ls ${name}"
}