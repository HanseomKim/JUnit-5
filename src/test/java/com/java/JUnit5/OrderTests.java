package com.java.JUnit5;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTests {
    int value = 1;

    @Order(3)
    @Test
    void printThree() {
        System.out.println(value++); // [결과]: 3
    }

    @Order(2)
    @Test
    void printTwo() {
        System.out.println(value++); // [결과]: 2
    }

    @Order(1)
    @Test
    void printOne() {
        System.out.println(value++); // [결과]: 1
    }

}
