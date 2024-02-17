package com.example.hellokopring.service

import com.example.hellokopring.domain.Member
import com.example.hellokopring.repository.MemberRepository

class MemberService(val memberRepository: MemberRepository) {
    fun join(member: Member): Long {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id
    }

    fun validateDuplicateMember(member: Member) {
        memberRepository.findByName(member.name)
            ?.let { throw IllegalStateException("이미 존재하는 회원입니다.") }
    }

    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findOne(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}
