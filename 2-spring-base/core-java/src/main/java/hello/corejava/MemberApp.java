package hello.corejava;

import hello.corejava.member.Grade;
import hello.corejava.member.Member;
import hello.corejava.member.MemberService;
import hello.corejava.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + memberA.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
