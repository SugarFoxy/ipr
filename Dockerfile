FROM maven:3.8.3-openjdk-11 as builder
WORKDIR /app
COPY . /app
RUN mvn test