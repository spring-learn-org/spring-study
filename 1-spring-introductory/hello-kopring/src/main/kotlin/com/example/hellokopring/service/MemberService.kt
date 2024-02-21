package com.example.hellokopring.service

import com.example.hellokopring.domain.Member
import com.example.hellokopring.repository.MemberRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
class MemberService(private val memberRepository: MemberRepository) {
    fun join(member: Member): Long {
        validateDuplicateMember(member)
        memberRepository.save(member)
        return member.id ?: throw IllegalStateException("Member ID cannot be null after save operation")
    }

    private fun validateDuplicateMember(member: Member) {
        val memberName = member.name ?: throw IllegalStateException("Member name cannot be null")
        memberRepository.findByName(memberName).let { foundMember ->
            if (foundMember != null) {
                throw IllegalStateException("이미 존재하는 회원입니다.")
            }
        }
    }

    fun findMembers(): List<Member> = memberRepository.findAll()

    fun findOne(memberId: Long): Member? = memberRepository.findById(memberId)
}
