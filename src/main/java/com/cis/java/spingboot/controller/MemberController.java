package com.cis.java.spingboot.controller;

import com.cis.java.spingboot.model.Member;
import com.cis.java.spingboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/{memberId}")
    public Member getMember(@PathVariable Long memberId){
        return memberService.getMember(memberId);
    }

    @DeleteMapping("/{memberId}")
    public void deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
    }
    // create a member
    @PostMapping
    public Member createMember(@RequestBody  Member member){
        return memberService.createMember(member);
    }

    @PutMapping("/{memberId}")
    public boolean updateMember(@PathVariable Long memberId, @RequestBody Member member) {
        return memberService.updateMember(memberId, member);
    }
}