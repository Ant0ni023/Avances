package com.brain2;

import android.app.Activity;

public class ControladorApp {

    private static Activity actividad;  // Referencia estática a la actividad principal

    // Método para establecer la actividad principal (se llama desde MainActivity)
    public static void setActividad(Activity actividadPrincipal) {
        actividad = actividadPrincipal;
    }

    // Método para obtener la actividad actual desde otras clases
    public static Activity getActividad() {
        return actividad;
    }
}
