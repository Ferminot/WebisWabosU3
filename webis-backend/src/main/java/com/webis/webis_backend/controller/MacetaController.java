package com.webis.webis_backend.controller;

import com.webis.webis_backend.model.Maceta;
import com.webis.webis_backend.service.MacetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/macetas")
@CrossOrigin
public class MacetaController {

    @Autowired
    private MacetaService macetaService;

    @GetMapping
    public List<Maceta> obtenerMacetas() {
        return macetaService.obtenerMacetas();
    }

    @GetMapping("/{id}")
    public Maceta obtenerMacetaPorId(@PathVariable Long id) {
        return macetaService.obtenerMacetaPorId(id);
    }

    @PostMapping
    public Maceta crearMaceta(@RequestBody Maceta maceta) {
        return macetaService.guardarMaceta(maceta);
    }

    @PutMapping("/{id}")
    public Maceta actualizarMaceta(@PathVariable Long id, @RequestBody Maceta macetaActualizada) {
        Maceta maceta = macetaService.obtenerMacetaPorId(id);
        if (maceta != null) {
            maceta.setNombre(macetaActualizada.getNombre());
            maceta.setValor(macetaActualizada.getValor());
            maceta.setStock(macetaActualizada.getStock());
            maceta.setImgPrincipal(macetaActualizada.getImgPrincipal()); // <- Nuevo

            return macetaService.guardarMaceta(maceta);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarMaceta(@PathVariable Long id) {
        macetaService.eliminarMaceta(id);
    }
}
