def call(Map pipelineParams) {
       stage ('print Params') {
            steps {
                  sh '''
                      echo "terraform init"
                    '''
 
                }
        }
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
