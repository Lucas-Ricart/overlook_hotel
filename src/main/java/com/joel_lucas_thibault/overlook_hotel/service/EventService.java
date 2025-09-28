package com.joel_lucas_thibault.overlook_hotel.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.joel_lucas_thibault.overlook_hotel.model.Event;
import com.joel_lucas_thibault.overlook_hotel.repository.EventRepository;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll().stream()
                .sorted(Comparator.comparing(Event::getId))
                .collect(Collectors.toList());
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public List<Event> getEventByName(String name) {
        return eventRepository.findByName(name);
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
