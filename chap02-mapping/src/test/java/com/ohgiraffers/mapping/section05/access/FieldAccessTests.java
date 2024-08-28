package com.ohgiraffers.mapping.section05.access;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class FieldAccessTests {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    public static void initFactory(){
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    public void initManager(){
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    public void closeManager(){
        this.entityManager.close();
    }

    @AfterAll
    public static void closeFactory(){
        entityManagerFactory.close();
    }

    @Test
    public void 필드_접근_테스트(){
        Member member = new Member(0,"String memberId", "String memberPwd", "String nickName");

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(member);
        transaction.commit();

        Member foundMember = entityManager.find(Member.class, 1);

        Assertions.assertEquals(member,foundMember);
    }

    @Test
    public void fieldAccess_test(){
        Member fieldMember = entityManager.find(Member.class,1);
        //fieldMember.memberNo = 1 /* db에서 조회된 값 */;

        Assertions.assertNotNull(fieldMember);
        System.out.println(fieldMember);
    }

}
