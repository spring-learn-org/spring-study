package hello.corejava;

import hello.corejava.member.Grade;
import hello.corejava.member.Member;
import hello.corejava.member.MemberServiceImpl;
import hello.corejava.order.Order;
import hello.corejava.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
