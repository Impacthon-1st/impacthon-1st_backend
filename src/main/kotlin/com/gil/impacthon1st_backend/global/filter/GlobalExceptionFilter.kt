package com.gil.impacthon1st_backend.global.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.gil.impacthon1st_backend.global.error.CustomException
import com.gil.impacthon1st_backend.global.error.response.ErrorResponse
import com.gil.impacthon1st_backend.global.exception.InternalServerErrorException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

class GlobalExceptionFilter(
    private val objectMapper: ObjectMapper,
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when (e.cause) {
                is CustomException -> {
                    writeErrorResponse(response, (e.cause as CustomException).status, (e.cause as CustomException).message)
                }

                is Exception -> {
                    e.printStackTrace()
                    writeErrorResponse(response, InternalServerErrorException.status, InternalServerErrorException.message)
                }
            }
        }
    }

    private fun writeErrorResponse(response: HttpServletResponse, status: Int, message: String) {
        val errorResponse = ErrorResponse(status, message)
        response.apply {
            this.status = status
            contentType = MediaType.APPLICATION_JSON_VALUE
            characterEncoding = StandardCharsets.UTF_8.name()
            writer.write(objectMapper.writeValueAsString(errorResponse))
        }
    }
}
