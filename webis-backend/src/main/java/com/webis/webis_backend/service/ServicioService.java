package com.webis.webis_backend.service;

import com.webis.webis_backend.model.Servicio;
import com.webis.webis_backend.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<Servicio> obtenerServicios() {
        return servicioRepository.findAll();
    }

    public Servicio obtenerServicioPorId(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }

    public Servicio guardarServicio(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public Servicio actualizarServicio(Long id, Servicio servicioActualizado) {
        Servicio servicio = servicioRepository.findById(id).orElse(null);
        if (servicio != null) {
            servicio.setNombre(servicioActualizado.getNombre());
            servicio.setValor(servicioActualizado.getValor());
            return servicioRepository.save(servicio);
        }
        return null;
    }

    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}
