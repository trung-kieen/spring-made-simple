#!/bin/bash


spring init -dweb,jpa,validation,lombok,h2,devtools,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name jpa-advance \
jpa-advance
