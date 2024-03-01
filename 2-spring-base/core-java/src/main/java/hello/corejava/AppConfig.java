package hello.corejava;

import hello.corejava.discount.DiscountPolicy;
import hello.corejava.discount.FixDiscountPolicy;
import hello.corejava.discount.RateDiscountPolicy;
import hello.corejava.member.MemberRepository;
import hello.corejava.member.MemberService;
import hello.corejava.member.MemberServiceImpl;
import hello.corejava.member.MemoryMemberRepository;
import hello.corejava.order.OrderService;
import hello.corejava.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    private static MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }

    private static DiscountPolicy getDiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
