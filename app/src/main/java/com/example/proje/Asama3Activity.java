package com.example.proje;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Asama3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asama3);

        Toolbar toolbar = findViewById(R.id.toolbarAsama3);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Aşama 3 - Arama ve Graf Algoritmaları");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(android.graphics.Color.parseColor("#E65100"));

        setupClickListeners();
    }

    private void setupClickListeners() {
        findViewById(R.id.btnSearch1).setOnClickListener(v -> openDetail(1, "1- Linear Search"));
        findViewById(R.id.btnSearch2).setOnClickListener(v -> openDetail(2, "2- Binary Search"));
        findViewById(R.id.btnSearch3).setOnClickListener(v -> openDetail(3, "3- Interpolation Search"));
        findViewById(R.id.btnSearch4).setOnClickListener(v -> openDetail(4, "4- Graph Algorithms"));
        findViewById(R.id.btnSearch5).setOnClickListener(v -> openDetail(5, "5- Uniform Cost Search"));
        findViewById(R.id.btnSearch6).setOnClickListener(v -> openDetail(6, "6- Floyd Warshall"));
        findViewById(R.id.btnSearch7).setOnClickListener(v -> openDetail(7, "7- Prim's Algorithm"));
        findViewById(R.id.btnSearch8).setOnClickListener(v -> openDetail(8, "8- Kruskal Algorithm"));
        findViewById(R.id.btnSearch9).setOnClickListener(v -> openDetail(9, "9- Dijkstra Algorithm"));
        findViewById(R.id.btnSearch10).setOnClickListener(v -> openDetail(10, "10- Bellman Ford"));
        findViewById(R.id.btnSearch11).setOnClickListener(v -> openDetail(11, "11- Binary Search Tree"));
        findViewById(R.id.btnSearch12).setOnClickListener(v -> openDetail(12, "12- Prüfer sequence"));
        findViewById(R.id.btnSearch13).setOnClickListener(v -> openDetail(13, "13- Text Search"));
        findViewById(R.id.btnSearch14).setOnClickListener(v -> openDetail(14, "14- Horspool Search"));
        findViewById(R.id.btnSearch15).setOnClickListener(v -> openDetail(15, "15- Brute Force Text Search"));
    }

    private void openDetail(int id, String title) {
        Intent intent = new Intent(this, SearchDetailActivity.class);
        intent.putExtra("search_id", id);
        intent.putExtra("search_title", title);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
