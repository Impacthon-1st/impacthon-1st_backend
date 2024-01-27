package com.gil.impacthon1st_backend.domain.file.controller

import com.gil.impacthon1st_backend.global.s3.S3Util
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/file")
@RestController
class FileController(
    private val s3Util: S3Util,
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun uploadFile(
        @RequestPart("file") multipartFile: MultipartFile,
    ): FileUploadResponse {
        return FileUploadResponse(s3Util.uploadImage(multipartFile))
    }
}

data class FileUploadResponse(
    val url: String
)