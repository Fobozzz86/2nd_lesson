package com.demoqa;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("#### beforeAll()");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("#### afterAll()");
    }
    @BeforeEach
    void beforeach() {
        System.out.println("   #### beforeach()");
}
    @AfterEach
    void aftereach() {
        System.out.println("          #### aftereach()");
    }

   @Test
   void firstTest() {
       Assertions.assertTrue(3 > 2);
       System.out.println("       #### @Test firstTest()");
   }
    @Test
    void secondTest() {
        Assertions.assertTrue(3 > 2);
        System.out.println("      #### @Test secondTest()");
    }

}
