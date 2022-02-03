package com.java.JUnit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InstanceTests {
    int value = 1;

    @Test
    void printOne() {
        System.out.println(value++); // [결과]: 1
    }

    @Test
    void printTwo() {
        System.out.println(value++); // [결과]: 2
    }

    @Test
    void printThree() {
        System.out.println(value++); // [결과]: 3
    }

}
