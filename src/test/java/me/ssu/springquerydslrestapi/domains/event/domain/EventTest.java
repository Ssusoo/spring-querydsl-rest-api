package me.ssu.springquerydslrestapi.domains.event.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventTest {

	@Test
	void javaBean() {
		// Given
		String eventName = "이벤트 이름";
		String eventDescription = "이벤트 설명";

		// When
		Event event = new Event();
		var savedEvent = event.builder()
				.eventName(eventName)
				.eventDescription(eventDescription)
				.build();


		// Then
	}
}