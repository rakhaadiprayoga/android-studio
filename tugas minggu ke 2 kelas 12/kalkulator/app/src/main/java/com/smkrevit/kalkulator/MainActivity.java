package com.smkrevit.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText bil_1, bil_2;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void hitung(View view) {
        bil_1 = findViewById(R.id.etbil_1);
        hasil = findViewById(R.id.tvHasil);
        bil_2 = findViewById(R.id.etbil_2);

        if (bil_1.getText().toString().equals("") ){
            bil_1.setError("harus di isi");
        }else if (bil_2.getText().toString().equals("") ){
            bil_2.setError("harus di isi");
        }else {
            double a = Double.parseDouble(bil_1.getText().toString());
            double b = Double.parseDouble(bil_2.getText().toString());

            kalkulator calc = new kalkulator();

            double c = calc.pengurangan(a,b);

            hasil.setText(c + "");
        }


    }
}