package com.gil.impacthon1st_backend.global.error

abstract class CustomException(
    val status: Int,
    override val message: String,
) : RuntimeException(message)
