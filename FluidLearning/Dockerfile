FROM maven:3.8.1-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/FluidLearning-0.0.1-SNAPSHOT.jar /usr/local/lib/fluid_backend.jar

ENV DB_HOST=fluidlearning.database.windows.net
ENV DB_PORT=1433
ENV DB_NAME=fluidlearning
ENV DB_USERNAME=fluidlearning
ENV DB_PASSWORD=Tim19#2023

EXPOSE 8080

CMD ["java", "-jar", "/usr/local/lib/fluid_backend.jar"]
