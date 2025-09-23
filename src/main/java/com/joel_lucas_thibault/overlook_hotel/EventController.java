package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/index")
    public String showEvents(Model model) {
        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);
        return "index";
    }
}
