Spring Boot - Amazon S3 Integration
===================================

[![Build Status](https://travis-ci.org/levioza/spring-boot-amazon-s3.svg?branch=master)](https://travis-ci.org/levioza/spring-boot-amazon-s3)
[![Code Coverage](https://img.shields.io/sonar/https/sonarcloud.io/fr.levioza.hipster%3Aamazon-s3/coverage.svg)](https://sonarcloud.io/dashboard?id=fr.levioza.hipster%3Aamazon-s3)

In this sample application, I provide an example of integrating
Amazon S3 with a Spring Boot (Java) back-end application.

I wrote a blog post regarding this implementation [here](https://medium.com/@levioza/storing-your-blobs-on-a-cloud-storage-provider-amazon-s3-da6c1515cc76).

## Configuration

In order to run this project, you will need to configure an Amazon S3 Bucket.
 
1. Create an IAM user with the following policy in order to be able to access your bucket.

```json
{
    "Version": "version_date",
    "Statement": [
        {
            "Sid": "id",
            "Effect": "Allow",
            "Action": [
                "s3:GetObject",
                "s3:PutObject",
                "s3:DeleteObject"
            ],
            "Resource": [
                "arn:aws:s3:::bucket_name"
            ]
        }
    ]
}
```

2. Download the user credentials and rename the file to `amazon_s3_credentials.csv`
and move it to `src/main/resources/config/`. (This file is ignored by git for security considerations.)

3. Configure your env variables using the provided shell script by typing `source ./amazon_s3_env.sh`. On Windows, you can use [cygwin](http://www.cygwin.com/) or setup the env variables manually.

4. Run the application using `./run_app.sh`.

## Continuous Integration

As this is an open source application. I configured the sonar maven plugin to use SonarCloud.

```
Copyright (c) 2018 Levioza<fadi.william.ghali@levioza.fr>

Site: https://www.levioza.fr

Permission is hereby granted, free of charge, to any person obtaining a
copy of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
and to permit persons to whom the Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
DEALINGS IN THE SOFTWARE.
```