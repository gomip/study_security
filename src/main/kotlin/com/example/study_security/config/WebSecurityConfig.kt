package com.example.study_security.config

import com.example.study_security.authentication.handler.CustomAuthenticationEntryPoint
import com.example.study_security.api.user.domain.Member
import com.example.study_security.api.user.service.MemberDetailService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class WebSecurityConfig(
    private val memberDetailService: MemberDetailService
) {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    @Bean
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain {

        httpSecurity
            .csrf { it.disable() }
            .formLogin { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .exceptionHandling {
                it.authenticationEntryPoint(CustomAuthenticationEntryPoint())
            }

        return httpSecurity
            .httpBasic(Customizer.withDefaults())
            .build()
    }
}