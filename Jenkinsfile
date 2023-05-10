pipeline{
    agent any
        tools{
        maven 'maven_3_8_8'
        }
    stages{

        stage("SCM Checkout"){
            steps{
            git 'https://github.com/iswarya1223/EtsyProject.git'
            }
        }
        stage("Maven Build"){
            steps{
                bat 'mvn clean package'
            }
        }
        stage("Build Docker image"){
            steps{
                script{
                    bat 'docker build -t iswarya/etsyintegration -f Dockerfile.prod .'
                }
            }
        }
    }
}