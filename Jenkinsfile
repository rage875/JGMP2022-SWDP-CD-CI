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
                    mvn -v
                    mvn -f ./SWDP-CD-CI clean install
                    echo "Build stage finished"
                '''
            }
        }
        stage('Dockerize') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh 'docker -v'
                    sh "docker build -t ${env.dockerHubUser}/jgmp2022_swdp-cd-ci SWDP-CD-CI"
                    sh 'echo "Dockerize stage finished"'
                }
            }
        }
        stage('Publish') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPassword}"
                    sh "docker push ${env.dockerHubUser}/jgmp2022_swdp-cd-ci:latest"
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    kubernetesDeploy(configs: "deployment.yml", kubeconfigId: "kubeconfig")
                }
            }
        }
        stage('Clean') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', passwordVariable: 'dockerHubPassword', usernameVariable: 'dockerHubUser')]) {
                    sh "docker rmi maven:3.8.6-openjdk-11 ${env.dockerHubUser}/jgmp2022_swdp-cd-ci:latest"
                }
            }
        }
    }
}
