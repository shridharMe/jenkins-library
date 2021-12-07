#!/usr/bin/env groovy
def call(Map pipelineParams) {
 
       stage ('print Params') {
    
                  sh '''
                      echo "terraform init"
                    '''
 
               
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
           when {
                expression { env.GIT_BRANCH == 'origin/master' }   
            }
           
                  sh '''
                      echo "terraform apply"
                    '''
 
             
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
