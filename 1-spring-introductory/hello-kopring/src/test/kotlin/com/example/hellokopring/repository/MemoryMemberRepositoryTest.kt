package com.example.hellokopring.repository

import com.example.hellokopring.domain.Member
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MemoryMemberRepositoryTest {
    val repository: MemoryMemberRepository = MemoryMemberRepository()

    @AfterEach
    fun afterEach() {
        repository.clearStore()
    }

    @Test
    fun save() {
        val member: Member = Member(name = "spring")

        repository.save(member)

        val result: Member? = repository.findById(member.id)
        assertEquals(member, result)
    }

    @Test
    fun findByName() {
        val member1: Member = Member(name = "spring1")
        repository.save(member1)

        val member2: Member = Member(name = "spring1")
        repository.save(member2)

        val result: Member? = repository.findByName("spring1")

        assertEquals(result, member1)
    }

    @Test
    fun findAll() {
        val member1: Member = Member(name = "spring1")
        repository.save(member1)

        val member2: Member = Member(name = "spring2")
        repository.save(member1)

        val result: List<Member> = repository.findAll()

        assertEquals(result.size, 2)
    }
}
