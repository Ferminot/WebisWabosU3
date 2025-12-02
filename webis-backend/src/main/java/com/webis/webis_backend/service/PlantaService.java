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

    // Obtener todas las plantas
    public List<Planta> obtenerPlantas() {
        return plantaRepository.findAll();
    }

    // Obtener planta por id
    public Planta obtenerPlantaPorId(Long id) {
        return plantaRepository.findById(id).orElse(null);
    }

    // Guardar o actualizar planta
    public Planta guardarPlanta(Planta planta) {
        // Aquí se guardan todos los campos de la entidad:
        // nombre, valor, stock, descripcion, imgPrincipal, imgHover
        return plantaRepository.save(planta);
    }

    // Eliminar planta por id
    public void eliminarPlanta(Long id) {
        plantaRepository.deleteById(id);
    }
}
