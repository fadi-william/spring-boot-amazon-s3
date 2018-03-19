#!/usr/bin/env bash

# Run the application.
mvn spring-boot:run \
    -DamazonS3BucketName=${AMAZON_S3_BUCKET_NAME} \
    -DamazonS3ApiKey=${AMAZON_S3_API_KEY} \
    -DamazonS3ApiSecret=${AMAZON_S3_API_SECRET}