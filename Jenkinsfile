pipeline {
    agent any 
    environment {
        CI = 'true'
    }
   
   stages{
      // wrap([$class: 'Xvfb']) {
       
      
           stage('Build') {            
             post {
                failure {
                            emailext (
                            subject: "Build fail! Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                            body: """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                              """,
                            to: 'nida.hayat@systemsltd.com'
                                        )
                           }
                    }
                 steps {
                  //   dir('/opt/ace-11.0.0.9/tools')
                    // {
                    //  echo 'path'
                         sh "pwd"   
                       wrap([$class: 'Xvfb'])
                     {   
                     sh "chmod 700 buildbar.sh"
                    sh './buildbar.sh'
                     }
                       // }//end of dir
                     }  //end of step
                
             }//endof stage build
       
       
   }//end of stages 
  }//end of pipleine 
