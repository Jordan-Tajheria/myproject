#!/usr/bin/env groovy

def call(String name) {
    sh "helm create ${name}"
    sh "ls ${name}"
}