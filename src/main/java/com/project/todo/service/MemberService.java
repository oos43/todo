package com.project.todo.service;

import com.project.todo.domain.Member;
import com.project.todo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member) {
        validateDuplicateId(member);
        memberRepository.save(member);
        return member.getNo();
    }

    private void validateDuplicateId(Member member) {
        List<Member> findMembers = memberRepository.findById(member.getId());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }

    public Member login(String id, String password) {
        List<Member> members = memberRepository.findById(id);

        if(members.isEmpty()) {
            throw new IllegalStateException("로그인에 실패하였습니다.");
        }

        return members.get(0);
    }
}
