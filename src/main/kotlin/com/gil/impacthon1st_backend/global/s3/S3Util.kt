package com.gil.impacthon1st_backend.global.s3

import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.gil.impacthon1st_backend.global.exception.BadRequestException
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile

@Component
class S3Util(private val amazonS3: AmazonS3, private val s3Properties: S3Properties) {
    fun uploadImage(image: MultipartFile): String {
        try {
            val inputStream = image.inputStream
            val objectMetadata = ObjectMetadata()
            objectMetadata.contentType = image.contentType
            objectMetadata.contentLength = image.size

            amazonS3.putObject(
                PutObjectRequest(
                    s3Properties.bucket,
                    "${image.originalFilename}",
                    inputStream,
                    objectMetadata
                ).withCannedAcl(CannedAccessControlList.PublicRead)
            )

            return getFileUrl("${image.originalFilename}")
        } catch (e: Exception) {
            e.printStackTrace()
            throw BadRequestException("File Upload Fail")
        }
    }

    private fun getFileUrl(fileName: String?): String {
        return amazonS3.getUrl(s3Properties.bucket, fileName).toString()
    }
}