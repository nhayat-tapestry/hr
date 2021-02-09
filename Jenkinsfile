pipeline {
    agent any 
    environment {
        CI = 'true'
    }
   parameters {
    //choice(name: 'Bar_Applications',
     // choices: 'one\ntwo\nthree\nfour',
     // description: 'What door do you choose?')
       //extendedChoice description: '', multiSelectDelimiter: ',', name: 'Applications_Name', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_CHECKBOX', value:'AREACODE_SEARCH_AR,ESB_IDM_EMPLOYEE_FEED,HRIS_ESB_PULL_DATA,HRIS_ESB_TWILIO_CREATE,HRIS_ESB_TWILIO_DELETE,IDM_TERMINATEDUSERS,PURCHSE_PHONENUMBER_AR,SMSURL_UPDATE_TWILIO_AR,STATECODE_SEARCH_AR,TWILIO_PHONENUMBER_DELETE_AR', visibleItemCount:8
         extendedChoice description: '', multiSelectDelimiter: ',', name: 'Applications_Name', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_CHECKBOX',propertyFile: 'https://github.com/nhayat-tapestry/hr/blob/master/NUMBERS-values.properties',propertyKey: 'values',visibleItemCount:8
       extendedChoice description: '', multiSelectDelimiter: ',', name: 'library_Name', quoteValue: false, saveJSONParameterToFile: false, type: 'PT_CHECKBOX', value:'ESB_IDMInboundWebService_MSPLIB', visibleItemCount:3
    
   }
   stages{
      // wrap([$class: 'Xvfb']) {
       
      
           stage('Build') {            
             post {
                failure {
                            emailext (
                            subject: "Build fail! Job: '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                             body: """${SCRIPT, template="/email-html.template"}""",
                           // body: """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                             // """,
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
                     //sh "chmod 700 buildbar.sh"
                         sh "chmod 700 jenkinscicd/buildscript.sh"
                   //  sh "./buildbar.sh ${params.Applications_Name}"
                         //sh "./buildbar.sh ${params.Applications_Name} ${params.library_Name}"
                         sh "./jenkinscicd/buildscript.sh ${params.Applications_Name} ${params.library_Name}"
                  //  sh 'def chosen_app="${params.Bar_Applications}" ./buildbar.sh '$chosen_app'''
                    // echo "Trying: ${params.Bar_Applications}"
                        // echo "${params.Applications_Name}| tr ',' ' '" 
                       //  url=scm.getUserRemoteConfigs()[0].getUrl().tokenize('/')[3].split("\\.")[0]
                         echo "${url}"
                     }
                       // }//end of dir
                     }  //end of step
                
             }//endof stage build
       
       
   }//end of stages 
  }//end of pipleine 
