package com.example.study_security.authentication.dto

import com.example.study_security.authentication.enumerable.ErrorCode
import com.example.study_security.support.util.DateUtil.Companion.toResponseString
import java.time.LocalDateTime

data class ExceptionResponseDto(
    val timestamp: String,
    val error: Error
) {
    companion object {
        fun of(timestampString: String, errorCode: ErrorCode, errorMessage: String): ExceptionResponseDto {
            return ExceptionResponseDto(timestampString, Error(errorCode, errorMessage))
        }

        fun of(errorCode: ErrorCode, errorMessage: String): ExceptionResponseDto {
            return ExceptionResponseDto(LocalDateTime.now().toResponseString(), Error(errorCode, errorMessage))
        }
    }
}

data class Error(
    val code: ErrorCode,
    val message: String
)
