package com.joel_lucas_thibault.overlook_hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joel_lucas_thibault.overlook_hotel.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByCapacity(Integer capacity);
}