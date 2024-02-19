package com.cis.java.spingboot.service;

import com.cis.java.spingboot.model.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MemberService {

    private Map<Long, Member> memberMap = new HashMap<>();

    public Member createMember(Member member) {

        // call the database
        Long memberId = new Random().nextLong();
        member.setMemberId(memberId);
        memberMap.put(memberId, member);
        return member;
    }

    public Member getMember(Long memberId) {
        return memberMap.get(memberId);

    }

    public void deleteMember(Long memberId) {
        memberMap.remove(memberId);
    }
    public boolean updateMember(Long memberId, Member member) {
        if (memberMap.containsKey(memberId)) {
            memberMap.put(memberId, member);
            return true;
        } else {
            return false;
        }
    }
}