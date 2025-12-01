package com.webis.webis_backend.service;

import com.webis.webis_backend.model.Planta;
import com.webis.webis_backend.repository.PlantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PlantaService {

    @Autowired
    private PlantaRepository plantaRepository;

    public List<Planta> obtenerPlantas() {
        return plantaRepository.findAll();
    }

    public Planta obtenerPlantaPorId(Long id) {
        return plantaRepository.findById(id).orElse(null);
    }

    public Planta guardarPlanta(Planta planta) {
        return plantaRepository.save(planta);
    }

    public void eliminarPlanta(Long id) {
        plantaRepository.deleteById(id);
    }
}
