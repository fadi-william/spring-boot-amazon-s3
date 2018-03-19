#!/usr/bin/env bash

# Report to sonar.
mvn sonar:sonar \
    -DsonarLoginToken=${SONAR_LOGIN_TOKEN}