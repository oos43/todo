package com.project.todo.service;

import com.project.todo.domain.Member;
import com.project.todo.config.MemberDetail;
import com.project.todo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public MemberDetail loadUserByUsername(String id) throws UsernameNotFoundException {
         Member member = memberRepository.findById(id);
         return new MemberDetail(member);
    }

    @Transactional
    public Long save(Member member) {
        //validateDuplicateId(member);
        memberRepository.save(member);
        return member.getNo();
    }
/*

    private void validateDuplicateId(Member member) {
        List<Member> findMembers = memberRepository.findById(member.getId());
        if(!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 아이디입니다.");
        }
    }
*/


}
