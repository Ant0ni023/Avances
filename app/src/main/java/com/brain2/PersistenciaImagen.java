package com.brain2;

import android.content.Context;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistenciaImagen {

    private Context contexto;

    // Constructor que recibe el contexto de la actividad
    public PersistenciaImagen(Context contexto) {
        this.contexto = contexto;
    }

    // Método para guardar información sobre la imagen (puede ser en un archivo o base de datos)
    public void guardarImagen(Imagen imagen) {
        String filename = "imagen_" + imagen.getNombre() + ".txt";
        String contenido = "Nombre: " + imagen.getNombre() + "\nRuta: " + imagen.getRuta() + "\nFecha de Creación: " + imagen.getFechaCreacion();
        try (FileOutputStream fos = contexto.openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(contenido.getBytes()); // Guarda la información en un archivo de texto
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
