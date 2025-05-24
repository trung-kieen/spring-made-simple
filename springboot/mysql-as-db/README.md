# Prerequisite
- Docker and docker compose 
- Java, javac, maven, jdk
# Setup environment
1. Change database name and user name password in compose.yaml
2. Change property of database in file application.properties
3. Deploy database server with `docker compose up`
4. Check database heath using phpmyadmin with host `http://localhost:8081/`
5. Login phpmyadmin with username `root` and password `veryscret`
6. Make sure have table demosql
7. Run springboot project with `mvn springboot:run`
