package com.Jhnkhryyh.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText editSemester, editNIM, editNama, editPresensi, editTugas, editUTS, editUAS;
    private Button btnHitungNilai;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSemester = findViewById(R.id.semesterGasal);
        editSemester = findViewById(R.id.semesterGenap);
        editNIM = findViewById(R.id.editNIM);
        editNama = findViewById(R.id.editNama);
        editPresensi = findViewById(R.id.editPresensi);
        editTugas = findViewById(R.id.editTugas);
        editUTS = findViewById(R.id.editUTS);
        editUAS = findViewById(R.id.editUAS);
        btnHitungNilai = findViewById(R.id.btnHitungNilai);

        btnHitungNilai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungNilaiAkhir();
            }
        });
    }

    private void hitungNilaiAkhir() {
        if (editSemester.getText().toString().isEmpty() ||
                editNIM.getText().toString().isEmpty() ||
                editNama.getText().toString().isEmpty() ||
                editPresensi.getText().toString().isEmpty() ||
                editTugas.getText().toString().isEmpty() ||
                editUTS.getText().toString().isEmpty() ||
                editUAS.getText().toString().isEmpty()) {

            Toast.makeText(this, "Seluruh data wajib diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        int presensi = Integer.parseInt(editPresensi.getText().toString());
        int tugas = Integer.parseInt(editTugas.getText().toString());
        int uts = Integer.parseInt(editUTS.getText().toString());
        int uas = Integer.parseInt(editUAS.getText().toString());

        if (presensi < 10 || presensi > 100 || tugas < 10 || tugas > 100 ||
                uts < 10 || uts > 100 || uas < 10 || uas > 100) {

            Toast.makeText(this, "Nilai tidak boleh lebih kecil dari 10 dan tidak boleh lebih besar dari 100", Toast.LENGTH_SHORT).show();
            return;
        }

        int nilaiAkhir = (int) Math.ceil(0.1 * presensi + 0.2 * tugas + 0.3 * uts + 0.4 * uas);
        String grade;

        if (nilaiAkhir >= 85) grade = "A";
        else if (nilaiAkhir >= 70) grade = "B";
        else if (nilaiAkhir >= 50) grade = "C";
        else grade = "D";

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("NIM", editNIM.getText().toString());
        intent.putExtra("Nama", editNama.getText().toString());
        intent.putExtra("Semester", editSemester.getText().toString());
        intent.putExtra("NilaiAkhir", nilaiAkhir);
        intent.putExtra("Grade", grade);
        startActivity(intent);
    }
}
