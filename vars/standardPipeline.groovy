pipeline {
    agent  any
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', daysToKeepStr: '14'))
        timestamps()
    }
    environment { 
        ENV_NAME                 = "dev" 
        SQUAD_NAME               = "devops"
    }
    stages {
        stage ('terraform init') {
            steps {
                  sh '''
                      echo "terraform init"
                    '''
 
                }
        }
        stage ('terraform plan') {
            steps {
                  sh '''
                      echo "terraform plan"
                    '''
 
                }
        }
        stage ('terraform apply') {
           when {
                expression { env.GIT_BRANCH == 'origin/master' }   
            }
            steps {
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


