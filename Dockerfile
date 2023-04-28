FROM openjdk:17-oracle
RUN groupadd -r user && useradd -r -g user user
USER user
WORKDIR /home/user
COPY target/application-0.0.1-SNAPSHOT.jar application.jar
COPY hard-flag.txt /hard-flag.txt
ENTRYPOINT ["java","-jar","application.jar"]