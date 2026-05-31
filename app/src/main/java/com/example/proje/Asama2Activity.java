package com.example.proje;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Asama2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asama2);

        Toolbar toolbar = findViewById(R.id.toolbarAsama2);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Aşama 2 - Sıralama Algoritmaları");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor("#E65100"));

        setupClickListeners();
    }

    private void setupClickListeners() {
        findViewById(R.id.btnS1).setOnClickListener(v -> openDetail(1, "1- Insertion Sort"));
        findViewById(R.id.btnS2).setOnClickListener(v -> openDetail(2, "2- Selection Sort"));
        findViewById(R.id.btnS3).setOnClickListener(v -> openDetail(3, "3- Bubble Sort"));
        findViewById(R.id.btnS4).setOnClickListener(v -> openDetail(4, "4- Divide and Conquer Sort"));
        findViewById(R.id.btnS5).setOnClickListener(v -> openDetail(5, "5- Shell Sort"));
        findViewById(R.id.btnS6).setOnClickListener(v -> openDetail(6, "6- Merge Sort"));
        findViewById(R.id.btnS7).setOnClickListener(v -> openDetail(7, "7- Quick Sort"));
        findViewById(R.id.btnS8).setOnClickListener(v -> openDetail(8, "8- Quick Sort3"));
        findViewById(R.id.btnS9).setOnClickListener(v -> openDetail(9, "9- Heap Sort"));
        findViewById(R.id.btnS10).setOnClickListener(v -> openDetail(10, "10- Radix Sort"));
        findViewById(R.id.btnS11).setOnClickListener(v -> openDetail(11, "11- Shaker Sort"));
        findViewById(R.id.btnS12).setOnClickListener(v -> openDetail(12, "12- Rastgele Sort"));
        findViewById(R.id.btnS13).setOnClickListener(v -> openDetail(13, "13- Lucky Sort"));
        findViewById(R.id.btnS14).setOnClickListener(v -> openDetail(14, "14- Stooge Sort"));
        findViewById(R.id.btnS15).setOnClickListener(v -> openDetail(15, "15- Flash Sort"));
        findViewById(R.id.btnS16).setOnClickListener(v -> openDetail(16, "16- Comb Sort"));
        findViewById(R.id.btnS17).setOnClickListener(v -> openDetail(17, "17- Gnome Sort"));
        findViewById(R.id.btnS18).setOnClickListener(v -> openDetail(18, "18- Permütasyon Sort"));
        findViewById(R.id.btnS19).setOnClickListener(v -> openDetail(19, "19- Strand Sort"));
        findViewById(R.id.btnS20).setOnClickListener(v -> openDetail(20, "20- Kova Sort"));
    }

    private void openDetail(int id, String title) {
        Intent intent = new Intent(this, SortingDetailActivity.class);
        intent.putExtra("sort_id", id);
        intent.putExtra("sort_title", title);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
