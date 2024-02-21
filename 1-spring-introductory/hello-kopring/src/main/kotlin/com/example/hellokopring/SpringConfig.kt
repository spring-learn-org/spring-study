package com.example.hellokopring

import com.example.hellokopring.repository.JpaMemberRepository
import com.example.hellokopring.repository.MemberRepository
import com.example.hellokopring.service.MemberService
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig(private val em: EntityManager) {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository {
//        return JdbcMemberRepository(dataSource)
        return JpaMemberRepository(em)
    }
}
