#!/bin/bash

spring init -dcloud-gateway,cloud-eureka \
-p jar \
--build maven \
--groupId=com.ecommercial \
--extract \
--name gate-way \
gate-way
