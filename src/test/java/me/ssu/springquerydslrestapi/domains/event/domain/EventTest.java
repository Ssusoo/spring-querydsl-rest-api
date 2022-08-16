//package me.ssu.springquerydslrestapi.domains.event.domain;
//
//import me.ssu.springquerydslrestapi.base.BaseTest;
//import me.ssu.springquerydslrestapi.domains.event.EventRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class EventTest {
//
//	@Autowired
//	private EventRepository eventRepository;
//
//	@Test
//	@DisplayName("Event")
//	void javaBean() {
//		// Given
//		String eventName = "이벤트 이름";
//		String eventDescription = "이벤트 설명";
//
//		// When
//		Event event = new Event();
//		var savedEvent = event.builder()
//				.eventName(eventName)
//				.eventDescription(eventDescription)
//				.build();
//
//		eventRepository.save(savedEvent);
//
//		// Then
//		assertThat(event.getEventName()).isEqualTo(eventName);
//		assertThat(event.getEventDescription()).isEqualTo(eventDescription);
//	}
//}