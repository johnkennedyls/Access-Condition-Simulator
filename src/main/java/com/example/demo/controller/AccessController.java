package com.example.demo.controller;

import com.example.demo.model.AccessCondition;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador que maneja las solicitudes relacionadas con la simulación de acceso
 */
@Controller
public class AccessController {

    /**
     * Muestra el formulario inicial para ingresar las condiciones
     * @param model El modelo para pasar datos a la vista
     * @return Nombre de la plantilla a renderizar
     */
    @GetMapping("/")
    public String showForm(Model model) {
        // Agregamos un objeto vacío de AccessCondition al modelo para el formulario
        model.addAttribute("accessCondition", new AccessCondition());
        return "access-form"; // Nombre del archivo HTML en /templates
    }

    /**
     * Procesa la verificación de acceso según las condiciones enviadas
     * @param condition El objeto con las condiciones marcadas por el usuario
     * @param model El modelo para pasar datos a la vista de resultado
     * @return Nombre de la plantilla de resultado
     */
    @PostMapping("/check-access")
    public String checkAccess(@ModelAttribute AccessCondition condition, Model model) {
        // Evaluamos la condición de acceso según la fórmula
        boolean hasAccess = condition.checkAccess();

        // Pasamos los datos a la vista
        model.addAttribute("condition", condition);
        model.addAttribute("hasAccess", hasAccess);
        return "access-result";
    }

    /**
     * Genera y muestra la tabla de verdad para la condición de acceso
     * @param model El modelo para pasar la tabla a la vista
     * @return Nombre de la plantilla de tabla de verdad
     */
    @GetMapping("/truth-table")
    public String truthTable(Model model) {
        List<TableRow> rows = new ArrayList<>();

        // Generamos todas las combinaciones posibles (2³ = 8 filas)
        for (boolean admin : new boolean[]{true, false}) {
            for (boolean password : new boolean[]{true, false}) {
                for (boolean special : new boolean[]{true, false}) {
                    // Creamos objeto AccessCondition para cada combinación
                    AccessCondition condition = new AccessCondition();
                    condition.setAdmin(admin);
                    condition.setCorrectPassword(password);
                    condition.setSpecialAccess(special);

                    // Añadimos la fila a la tabla
                    rows.add(new TableRow(admin, password, special, condition.checkAccess()));
                }
            }
        }

        model.addAttribute("rows", rows);
        return "truth-table";
    }

    /**
     * Clase interna para representar cada fila de la tabla de verdad
     * Usando @Data de Lombok para generar getters automáticamente
     */
    @Data
    public static class TableRow {
        private final boolean admin;
        private final boolean correctPassword;
        private final boolean specialAccess;
        private final boolean result;
    }
}