#!/bin/bash


# For progrest as database
NAME=postgre-ercommercial
spring init -dweb,jpa,security,validation,lombok,sqlserver,actuator,devtools,mail,configuration-processor,postgresql,flyway  \
-p jar \
--build maven \
--groupId=com.example \
--extract \
--name $NAME \
$NAME
