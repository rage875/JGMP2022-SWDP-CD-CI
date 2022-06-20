pipeline {
  agent {
    docker { image 'maven:3.8.1-openjdk-11'}
  }
  stages {
    stage('Pre-build') {
      steps {
        sh '''
          mvn --version
          echo "Pre-build stage finished"
        '''
      }
    }
    stage('Build') {
      steps {
        sh '''
          mvn -f ./SWDP-CD-CI clean install
          echo "Build stage finished"
        '''
      }
    }
  }
}