/*
package com.project.todo.service;

import com.project.todo.domain.Member;
import com.project.todo.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member("testId", "testPassword", "testNickname", "test@email.com");

        //when
        Long saveNo = memberService.save(member);

        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(saveNo));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_아이디_조회() throws Exception {
        //given
        Member member1 = new Member("testId", "testPassword", "testNickname", "test@email.com");
        Member member2 = new Member("testId", "testPassword", "testNickname", "test@email.com");

        //when
        memberService.save(member1);
        memberService.save(member2);

        //then
        fail("예외가 발생해야 한다");
    }

}*/
