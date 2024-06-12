FROM maven:3.8.3-openjdk-11 as builder
WORKDIR /app
COPY . /app
RUN curl -LO  https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt-get install -y ./google-chrome-stable_current_amd64.deb
RUN mvn test