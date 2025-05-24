#!/bin/bash


# Used to init project
spring init -dweb,jpa,security,validation,lombok,sqlserver,actuator,devtools,mail,configuration-processor,thymeleaf,flyway  \
-p jar \
--build maven \
--groupId=com.example \
--extract \
--name ecommercial \
 backend
