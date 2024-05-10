def call(Map parameters){
    stage ('Build') {
        sh "docker build -t ${parameters.appName} -f ${parameters.dockerFilepath} ${parameters.context}"
    }
}