package com.example.exament3_1.personajes;

import java.util.List;

public class Contacto {
    private int id;
    private String nombre;
    private String phone;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String phone) {
        this.id = id;
        this.nombre = nombre;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
