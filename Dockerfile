FROM markhobson/maven-chrome
WORKDIR /app
COPY . /app

# set display port to avoid crash
ENV DISPLAY=:99
CMD mvn test