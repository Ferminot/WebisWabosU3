package com.webis.webis_backend.controller;

import com.webis.webis_backend.model.Planta;
import com.webis.webis_backend.service.PlantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantas")
@CrossOrigin(origins = "*") // Permite acceso desde cualquier frontend
public class PlantaController {

    @Autowired
    private PlantaService plantaService;

    // GET todas las plantas, no requiere token
    @GetMapping
    public List<Planta> obtenerPlantas() {
        return plantaService.obtenerPlantas();
    }

    // GET planta por id
    @GetMapping("/{id}")
    public Planta obtenerPlantaPorId(@PathVariable Long id) {
        return plantaService.obtenerPlantaPorId(id);
    }

    // POST nueva planta
    @PostMapping
    public Planta crearPlanta(@RequestBody Planta planta) {
        return plantaService.guardarPlanta(planta);
    }

    // PUT actualizar planta
    @PutMapping("/{id}")
    public Planta actualizarPlanta(@PathVariable Long id, @RequestBody Planta plantaActualizada) {

        Planta planta = plantaService.obtenerPlantaPorId(id);

        if (planta != null) {
            planta.setNombre(plantaActualizada.getNombre());
            planta.setValor(plantaActualizada.getValor());
            planta.setStock(plantaActualizada.getStock());
            planta.setDescripcion(plantaActualizada.getDescripcion());
            planta.setImgPrincipal(plantaActualizada.getImgPrincipal());
            planta.setImgHover(plantaActualizada.getImgHover());

            return plantaService.guardarPlanta(planta);
        }

        return null;
    }

    // DELETE planta
    @DeleteMapping("/{id}")
    public void eliminarPlanta(@PathVariable Long id) {
        plantaService.eliminarPlanta(id);
    }
}
