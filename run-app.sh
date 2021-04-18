#!/bin/bash

echo "###### Cleaning compilation"
./gradlew clean

echo "###### Building java app"
./gradlew build

echo "###### Removing all docker images"
docker rm mongodb
docker rm docker_openfda-api_1

echo "###### Starting app"
docker-compose -f docker/docker-compose.yml up --no-deps --build