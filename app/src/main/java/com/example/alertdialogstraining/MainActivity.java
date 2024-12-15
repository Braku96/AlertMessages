package com.example.alertdialogstraining;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toast.makeText(this,"Toast Message",Toast.LENGTH_LONG).show();
    }

    public void Save(View view){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Kaydet");
        alert.setMessage("Are you sure ?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Fak yu",Toast.LENGTH_LONG).show();
            }
        });
        alert.show();

        //Context Activity Context ve app context olarak ikiye ayrılır.
        //this activite içerisinde kullanılır
        // getApplicationContext() applikasyonu ilgilendiren durumlarda kullanılır
    }
}