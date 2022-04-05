package com.project.todo.repository;

import com.project.todo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findById(String id) {
        TypedQuery<Member> query = em.createQuery("select m from Member m where m.id = :id", Member.class)
                .setParameter("id", id);
        return query.getSingleResult();
    }

    public Member findOne(Long no) {
        return em.find(Member.class, no);
    }
}
