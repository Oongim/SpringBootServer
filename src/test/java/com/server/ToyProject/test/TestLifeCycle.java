package com.server.ToyProject.test;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("## BeforeAll Annotation 호출 ##");
        System.out.println();

    }

    @AfterAll
    static void afterAll(){
        System.out.println("## AfterAll Annotation 호출 ##");
        System.out.println();

    }

    @BeforeEach
    static void beforeEach(){
        System.out.println("## BeforeEach Annotation 호출 ##");
        System.out.println();

    }

    @AfterEach
    static void afterEach(){
        System.out.println("## AfterEach Annotation 호출 ##");
        System.out.println();

    }

    @Test
    @DisplayName("Test Case 1!!!!!")
    public void test(){
        System.out.println("## Test1 ##");
        System.out.println();

    }

    @Test
    @Disabled
    public void test2(){
        System.out.println("## Test2 ##");
        System.out.println();

    }
}
