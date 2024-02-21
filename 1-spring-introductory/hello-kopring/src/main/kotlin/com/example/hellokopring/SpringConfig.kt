package com.example.hellokopring

import com.example.hellokopring.repository.MemberRepository
import com.example.hellokopring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig(private val memberRepository: MemberRepository) {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository)
    }
}
