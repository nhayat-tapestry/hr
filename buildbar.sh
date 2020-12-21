echo 'building bar file'
cd /opt/ace-11.0.0.9/tools

 . /opt/ace-11.0.0.9/server/bin/mqsiprofile && mqsicreatebar -data $WORKSPACE -b $WORKSPACE/${BUILD_ID}.bar  -a AREACODE_SEARCH_AR -compileOnly -v createbartrace.txt -cleanBuild 
