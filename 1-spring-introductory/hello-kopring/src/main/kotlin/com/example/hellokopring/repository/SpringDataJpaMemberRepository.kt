package com.example.hellokopring.repository

import com.example.hellokopring.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaMemberRepository : JpaRepository<Member, Long>, MemberRepository {
    override fun findByName(name: String): Member?
}
