rem -Ddockerfile.skip
rem -Ddockerfile.build.skip	-Ddockerfile.tag.skip	-Ddockerfile.push.skip
mvn clean install -Ddockerfile.skip &pause
