#!/usr/bin/env groovy
def call() {
 pipeline {
    agent  any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '14'))
        timestamps()
    }
    parameters { 
        choice(choices: 'dev', description: 'Select the env to deploy', name: 'ENV_NAME')
        choice(choices: 'devops', description: 'Select the team to deploy', name: 'SQUAD_NAME')
    }
    stages{
    
       stage ('print Params') {
    
                  println params
               
        }
        stage ('terraform init') {
            
                  sh '''
                      echo "terraform init"
                    '''
 
               
        }
        stage ('terraform plan') {
          
                  sh '''
                      echo "terraform plan"
                    '''
 
             
        }
        stage ('terraform apply') {
         if (env.GIT_BRANCH == 'origin/master' ){
          
                sh '''
                 echo "terraform apply"
         '''
         }
    

        }
        
    }
    post { 
        always {
            script{
                   echo " build cleanup "
            }
        }
        success { 
              script {
                      sh '''
                       echo " build successfull "
                      '''
                }
        }
        failure {
            script {
                    
                      sh '''
                       echo " build failed "
                      '''
             }
        }
    }
    
}
 
    
 
}
