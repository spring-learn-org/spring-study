package com.example.hellokopring

import com.example.hellokopring.repository.JdbcMemberRepository
import com.example.hellokopring.repository.MemberRepository
import com.example.hellokopring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class SpringConfig(private val dataSource: DataSource) {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository())
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return JdbcMemberRepository(dataSource)
    }
}
