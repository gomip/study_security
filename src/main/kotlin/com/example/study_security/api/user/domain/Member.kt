package com.example.study_security.api.user.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
class Member private constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long = 0L,

    private val email: String,

    private val password: String,

): UserDetails {

    companion object {
        fun of(
            email: String,
            password: String,
        ): Member {
            return Member(
                email = email,
                password = password,
            )
        }
    }

    override fun getUsername(): String {
        return email
    }

    override fun getPassword(): String {
        return password
    }

    // 사용자에게 부여된 권한을 반환
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf(SimpleGrantedAuthority("user"))
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired():  Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}