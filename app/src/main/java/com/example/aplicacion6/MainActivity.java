package com.example.aplicacion6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Pagina, llamada, maps, foto, correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pagina = findViewById(R.id.BtnPaginaWeb);
        llamada = findViewById(R.id.BtnLlamada);
        maps = findViewById(R.id.BtnGoogleMaps);
        foto = findViewById(R.id.BtnFoto);
        correo = findViewById(R.id.BtnEnviarCorreo);
        Pagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com.mx"));
                startActivity(intent);
            }
        });
        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent llamada = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:7714215285"));
                startActivity(llamada);
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent maps = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:19.980167, -98.679350"));
                startActivity(maps);
            }
        });
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent foto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(foto);
            }
        });
        correo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent correo = new Intent(Intent.ACTION_SEND);
                correo.setType("text/plain");
                correo.putExtra(Intent.EXTRA_SUBJECT, "Cotización");
                correo.putExtra(Intent.EXTRA_TEXT,"Kioña, kioña");
                correo.putExtra(Intent.EXTRA_EMAIL, new String[]{"JorgeEMML7@gmail.com"});
                startActivity(correo);
            }
        });
    }
}
