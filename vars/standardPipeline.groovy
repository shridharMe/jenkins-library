#!/usr/bin/env groovy
def call() {
 
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
         if (env.GIT_BRANCH == 'origin/master' ){
          
                sh '''
                 echo "terraform apply"
         '''
         }
    

        }
 
    
 
}
