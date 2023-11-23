package com.example.study_security.authentication.service

import com.example.study_security.authentication.dto.ExceptionResponseDto
import com.example.study_security.authentication.enumerable.ErrorCode
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus

class SecurityExceptionService {

    companion object {
        private val objectMapper = ObjectMapper()

        fun onUnknownException(exception: Exception, response: HttpServletResponse) {
            val exceptionResponse = ExceptionResponseDto.of(
                ErrorCode.UNKNOWN_SERVER_ERROR,
                exception.message ?: "알수없는 에러"
            )

            exception.printStackTrace()
            printError(HttpStatus.INTERNAL_SERVER_ERROR, response, exceptionResponse)
        }

        private fun printError(
            httpStatus: HttpStatus,
            response: HttpServletResponse,
            exceptionResponseDto: ExceptionResponseDto,
        ) {
            response.contentType = "application/json"
            response.characterEncoding = "UTF-8"
            response.status = httpStatus.value()

            objectMapper.writeValue(response.writer, exceptionResponseDto)
        }
    }
}