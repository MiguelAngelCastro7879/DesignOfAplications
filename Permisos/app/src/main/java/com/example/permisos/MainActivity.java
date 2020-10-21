package com.example.permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //solicitarpermisos();
    }
    final private int Request_code__ask_permission=1;
    public void solicitarpermisoCamara(View view) {

        int permisoCamara= ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA);
        if(permisoCamara!= PackageManager.PERMISSION_GRANTED)
        {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            {
                requestPermissions(new String[]{Manifest.permission.CAMERA},Request_code__ask_permission);
            }
        }
    }
    public void solicitarpermisoAlmacenamiento(View view) {

        int r_storage= ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int w_storage= ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(r_storage!= PackageManager.PERMISSION_GRANTED||w_storage!= PackageManager.PERMISSION_GRANTED)
        {
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},Request_code__ask_permission);
            }
        }

    }
}