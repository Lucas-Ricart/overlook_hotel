package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {

    private final EmployeeService employeeService;

    private final RoomService roomService;
    private final EventService eventService;
    private final ClientService clientService;

    public DataController(RoomService roomService, EventService eventService, ClientService clientService, EmployeeService employeeService) {
        this.roomService = roomService;
        this.eventService = eventService;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @GetMapping("/data")
    public String showData(Model model) {
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
    // CHAMBRES
    // --- AJOUT ---
    @GetMapping("/rooms/add")
    public String showAddRoomForm(Model model) {
        model.addAttribute("room", new Room());
        return "add_room";
    }
 // -- Ajout d'une chambre. difference : le modèle est directement lié à la vue--
    @PostMapping("/rooms/add")
    public String addRoom(@ModelAttribute Room room) {
        room.setAvailable(true);
        roomService.saveRoom(room);
        return "redirect:/data";
    }

    // --- MODIFICATION ---
    @GetMapping("/rooms/edit/{id}")
    public String showEditRoomForm(@PathVariable Long id, Model model) {
        Room room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "edit_room";
    }
    // -- Modification d'une chambre. difference : le modèle est directement lié à la vue, c'est a dire que les champs du formulaire sont liés aux propriétés de l'objet Room --
    @PostMapping("/rooms/edit/{id}")
    public String editRoom(@PathVariable Long id, @ModelAttribute Room room) {
        room.setId(id);
        roomService.saveRoom(room);
        return "redirect:/data";
    }

    // --- SUPPRESSION ---
    @PostMapping("/rooms/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/data";
    }

    // --- FILTRE ---
    @GetMapping("/rooms/filter")
    public String filterRooms(@RequestParam(required = false) Integer beds, Model model) {
        List<Room> rooms = (beds == null) ? roomService.getAllRooms() : roomService.getRoomsByBeds(beds);
        model.addAttribute("rooms", rooms);

        // Ajoute aussi les autres listes pour la page data.html
        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "data";
    }

    // EVENEMENTS
    // --- AJOUT ---
    @GetMapping("/events/add")
    public String showAddEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "add_event";
    }

    @PostMapping("/events/add")
    public String addEvent(@ModelAttribute Event event) {
        eventService.saveEvent(event);
        return "redirect:/data";
    }

    // --- MODIFICATION ---
    @GetMapping("/events/edit/{id}")
    public String showEditEventForm(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        return "edit_event";
    }

    @PostMapping("/events/edit/{id}")
    public String editEvent(@PathVariable Long id, @ModelAttribute Event event) {
        event.setId(id);
        eventService.saveEvent(event);
        return "redirect:/data";
    }

    // --- SUPPRESSION ---
    @PostMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/data";
    }

    // ---FILTRE ---
    @GetMapping("/events/filter")
    public String filterEvents(@RequestParam(required = false) String name, Model model) {
        List<Event> events = (name == null) ? eventService.getAllEvents() : eventService.getEventByName(name);
        model.addAttribute("events", events);

        // Ajoute aussi les autres listes pour la page data.html
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("clients", clientService.getAllClients());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "data";
    }

    // CLIENTS
    // --- AJOUT ---
    @GetMapping("/clients/add")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "add_client";
    }

    @PostMapping("/clients/add")
    public String addClient(@ModelAttribute Client client) {
        clientService.saveClient(client);
        return "redirect:/data";
    }

    // --- MODIFICATION ---
    @GetMapping("/clients/edit/{id}")
    public String showEditClientForm(@PathVariable Long id, Model model) {
        Client client = clientService.getClientById(id);
        model.addAttribute("client", client);
        return "edit_client";
    }

    @PostMapping("/clients/edit/{id}")
    public String editClient(@PathVariable Long id, @ModelAttribute Client client) {
        client.setId(id);
        clientService.saveClient(client);
        return "redirect:/data";
    }

    // --- SUPPRESSION ---
    @PostMapping("/clients/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "redirect:/data";
    }

    // ---FILTRE ---
    @GetMapping("/clients/filter")
    public String filterClients(@RequestParam(required = false) String name, Model model) {
        List<Client> clients = (name == null) ? clientService.getAllClients() : clientService.getClientByName(name);
        model.addAttribute("clients", clients);

        // Ajoute aussi les autres listes pour la page data.html
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "data";
    }

    // EMPLOYES
    // --- AJOUT ---
    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/data";
    }

    // --- MODIFICATION ---
    @GetMapping("/employees/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "edit_employee";
    }

    @PostMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return "redirect:/data";
    }

    // --- SUPPRESSION ---
    @PostMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/data";
    }

    // ---FILTRE ---
    @GetMapping("/employees/filter")
    public String filterEmployees(@RequestParam(required = false) String name, Model model) {
        List<Employee> employees = (name == null) ? employeeService.getAllEmployees() : employeeService.getEmployeeByName(name);
        model.addAttribute("employees", employees);

        // Ajoute aussi les autres listes pour la page data.html
        model.addAttribute("rooms", roomService.getAllRooms());
        model.addAttribute("events", eventService.getAllEvents());
        model.addAttribute("clients", clientService.getAllClients());
        return "data";
    }

}