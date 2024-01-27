package com.gil.impacthon1st_backend.global.s3

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws.s3")
data class S3Properties(val bucket: String)
