package com.webis.webis_backend.service;

import com.webis.webis_backend.model.Pedido;
import com.webis.webis_backend.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Crear un pedido
    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Obtener todos los pedidos
    public List<Pedido> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    // Buscar un pedido por ID
    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    // Actualizar un pedido
    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setNombre(pedidoActualizado.getNombre());
                    pedido.setCorreo(pedidoActualizado.getCorreo());
                    pedido.setTelefono(pedidoActualizado.getTelefono());
                    pedido.setDireccion(pedidoActualizado.getDireccion());
                    pedido.setNotasAdicionales(pedidoActualizado.getNotasAdicionales());
                    pedido.setFechaPedido(pedidoActualizado.getFechaPedido());
                    pedido.setTotal(pedidoActualizado.getTotal());
                    return pedidoRepository.save(pedido);
                })
                .orElse(null);
    }

    public boolean eliminarPedido(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
