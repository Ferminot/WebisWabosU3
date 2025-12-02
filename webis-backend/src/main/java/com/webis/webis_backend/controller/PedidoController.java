package com.webis.webis_backend.controller;

import com.webis.webis_backend.model.Pedido;
import com.webis.webis_backend.security.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final JwtUtils jwtUtils;

    public PedidoController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido,
                                         @RequestHeader(value = "Authorization", required = false) String authHeader) {

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).body("Debes iniciar sesión para hacer un pedido");
        }

        String token = authHeader.substring(7);

        // Usamos tus métodos de JwtUtils
        if (!jwtUtils.validarJwt(token)) {
            return ResponseEntity.status(401).body("Token inválido o expirado");
        }

        String correoUsuario = jwtUtils.getUsernameFromJwt(token);

        // Asociamos el pedido al usuario logueado
        pedido.setCorreo(correoUsuario);

        // Aquí guardarías el pedido en la base de datos
        // pedidoRepository.save(pedido);

        return ResponseEntity.ok("Pedido realizado por: " + correoUsuario);
    }
}
