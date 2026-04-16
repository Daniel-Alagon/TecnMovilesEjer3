package com.example.actividad3;

public class Reporte {
    String tipo;
    String prioridad;

    public Reporte(String tipo, String prioridad) {
        this.tipo = tipo;
        this.prioridad = prioridad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPrioridad() {
        return prioridad;
    }
}
