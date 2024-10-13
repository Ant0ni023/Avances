package com.brain2;

import android.content.Intent;
import android.provider.MediaStore;

public class IniciarApp {

    private static final int REQUEST_CODE_GALERIA = 100;

    // Método para abrir la galería y manejar la inicialización
    public void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        ControladorApp.getActividad().startActivityForResult(intent, REQUEST_CODE_GALERIA); // Inicia la galería
    }

    // Método para procesar la imagen seleccionada
    public void procesarResultado(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_GALERIA && resultCode == ControladorApp.getActividad().RESULT_OK && data != null) {
            // Aquí llamamos a AdministradorImagen para procesar la imagen seleccionada
            AdministradorImagen administradorImagen = new AdministradorImagen();
            administradorImagen.procesarImagenSeleccionada(data);  // Procesa la imagen seleccionada
        }
    }
}
