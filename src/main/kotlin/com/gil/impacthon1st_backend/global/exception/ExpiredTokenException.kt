package com.gil.impacthon1st_backend.global.exception

import com.gil.impacthon1st_backend.global.error.CustomException

object ExpiredTokenException : CustomException(
    401,
    "Token Expired",
)
