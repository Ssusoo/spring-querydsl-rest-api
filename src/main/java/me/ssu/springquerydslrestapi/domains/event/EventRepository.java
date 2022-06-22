package me.ssu.springquerydslrestapi.domains.event;

import me.ssu.springquerydslrestapi.base.repository.BaseRepository;
import me.ssu.springquerydslrestapi.domains.event.domain.Event;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepository extends BaseRepository<Event, Long> {
}
