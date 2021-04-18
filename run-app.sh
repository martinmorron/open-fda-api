#!/bin/bash

# Cleaning all
./gradlew clean
./gradlew build
docker rm mongodb
docker rm docker_openfda-api_1

# Starting app
docker-compose -f docker/docker-compose.yml up --no-deps --build