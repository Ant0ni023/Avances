package com.brain2;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorCarpeta {

    private Context contexto;  // Contexto necesario para interactuar con el sistema de archivos y mostrar mensajes

    // Constructor que recibe el contexto de la actividad
    public GestorCarpeta(Context contexto) {
        this.contexto = contexto;
    }

    // Método para crear una nueva carpeta
    public void crearCarpeta(String nombreCarpeta) {
        File directorio = new File(Environment.getExternalStorageDirectory(), nombreCarpeta); // Ruta de la nueva carpeta
        if (!directorio.exists()) {  // Verifica si la carpeta ya existe
            if (directorio.mkdir()) {  // Crea la nueva carpeta
                mostrarMensaje("Carpeta creada: " + nombreCarpeta);
            } else {
                mostrarMensaje("Error al crear la carpeta");
            }
        } else {
            mostrarMensaje("La carpeta ya existe");
        }
    }

    // Método para obtener una lista de todas las carpetas disponibles
    public List<String> obtenerCarpetas() {
        File directorioBase = Environment.getExternalStorageDirectory();  // Directorio raíz del almacenamiento externo
        File[] carpetas = directorioBase.listFiles();  // Obtiene la lista de archivos y carpetas

        List<String> listaCarpetas = new ArrayList<>();
        if (carpetas != null) {
            for (File carpeta : carpetas) {
                if (carpeta.isDirectory()) {  // Verifica si es una carpeta
                    listaCarpetas.add(carpeta.getName());  // Agrega el nombre de la carpeta a la lista
                }
            }
        }

        return listaCarpetas;  // Devuelve la lista de nombres de carpetas
    }

    // Método para mostrar un mensaje usando un Toast
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show();  // Muestra un mensaje en pantalla
    }
}
