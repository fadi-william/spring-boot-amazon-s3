#!/usr/bin/env bash

# Clean
mvn clean

# Compile
mvn compile

# Test
mvn test \
    -DamazonS3BucketName=${AMAZON_S3_BUCKET_NAME} \
    -DamazonS3ApiKey=${AMAZON_S3_API_KEY} \
    -DamazonS3ApiSecret=${AMAZON_S3_API_SECRET}