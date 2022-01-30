package com.java.JUnit5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AssertionTests {

	@Test
	void contextLoads() {
		Start start = new Start(1);
		assertEquals(Status.STARTED, start.getStatus(), "상태가 맞지 않습니다."); // 테스트 실패 시 message 출력
		System.out.println("예외 발생 시 더이상 수행되지 않습니다.");
		assertNotNull(start);
		assertTrue(start.getLimit() > 0);
	}

	@Test
	void assertAllTest() {
		Start start = new Start(1);
		assertAll(
				() -> assertEquals(Status.STARTED, start.getStatus(), "상태가 맞지 않습니다."),
				() -> assertNotNull(start),
				() -> System.out.println("모든 구문을 확인합니다."),
				() -> assertTrue(start.getLimit() > 0)
		);
	}

	@Test
	void assertThrowTest() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Start(-1));
		String message = exception.getMessage();
		assertEquals("limit은 0보다 커야합니다.", message);
	}

	@Test
	void asesrtTimeoutTest() {
		assertTimeout(Duration.ofSeconds(1), ()-> {
			new Start(1);
			Thread.sleep(1100);
		});
	}
}
