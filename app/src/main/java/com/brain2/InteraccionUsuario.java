package com.brain2;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button; // Cambiar de ImageView a Button
import android.widget.Toast;

public class InteraccionUsuario {
    private final Activity actividad;

    public InteraccionUsuario(Activity actividad) {
        this.actividad = actividad;
    }

    // Configuramos los listeners de los botones
    public void configurarBotones() {
        // Cambiamos de ImageView a Button para los botones
        Button addImageButton = actividad.findViewById(R.id.add_image_button);
        Button searchButton = actividad.findViewById(R.id.search_button);
        Button homeButton = actividad.findViewById(R.id.home_button);
        Button profileButton = actividad.findViewById(R.id.profile_button);

        // Abrir la galería al presionar el botón de agregar imagen
        addImageButton.setOnClickListener(v -> abrirGaleria());

        // Acción del botón de búsqueda
        searchButton.setOnClickListener(v -> Toast.makeText(actividad, "Buscar imagen", Toast.LENGTH_SHORT).show());

        // Acción del botón de inicio
        homeButton.setOnClickListener(v -> Toast.makeText(actividad, "Volver al inicio", Toast.LENGTH_SHORT).show());

        // Acción del botón de perfil
        profileButton.setOnClickListener(v -> Toast.makeText(actividad, "Abrir perfil", Toast.LENGTH_SHORT).show());
    }

    // Método para abrir la galería
    private void abrirGaleria() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        actividad.startActivityForResult(intent, 1000);
    }
}
