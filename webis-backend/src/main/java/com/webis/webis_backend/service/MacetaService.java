package com.webis.webis_backend.service;

import com.webis.webis_backend.model.Maceta;
import com.webis.webis_backend.repository.MacetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MacetaService {

    @Autowired
    private MacetaRepository macetaRepository;

    public List<Maceta> obtenerMacetas() {
        return macetaRepository.findAll();
    }

    public Maceta obtenerMacetaPorId(Long id) {
        return macetaRepository.findById(id).orElse(null);
    }

    public Maceta guardarMaceta(Maceta maceta) {
        return macetaRepository.save(maceta);
    }

    public void eliminarMaceta(Long id) {
        macetaRepository.deleteById(id);
    }
}
