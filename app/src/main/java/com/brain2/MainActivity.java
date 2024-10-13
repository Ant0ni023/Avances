package com.brain2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private InteraccionUsuario interaccionUsuario;
    private static final int REQUEST_CODE_PERMISOS = 2000;
    private static final int REQUEST_CODE_GALERIA = 1000;
    private String[] permisosNecesarios = {Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Verificamos y solicitamos permisos si es necesario
        verificarPermisos();

        // Inicializamos la clase encargada de gestionar las interacciones del usuario
        interaccionUsuario = new InteraccionUsuario(this);

        // Configuramos los botones de la interfaz
        interaccionUsuario.configurarBotones();
    }

    // Método para verificar y solicitar permisos en tiempo de ejecución
    private void verificarPermisos() {
        for (String permiso : permisosNecesarios) {
            if (ContextCompat.checkSelfPermission(this, permiso) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, permisosNecesarios, REQUEST_CODE_PERMISOS);
            }
        }
    }

    // Método que maneja los resultados de la solicitud de permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISOS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permisos denegados. No se puede acceder a la galería", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Método que maneja el resultado de la selección de imagen en la galería
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Verificamos si el resultado proviene de la galería
        if (requestCode == REQUEST_CODE_GALERIA && resultCode == RESULT_OK && data != null) {
            Toast.makeText(this, "Imagen seleccionada correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al seleccionar la imagen", Toast.LENGTH_SHORT).show();
        }
    }
}
