package com.example.study_security.api.user.service

import com.example.study_security.api.user.domain.Member
import com.example.study_security.api.user.domain.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberDetailService(
    private val memberRepository: MemberRepository
) {
    @Transactional(readOnly = true)
    fun getMember(email: String): Member {
        return memberRepository.findByEmail(email)
            ?: throw IllegalArgumentException(email)
    }

    @Transactional
    fun createMember(member: Member) {
        memberRepository.save(member)
    }
}