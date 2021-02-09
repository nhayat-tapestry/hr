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
                              //  body:'''${JELLY_SCRIPT,template="/var/lib/jenkins/workspace/hrisace/detailed_email"}''',
                         //   body: """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
                           //   """,
                               body: """
                               '$PROJECT_NAME - Build # $env.BUILD_NUMBER - $BUILD_STATUS'.<br/>
                               <br/>
                                Check console <a href="$env.BUILD_URL">output</a> to view full results.<br/>
                                If you cannot connect to the build server, check the attached logs.<br/>
                                <br/>                               
                            Following is the last 100 lines of the log.<br/>
                            <br/>
                        --LOG-BEGIN--<br/>
                        <pre style='line-height: 22px; display: block; color: #333; font-family: Monaco,Menlo,Consolas,"Courier New",monospace; padding: 10.5px; margin: 0 0 11px; font-size: 13px; word-break: break-all; word-wrap: break-word; white-space: pre-wrap; background-color: #f5f5f5; border: 1px solid #ccc; border: 1px solid rgba(0,0,0,.15); -webkit-border-radius: 4px; -moz-border-radius: 4px; border-radius: 4px;'>

</pre>
--LOG-END--
""",
                                
                             mimeType: "text/html",
                            to: "nida.hayat@systemsltd.com"
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
