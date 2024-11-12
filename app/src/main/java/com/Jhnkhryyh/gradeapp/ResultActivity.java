package com.Jhnkhryyh.gradeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textNIM, textNama, textSemester, textNilaiAkhir, textGrade;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textNIM = findViewById(R.id.textNIM);
        textNama = findViewById(R.id.textNama);
        textSemester = findViewById(R.id.textSemester);
        textNilaiAkhir = findViewById(R.id.textNilaiAkhir);
        textGrade = findViewById(R.id.textGrade);
        btnKembali = findViewById(R.id.btnKembali);

        Intent intent = getIntent();
        textNIM.setText("NIM: " + intent.getStringExtra("NIM"));
        textNama.setText("Nama: " + intent.getStringExtra("Nama"));
        textSemester.setText("Semester: " + intent.getStringExtra("Semester"));
        textNilaiAkhir.setText("Nilai Akhir: " + intent.getIntExtra("NilaiAkhir", 0));
        textGrade.setText("Grade: " + intent.getStringExtra("Grade"));

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}