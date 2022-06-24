pipeline {
    agent any
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3.8.6-openjdk-11'
                    args '-v /root/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                sh '''
                    mvn -f ./SWDP-CD-CI clean install
                    echo "Build stage finished"
                '''
            }
        }
        stage('Dockerize') {
            steps {
                sh '''
                    docker -v
                    docker build -t jgmp2022/swdp-cd-ci SWDP-CD-CI
                    echo "Dockerize stage finished"
                '''
            }
        }
    }
}