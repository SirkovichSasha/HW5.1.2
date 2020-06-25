package com.example.engineercalculator;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ActivityInfoCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public final static String PICTURE = "picture";
    public final static int REQUEST_CODE_PERMISSION_WRITE_STORAGE=100;
    private Button saveButton;
    private EditText pictureName;
    private String picture;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
         init();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picture=pictureName.getText().toString();
                int permissionStatus= ContextCompat.checkSelfPermission(SettingsActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if(permissionStatus== PackageManager.PERMISSION_GRANTED) {
                       setIntenet(picture);
                }
                else
                    {
                        ActivityCompat.requestPermissions(SettingsActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE_PERMISSION_WRITE_STORAGE);
                    }

                finish();

            }

        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        switch (requestCode){
            case REQUEST_CODE_PERMISSION_WRITE_STORAGE:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    setIntenet(picture);
                }
                else
                {
                    Toast.makeText(this, "No Permission", Toast.LENGTH_LONG).show();
                }
        }
    }

    private void setIntenet(String picture) {
        if(isExternalStorageWritable()) {
            Intent intent = new Intent();
            intent.putExtra(PICTURE, picture);
            setResult(RESULT_OK, intent);
        }
        else {
            Toast.makeText(this, "File Error", Toast.LENGTH_LONG).show();
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    private void init() {

        saveButton = findViewById(R.id.saveButton);
        pictureName = findViewById(R.id.pictureName);
    }
}
