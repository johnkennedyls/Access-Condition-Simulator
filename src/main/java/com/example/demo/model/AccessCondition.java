package com.example.demo.model;

import lombok.Data;

/**
 * Modelo que representa las condiciones de acceso
 * Usando @Data de Lombok para generar getters, setters, equals, hashCode y toString
 */
@Data
public class AccessCondition {
    // Atributos que representan las tres condiciones
    private boolean admin;             // Si el usuario es administrador
    private boolean correctPassword;   // Si la contraseña es correcta
    private boolean specialAccess;     // Si tiene acceso especial

    /**
     * Evalúa si se permite el acceso según la condición lógica:
     * ((esAdmin && claveCorrecta) || accesoEspecial)
     *
     * @return true si se permite acceso, false en caso contrario
     */
    public boolean checkAccess() {
        return (admin && correctPassword) || specialAccess;
    }
}