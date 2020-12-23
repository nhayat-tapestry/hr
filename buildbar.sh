#!/bin/bash
#!/usr/bin/env sh

echo 'building bar file'
cd /opt/ace-11.0.0.9/tools

#test="${params.Applications_Name}"
echo "$params.Applications_Name"
#appsbuil="$(echo $test| tr ',' ' ')"
#test5=$(echo $test| tr ',' ' ')


# . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a AREACODE_SEARCH_AR HRIS_ESB_PULL_DATA HRIS_ESB_TWILIO_CREATE -compileOnly -v createbartrace.txt -cleanBuild 
# . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a ESB_IDM_EMPLOYEE_FEED PURCHSE_PHONENUMBER_AR -l ESB_IDMInboundWebService_MSPLIB  -compileOnly -v createbartrace.txt -cleanBuild 
# . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a ${appsbuil}  -compileOnly -v createbartrace.txt -cleanBuild 
