package com.gil.impacthon1st_backend.global.exception

import com.gil.impacthon1st_backend.global.error.CustomException

object InternalServerErrorException : CustomException(
    500,
    "Internal Server Error"
)
