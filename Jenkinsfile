pipeline {
    agent any 
    environment {
        CI = 'true'
    }
   parameters {
    //choice(name: 'Bar_Applications',
     // choices: 'one\ntwo\nthree\nfour',
     // description: 'What door do you choose?')
       extendedChoice description: '', multiSelectDelimiter: ',', name: 'NAMES', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_CHECKBOX', value:'a,b,c', visibleItemCount: 3
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
                     echo "Trying: ${params.Bar_Applications}"
                     }
                       // }//end of dir
                     }  //end of step
                
             }//endof stage build
       
       
   }//end of stages 
  }//end of pipleine 
