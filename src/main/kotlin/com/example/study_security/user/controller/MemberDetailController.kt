package com.example.study_security.user.controller

import com.example.study_security.user.domain.Member
import com.example.study_security.user.service.MemberDetailService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class MemberDetailController(
    private val memberDetailService: MemberDetailService,
) {
    @GetMapping("/{email}")
    fun getUserByEmail(@PathVariable email: String): Member {
        return memberDetailService.getMember(email)
    }
}