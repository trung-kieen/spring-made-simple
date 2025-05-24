#!/bin/bash


NAME=finance
spring init -dweb,jpa,validation,lombok,mysql,actuator,devtools,docker-compose,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name $NAME \
$NAME
# --name finance
# --build gradle-project \



# Project with sql, mail as back end => We need to user docker
NAME=finance
spring init -dweb,jpa,security,validation,lombok,mysql,actuator,devtools,docker-compose,mail,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name $NAME \
$NAME





# Use h2 as database => Don't have sql and docker setup
NAME=finance
spring init -dweb,jpa,validation,lombok,h2,devtools,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name $NAME \
$NAME



NAME=postgre-ercommercial
spring init -dweb,jpa,security,validation,lombok,actuator,devtools,mail,configuration-processor,postgresql,flyway  \
-p jar \
--build maven \
--groupId=com.example \
--extract \
--name $NAME \
$NAME



NAME=the-open-book
spring init -dweb,jpa,security,validation,lombok,actuator,devtools,mail,configuration-processor,postgresql,flyway,thymeleaf \
-p jar \
--build maven \
--groupId=com.example \
--extract \
--name $NAME \
$NAME




NAME=basic-test
spring init -dweb,jpa,validation,lombok,h2,devtools,configuration-processor,thymeleaf \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name $NAME \
$NAME



NAME=test-with-junit
spring init -dweb,jpa,validation,lombok,h2,devtools,configuration-processor,thymeleaf \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name $NAME \
$NAME
