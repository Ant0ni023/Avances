package com.brain2;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AdministradorImagen {

    // Método para procesar la imagen seleccionada desde la galería
    public void procesarImagenSeleccionada(Intent data) {
        Uri imagenUri = data.getData(); // Obtiene la URI de la imagen seleccionada
        if (imagenUri != null) {
            mostrarRutaImagen(imagenUri); // Muestra la ruta de la imagen como un mensaje
            // Aquí se puede añadir lógica para realizar más procesamiento en la imagen, como guardarla o editarla.
        } else {
            mostrarError(); // Muestra un mensaje de error si no se seleccionó ninguna imagen
        }
    }

    // Método para mostrar la ruta de la imagen seleccionada al usuario
    private void mostrarRutaImagen(Uri imagenUri) {
        Toast.makeText(ControladorApp.getActividad(), "Imagen seleccionada: " + imagenUri.toString(), Toast.LENGTH_SHORT).show();
    }

    // Método para mostrar un mensaje de error si no se selecciona imagen
    private void mostrarError() {
        Toast.makeText(ControladorApp.getActividad(), "Error: No se seleccionó ninguna imagen", Toast.LENGTH_SHORT).show();
    }
}
