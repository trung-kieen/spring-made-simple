#!/bin/bash
spring init -dweb,jpa,security,validation,lombok,mysql,actuator,devtools,docker-compose,mail,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name finance \
 finance




spring init -dweb,jpa,validation,lombok,mysql,actuator,devtools,docker-compose,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name finance \
entitybased
# --name finance
# --build gradle-project \

# Use h2 as database
spring init -dweb,jpa,validation,lombok,h2,devtools,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name thymeleaf \
thymeleaf
