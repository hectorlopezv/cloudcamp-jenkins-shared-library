def call(Map parameters){

stage ('Push') {
 
    sh 'aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 711324356654.dkr.ecr.us-east-1.amazonaws.com'
        sh "docker tag ${parameters.appName}:latest ${parameters.registryURL}/${parameters.appName}:${parameters.appVersion}"
        sh "docker tag ${parameters.appName}:latest ${parameters.registryURL}/${parameters.appName}:latest"
        sh "docker push ${parameters.registryURL}/${parameters.appName}:${parameters.appVersion}"
        sh "docker push ${parameters.registryURL}/${parameters.appName}:latest"
    
}

}