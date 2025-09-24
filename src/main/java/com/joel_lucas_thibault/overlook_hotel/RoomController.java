package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoomController {

    private final EmployeeService employeeService;

    private final RoomService roomService;
    private final EventService eventService;
    private final ClientService clientService;

    public RoomController(RoomService roomService, EventService eventService, ClientService clientService, EmployeeService employeeService) {
        this.roomService = roomService;
        this.eventService = eventService;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @GetMapping("/data")
    public String showRooms(Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);

        List<Event> events = eventService.getAllEvents();
        model.addAttribute("events", events);

        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);

        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "data";
    }
}