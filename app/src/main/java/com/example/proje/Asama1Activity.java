package com.example.proje;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Asama1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asama1);

        Toolbar toolbar = findViewById(R.id.toolbarAsama1);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Aşama 1 - Sayı Grupları");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor("#E65100"));

        // Buton tıklama dinleyicileri buraya eklenebilir
        setupClickListeners();
    }

    private void setupClickListeners() {
        findViewById(R.id.btn1).setOnClickListener(v -> openDetail(1, "1- Mükemmel Sayılar"));
        findViewById(R.id.btn2).setOnClickListener(v -> openDetail(2, "2- Fibonacci Sayıları"));
        findViewById(R.id.btn3).setOnClickListener(v -> openDetail(3, "3- Armstrong sayısı"));
        findViewById(R.id.btn4).setOnClickListener(v -> openDetail(4, "4- Tribonacci Sayılar"));
        findViewById(R.id.btn5).setOnClickListener(v -> openDetail(5, "5- Palindrom Sayılar"));
        findViewById(R.id.btn6).setOnClickListener(v -> openDetail(6, "6- Cullen Sayıları"));
        findViewById(R.id.btn7).setOnClickListener(v -> openDetail(7, "7- Lasa Sayısı"));
        findViewById(R.id.btn8).setOnClickListener(v -> openDetail(8, "8- Fermat sayıları"));
        findViewById(R.id.btn9).setOnClickListener(v -> openDetail(9, "9- Dost Sayılar"));
        findViewById(R.id.btn10).setOnClickListener(v -> openDetail(10, "10- Zengin Sayılar"));
        findViewById(R.id.btn11).setOnClickListener(v -> openDetail(11, "11- Lucas Serisi"));
        findViewById(R.id.btn12).setOnClickListener(v -> openDetail(12, "12- Tetranacci Sayılar"));
        findViewById(R.id.btn13).setOnClickListener(v -> openDetail(13, "13- İkiz Sayılar"));
        findViewById(R.id.btn14).setOnClickListener(v -> openDetail(14, "14- Woodall Sayıları"));
        findViewById(R.id.btn15).setOnClickListener(v -> openDetail(15, "15- Mersenne Sayılar"));
        findViewById(R.id.btn16).setOnClickListener(v -> openDetail(16, "16- Harshad Sayılar"));
        findViewById(R.id.btn17).setOnClickListener(v -> openDetail(17, "17- Cyclic Sayılar"));
        findViewById(R.id.btn18).setOnClickListener(v -> openDetail(18, "18- Tav Sayılar"));
        findViewById(R.id.btn19).setOnClickListener(v -> openDetail(19, "19- Amicable Sayılar"));
        findViewById(R.id.btn20).setOnClickListener(v -> openDetail(20, "20- 6174 Sayısı"));
    }

    private void openDetail(int id, String title) {
        android.content.Intent intent = new android.content.Intent(this, AlgorithmDetailActivity.class);
        intent.putExtra("algo_id", id);
        intent.putExtra("algo_title", title);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
