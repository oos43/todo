package com.project.todo.service;

import com.project.todo.config.MemberDetail;
import com.project.todo.controller.MemberForm;
import com.project.todo.domain.Member;
import com.project.todo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDetail loadUserByUsername(String id) throws UsernameNotFoundException {
         Member member = memberRepository.findById(id);
         return new MemberDetail(member);
    }

    public Long save(MemberForm form) {
        //validateDuplicateId(member);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        form.setPassword(encoder.encode(form.getPassword()));

        Member member = new Member(form.getId(), form.getPassword(), form.getNickname(), "USER");

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
