#!/usr/bin/env bash

# Save the old input file separator.
OLD_IFS=$IFS

# Set the current input file separator.
IFS=","

{
    # Escape the first line by reading it.
    read
    while read bucket_name _ api_key secret_key _
    do
        export AMAZON_S3_BUCKET_NAME=${bucket_name}
        export AMAZON_S3_API_KEY=${api_key}
        export AMAZON_S3_SECRET_KEY=${secret_key}
    done
}  < src/main/resources/config/amazon_s3_credentials.csv

# Revert the old input file separator.
IFS=${OLD_IFS}