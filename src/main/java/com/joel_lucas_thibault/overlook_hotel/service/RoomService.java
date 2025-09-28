package com.joel_lucas_thibault.overlook_hotel.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.joel_lucas_thibault.overlook_hotel.model.Room;
import com.joel_lucas_thibault.overlook_hotel.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getRoomsByCapacity(Integer capacity) {
        return roomRepository.findByCapacity(capacity);
    }

    public List<Room> getAllRooms() { //ranger dans l'ordre croissant une base de donnée
        return roomRepository.findAll().stream()
                .sorted(Comparator.comparing(Room::getNumber))
                .collect(Collectors.toList());
    }
}