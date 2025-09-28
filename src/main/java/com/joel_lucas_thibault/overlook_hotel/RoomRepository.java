package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByCapacity(Integer capacity);
}