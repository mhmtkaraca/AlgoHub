package com.example.proje;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Zaman dilimini Türkiye (İstanbul) olarak ayarla
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Europe/Istanbul"));

        setContentView(R.layout.activity_main);


        // Toolbar ayarı
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("AlgoHub");
        }

        // Durum çubuğu (Status Bar) rengini koyu turuncu yapma
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor("#E65100"));

        // Aşama 1 Butonu Tıklama
        findViewById(R.id.btnAsama1).setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(MainActivity.this, Asama1Activity.class);
            startActivity(intent);
        });

        // Aşama 2 Butonu Tıklama
        findViewById(R.id.btnAsama2).setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(MainActivity.this, Asama2Activity.class);
            startActivity(intent);
        });

        // Aşama 3 Butonu Tıklama
        findViewById(R.id.btnAsama3).setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(MainActivity.this, Asama3Activity.class);
            startActivity(intent);
        });
    }
}
