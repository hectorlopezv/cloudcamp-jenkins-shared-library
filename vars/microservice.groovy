#!/usr/bin/env groovy
def call() {
    node ('docker&&linux'){

    // Docker Build and Push Stages variables
    def appName = "hector-python-hello-world"
    // Docker Build Stage variables
    def dockerFilepath = "_scm_docker/Dockerfile"
    def dockerContext = "_scm_docker/"
    // Repo clone checkout Stage variables
    def branchName = "main"
    def repoURL = "https://github.com/hectorlopezv/cloudcamp-jenkins-lab"
    // Docker Push Stage variables
    def awsRegion = "us-east-1"
    def registryURL = "711324356654.dkr.ecr.us-east-1.amazonaws.com"
    def appVersion = "1.0.0-beta.2"


        //Call checkout stage method
        checkoutFromRepo(branch: "${branchName}", repoURL: "${repoURL}")
        //Call build stage method
        dockerBuild(appName: appName, dockerFilepath: dockerFilepath, context: dockerContext)
        //Call push stage method
        dockerPush(region: "${awsRegion}", registryURL: "${registryURL}", appName: "${appName}", appVersion: "${appVersion}")



}



}