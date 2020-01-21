package com.gi.builmanager.constants;

public enum EstadoGastoComunEnum {

    OPENED("Abierto"),
    CURRENT("Actual"),
    CLOSED("Cerrado");

    public String nombre;

    EstadoGastoComunEnum(String nombre) {
        this.nombre = nombre;
    }
}
