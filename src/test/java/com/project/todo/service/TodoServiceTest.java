package com.project.todo.service;

import com.project.todo.domain.Category;
import com.project.todo.domain.Member;
import com.project.todo.domain.Todo;
import com.project.todo.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.time.LocalDate;

import static com.project.todo.domain.Category.createCategory;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TodoServiceTest {

    @Autowired TodoService todoService;
    @Autowired TodoRepository todoRepository;
    @Autowired EntityManager em;

    @Test
    public void 카테고리_추가() throws Exception {
        //given
        Member member = createMember();

        Category category = createCategory("카테고리1", member);

        //when
        Long categoryNo = todoService.saveCategory(category);

        //then
        em.flush();
        assertEquals(category, todoRepository.findCategory(categoryNo));
    }

//    @Test
//    public void 투두_추가() throws Exception {
//        //given
//        Member member = createMember();
//        Category category = createCategory("카테고리1", member);
//
//        Todo todo = Todo.createTodo("투두1", LocalDate.of(2022, 04, 11), member, category);
//
//        //when
//        Long categoryNo = todoService.saveTodo(todo);
//
//        //then
//        em.flush();
//        assertEquals(todo, todoRepository.findTodo(categoryNo));
//
//        /*
//            처음 테스트 돌렸을 때 TransientPropertyValueException 에러 발생
//            -> 투두 클래스 Category의 @ManyToOne에 cascade = CascadeType.ALL(영속성 전이로 부모 객체를 저장할 때 자식 객체도 저장됨) 추가
//         */
//    }

    private Member createMember() {
        Member member = new Member("testCategory", "password", "categoryNickname", "USER");
        em.persist(member);
        return member;
    }
}