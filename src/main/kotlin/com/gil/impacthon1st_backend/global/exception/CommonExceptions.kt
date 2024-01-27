package com.gil.impacthon1st_backend.global.exception

import com.gil.impacthon1st_backend.global.error.CustomException

class NotFoundException(
    message: String
) : CustomException(404, message)

class BadRequestException(
    message: String
) : CustomException(400, message)

class UnauthorizedException(
    message: String
) : CustomException(401, message)

class ForbiddenException(
    message: String
) : CustomException(403, message)

class ConflictException(
    message: String
) : CustomException(409, message)