package com.example.hellokopring.repository

import com.example.hellokopring.domain.Member

class MemoryMemberRepository : MemberRepository {
    companion object {
        private val store: MutableMap<Long, Member> = mutableMapOf<Long, Member>()
        private var sequence: Long = 0L
    }

    override fun save(member: Member): Member {
        member.id = ++sequence
        store.put(member.id, member)
        return member
    }

    override fun findById(id: Long): Member? {
        return store.get(id)
    }

    override fun findByName(name: String): Member? {
        return store.values.find { it.name == name }
    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }

    fun clearStore() {
        store.clear()
    }
}
