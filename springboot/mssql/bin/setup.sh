#!/bin/bash
spring init -dweb,jpa,security,validation,lombok,sqlserver,actuator,devtools,mail,configuration-processor,thymeleaf \
-p jar \
--build maven \
--groupId=com.example \
--extract \
--name mssql \
mssql
