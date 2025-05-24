#!/bin/bash

project_name=link-resource
sample_poject=hiberante
spring init -dweb,jpa,validation,lombok,mysql,actuator,devtools,docker-compose,configuration-processor,thymeleaf  \
-p jar \
--build maven \
--groupId=com.trung-kieen \
--extract \
--name $project_name \
$project_name


echo  """
spring.datasource.url=jdbc:mysql://localhost:3306/${project_name}?userSSL=false&serverTimezone=UTC&useLegacyDateTimeCode=false&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=verysecret
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto = update
""" >> $project_name/src/main/resources/application.properties

echo """
services:
  mysql:
    image: 'mysql:latest'
    environment:
      - 'MYSQL_DATABASE=${project_name}'
      - 'MYSQL_PASSWORD=secret'
      - 'MYSQL_ROOT_PASSWORD=verysecret'
      - 'MYSQL_USER=myuser'
    ports:
      - '3306'
  phpmyadmin:
    image: 'phpmyadmin:latest'
    restart: always
    ports:
      - 8081:80
    depends_on:
      - mysql
    environment:
      - 'MYSQL_ROOT_PASSWORD=verysecret'
      - 'PMA_HOST=mysql'
      - 'PMA_PORT=3306'

""" > $project_name/compose.yaml
