package com.example.hellokopring.service

import com.example.hellokopring.domain.Member
import com.example.hellokopring.repository.MemoryMemberRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MemberServiceTest {
    lateinit var memberService: MemberService
    lateinit var memoryMemberRepository: MemoryMemberRepository

    @BeforeEach
    fun beforeEach() {
        memoryMemberRepository = MemoryMemberRepository()
        memberService = MemberService(memoryMemberRepository)
    }

    @AfterEach
    fun afterEach() {
        memoryMemberRepository.clearStore()
    }

    @Test
    fun 회원가입() {
        // given
        val member: Member = Member(name = "hello")

        // when
        val saveId: Long = memberService.join(member)

        // then
        val findMember: Member? = memberService.findOne(saveId)
        assertEquals(findMember, member)
    }

    @Test
    fun 중복_회원_예외() {
        // given
        val member1: Member = Member(name = "hello")
        val member2: Member = Member(name = "hello")

        // when
        memberService.join(member1)
        val e = assertThrows<IllegalStateException> { memberService.join(member2) }

        // then
        assertEquals(e.message, "이미 존재하는 회원입니다.")
    }

    @Test
    fun validateDuplicateMember() {
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }

    @Test
    fun getMemberRepository() {
    }
}
