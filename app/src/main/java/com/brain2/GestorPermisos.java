package com.brain2;

import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/*
GestorPermisos gestiona los permisos requeridos por la aplicación.
*/
public class GestorPermisos {

    private static final int REQUEST_CODE_PERMISOS = 1;

    // Método para solicitar permisos si no se han concedido
    public static void solicitarPermisos(Activity actividad, String[] permisos) {
        boolean permisoDenegado = false;

        for (String permiso : permisos) {
            if (ContextCompat.checkSelfPermission(actividad, permiso) != PackageManager.PERMISSION_GRANTED) {
                permisoDenegado = true;
                break;
            }
        }

        if (permisoDenegado) {
            ActivityCompat.requestPermissions(actividad, permisos, REQUEST_CODE_PERMISOS);
        }
    }
}
