pipeline {
    agent any 
    environment {
        CI = 'true'
    }
   parameters {
    //choice(name: 'Bar_Applications',
     // choices: 'one\ntwo\nthree\nfour',
     // description: 'What door do you choose?')
       extendedChoice description: '', multiSelectDelimiter: ',', name: 'Applications_Name', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_CHECKBOX', value:'AREACODE_SEARCH_AR,HRIS_ESB_PULL_DATA,HRIS_ESB_TWILIO_CREATE,HRIS_ESB_TWILIO_DELETE,IDM_TERMINATEDUSERS,PURCHSE_PHONENUMBER_AR,SMSURL_UPDATE_TWILIO_AR,STATECODE_SEARCH_AR,TWILIO_PHONENUMBER_DELETE_AR', visibleItemCount:8
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
                     sh "./buildbar.sh ${params.Applications_Name}"
                  //  sh 'def chosen_app="${params.Bar_Applications}" ./buildbar.sh '$chosen_app'''
                    // echo "Trying: ${params.Bar_Applications}"
                        // echo "${params.Applications_Name}| tr ',' ' '" 
                         
                     }
                       // }//end of dir
                     }  //end of step
                
             }//endof stage build
       
       
   }//end of stages 
  }//end of pipleine 
