#!/bin/bash


# Used to init project
spring init -dweb,actuator,cloud-eureka-server \
-p jar \
--build maven \
--groupId=com.ecommercial \
--extract \
--name service-register \
 service-register
