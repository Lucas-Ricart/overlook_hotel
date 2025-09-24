package com.joel_lucas_thibault.overlook_hotel;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ChambreService {

    private final ChambreRepository chambreRepository;

    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll(Sort.by("numero"));
    }

    public List<Chambre> getChambresDisponibles() {
        return chambreRepository.findByDisponible(true, Sort.by("numero"));
    }
}
