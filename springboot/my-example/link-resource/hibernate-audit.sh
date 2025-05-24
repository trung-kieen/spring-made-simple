#!/bin/bash

spring init -dweb,jpa,validation,lombok,mysql,actuator,devtools,docker-compose,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name hibernate-audit \
hibernate-audit

