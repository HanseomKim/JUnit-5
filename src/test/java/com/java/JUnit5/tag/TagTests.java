package com.java.JUnit5.tag;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagTests {

    @Test
    @Tag("local")
    void tagLocalTest() {
        System.out.println("local");
    }

    @Test
    @Tag("testci")
    void tagTestCiTest() {
        System.out.println("testci");
    }

    @CustomTag
    void customTagTest() {
        System.out.println("custom tag");
    }
}
