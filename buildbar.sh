#!/bin/bash
#!/usr/bin/env sh

echo 'building bar file'
cd /opt/ace-11.0.0.9/tools

test=$1
test2=$2
# echo "$chosen_app"

#"echo ${params.Applications_Name}"
echo ${test2}
appsbuild="$(echo $test| tr ',' ' ')"
#test5=$(echo $test| tr ',' ' ')
echo ${appsbuild}

if [ -z "$test2" ]
then
     
    . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a ${appsbuild}  -deployAsSource -v createbartrace.txt -cleanBuild 

      #echo "\$my_var is NULL"
else

   . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a ${appsbuild} -l ${test2} -deployAsSource -v createbartrace.txt -cleanBuild 

    #  echo "\$my_var is NOT NULL"
fi
cd /$WORKSPACE/Misc/BARfiles
git add . -A
git commit -m "hi"
#git push https://github.com/nhayat-tapestry/hr.git

git remote add origin "https://github.com/nhayat-tapestry/hr.git"
git push -u origin master

# . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a AREACODE_SEARCH_AR HRIS_ESB_PULL_DATA HRIS_ESB_TWILIO_CREATE -compileOnly -v createbartrace.txt -cleanBuild 
# . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a ESB_IDM_EMPLOYEE_FEED PURCHSE_PHONENUMBER_AR -l ESB_IDMInboundWebService_MSPLIB  -compileOnly -v createbartrace.txt -cleanBuild 
 #. /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a ${appsbuild}  -deployAsSource -v createbartrace.txt -cleanBuild 
