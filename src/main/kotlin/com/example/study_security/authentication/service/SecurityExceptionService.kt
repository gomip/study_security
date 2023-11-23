package com.example.study_security.authentication.service

import com.example.study_security.authentication.dto.ExceptionResponseDto
import com.example.study_security.authentication.enumerable.ErrorCode
import jakarta.servlet.http.HttpServletResponse

class SecurityExceptionService {
    companion object {
        fun onUnknownException(exception: Exception, response: HttpServletResponse) {
            val exceptionResponse = ExceptionResponseDto.of(
                ErrorCode.UNKNOWN_SERVER_ERROR,
                exception.message ?: "알수없는 에러"
            )

            exception.printStackTrace()
            prin
        }
    }
}
/*
*         fun onException(exception: Exception, response: HttpServletResponse) {
            val exceptionResponseDto = ExceptionResponseDto.of(
                ErrorCode.UNKNOWN_SERVER_ERROR,
                exception.message ?: "알 수 없는 에러",
            )

            exception.printStackTrace()
            printError(HttpStatus.INTERNAL_SERVER_ERROR, response, exceptionResponseDto)
        }*/