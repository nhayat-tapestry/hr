echo 'building bar file'
cd /opt/ace-11.0.0.9/tools

 . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE/PI -b $WORKSPACE/Misc/BARfiles/${BUILD_ID}.bar  -a AREACODE_SEARCH_AR HRIS_ESB_PULL_DATA HRIS_ESB_TWILIO_CREATE -compileOnly -v createbartrace.txt -cleanBuild 
