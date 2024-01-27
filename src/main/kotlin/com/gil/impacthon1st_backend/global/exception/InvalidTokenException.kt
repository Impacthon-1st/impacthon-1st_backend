package com.gil.impacthon1st_backend.global.exception

import com.gil.impacthon1st_backend.global.error.CustomException

object InvalidTokenException : CustomException(
    401,
    "Invalid Token",
)
