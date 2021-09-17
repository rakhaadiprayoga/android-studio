package com.komputerkit.kalkulator3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvhasil;
    EditText etbil_1;
    EditText et_bil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        tvhasil = findViewById(R.id.tvhasil);
        etbil_1 = findViewById(R.id.etbil_1);
        et_bil2 = findViewById(R.id.etbil_2);
    }

    public void btnTambah(View view) {
        if(etbil_1.getText().toString().equals("") || et_bil2.getText().toString().equals("")){
            Toast.makeText(this, "ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil_1 = Double.parseDouble(etbil_1.getText().toString());
            double bil_2 = Double.parseDouble(et_bil2.getText().toString());

            double hasil = bil_1 + bil_2;

            tvhasil.setText(hasil + "");
        }
    }

    public void btnKurang(View view) {
        if(etbil_1.getText().toString().equals("") || et_bil2.getText().toString().equals("")){
            Toast.makeText(this, "ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil_1 = Double.parseDouble(etbil_1.getText().toString());
            double bil_2 = Double.parseDouble(et_bil2.getText().toString());

            double hasil = bil_1 - bil_2;

            tvhasil.setText(hasil + "");
        }
    }

    public void btnKali(View view) {
        if(etbil_1.getText().toString().equals("") || et_bil2.getText().toString().equals("")){
            Toast.makeText(this, "ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil_1 = Double.parseDouble(etbil_1.getText().toString());
            double bil_2 = Double.parseDouble(et_bil2.getText().toString());

            double hasil = bil_1 * bil_2;

            tvhasil.setText(hasil + "");
        }
    }

    public void btnBagi(View view) {
        if(etbil_1.getText().toString().equals("") || et_bil2.getText().toString().equals("")){
            Toast.makeText(this, "ada bilangan yang kosong", Toast.LENGTH_SHORT).show();
        }else {
            double bil_1 = Double.parseDouble(etbil_1.getText().toString());
            double bil_2 = Double.parseDouble(et_bil2.getText().toString());

            double hasil = bil_1 / bil_2;

            tvhasil.setText(hasil + "");
        }
    }
}