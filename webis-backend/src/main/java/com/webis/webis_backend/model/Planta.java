package com.webis.webis_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "plantas")
public class Planta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int valor;
    private int stock;

    @Column(length = 1000)
    private String descripcion;

    @Column(name = "img_principal")
    private String imgPrincipal;

    @Column(name = "img_hover")
    private String imgHover;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgPrincipal() {
        return imgPrincipal;
    }

    public void setImgPrincipal(String imgPrincipal) {
        this.imgPrincipal = imgPrincipal;
    }

    public String getImgHover() {
        return imgHover;
    }

    public void setImgHover(String imgHover) {
        this.imgHover = imgHover;
    }
}
