package com.java.JUnit5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class) // "_" 를 공백으로 변경합니다.
class JUnit5Tests {

	@Test
	void contextLoads() {
		System.out.println("contextLoads");
	}

	@Test
	@DisplayName("테스트 이름")
	void next_step() {
		System.out.println("next step");
	}

	@Test
	@Disabled
	void disabled() {
		System.out.println("테스트 실행을 하지 않습니다.");
	}

	@BeforeAll
	static void beforeAll() {
		System.out.println("BeforeAll");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("AfterAll");
	}

	@BeforeEach
	void beforeEach() {
		System.out.println("BeforeEach");
	}

	@AfterEach
	void afterEach() {
		System.out.println("AfterEach");
	}
}
