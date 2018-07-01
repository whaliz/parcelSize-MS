# Dockerfile for microservice ParcelSizeService

# Get some JRE runtime support, slim version
FROM openjdk:8-jre-slim

# Add the jar to the image
ADD /build/libs/ParcelSizeService-0.0.1-SNAPSHOT.jar ParcelSizeService-0.0.1-SNAPSHOT.jar

# run jar finally
CMD java -jar ParcelSizeService-0.0.1-SNAPSHOT.jar