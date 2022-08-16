package me.ssu.springquerydslrestapi.base;

import me.ssu.springquerydslrestapi.domains.event.EventRepository;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@Disabled @SpringBootTest
@AutoConfigureMockMvc @AutoConfigureRestDocs
@Import(RestDocsConfigurationTest.class)
@ActiveProfiles("test")
public class BaseTest {

	@Autowired
	protected EventRepository eventRepository;
}
