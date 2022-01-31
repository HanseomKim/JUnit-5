package com.java.JUnit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assumptions.*;

public class AssumptionTests {

    @Test
    void assumeTrueTest() {
        String trueOrFalse = "true";
        assumeTrue(trueOrFalse.equalsIgnoreCase("true"));
        System.out.println("다음을 실행합니다.");
    }

    @Test
    void assumeFalseTest() {
        String trueOrFalse = "true";
        assumeFalse(trueOrFalse.equalsIgnoreCase("true"));
        System.out.println("다음을 실행하지 않습니다.");
    }

    @Test
    void assumingThatTest() {
        String trueOrFalse = "true";

        assumingThat(trueOrFalse.equalsIgnoreCase("true"), () -> {
            System.out.println("true인 경우 실행됩니다.");
        });

        assumingThat(trueOrFalse.equalsIgnoreCase("false"), () -> {
            System.out.println("false인 경우 실행됩니다.");
        });
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void annotationOnOSTest() {
        System.out.println("특정 OS에서만 실행됩니다.");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_16)
    void annotationOnJreTest() {
        System.out.println("특정 JRE Version에서만 실행됩니다.");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void annotationIfEnvironmentVariableTest() {
        System.out.println("환경변수: TEST_ENV 값이 LOCAL인 경우만 실행됩니다.");
    }
}