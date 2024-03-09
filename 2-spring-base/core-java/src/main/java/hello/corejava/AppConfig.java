package hello.corejava;

import hello.corejava.discount.DiscountPolicy;
import hello.corejava.discount.RateDiscountPolicy;
import hello.corejava.member.MemberRepository;
import hello.corejava.member.MemberService;
import hello.corejava.member.MemberServiceImpl;
import hello.corejava.member.MemoryMemberRepository;
import hello.corejava.order.OrderService;
import hello.corejava.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
