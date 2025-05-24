#!/bin/bash

# Used to init project

# Just run for test service connection
# spring init -dweb,cloud-eureka \

# Require to connect database
NAME=order
spring init -dweb,cloud-eureka,jpa,lombok,actuator,cloud-feign,validation,sqlserver \
-p jar \
--build maven \
--groupId=com.ecommercial \
--extract \
--name $NAME \
$NAME
