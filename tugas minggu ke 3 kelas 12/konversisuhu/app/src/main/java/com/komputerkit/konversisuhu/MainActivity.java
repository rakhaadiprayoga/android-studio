package com.komputerkit.konversisuhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText etNilai;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        spinner = findViewById(R.id.spinner);
        etNilai = findViewById(R.id.etNilai);
        tvHasil = findViewById(R.id.tvHasil);
    }
    /*
    public void isispinner(){
        String[] isi = {"Celcius To Reamur", "Celcius To Fahrenheit", "Celcius To Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,isi);
        spinner.setAdapter(adapter);
    }
    */

    public void btnKonversi(View view) {
        String pilihan = spinner.getSelectedItem().toString();

        if(etNilai.getText().toString().equals("")){
            Toast.makeText(this, "Nilai tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }else {
            if (pilihan.equals("Celcius To Reamur")) {
                CToR();
            }
            if (pilihan.equals("Celcius To Fahrenheit")) {
                CToF();
            }
            if (pilihan.equals("Celcius To Kelvin")) {
                CToK();
            }

            if (pilihan.equals("Reamur To Celcius")){
                RToC();
            }
            if (pilihan.equals("Reamur To Fahrenheit")){
                RToF();
            }
            if (pilihan.equals("Reamur To Kelvin")){
                RToK();
            }

        }

    }

    public void CToR (){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (4.0/5.0) * suhu;

        tvHasil.setText(hasil+"");
    }

    public void CToF(){

        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9/5) * suhu + 32;

        tvHasil.setText(hasil + "");
    }

    public void CToK(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = suhu + 273;

        tvHasil.setText(hasil + "");
    }

    public void RToC(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (5/4) * suhu;

        tvHasil.setText(hasil + "");
    }

    public void RToF(){
        double suhu = Double.parseDouble(etNilai.getText().toString());
        double hasil = (9/4) * suhu +32;

        tvHasil.setText(hasil + "");
    }

    public void RToK(){
        Toast.makeText(this, "masih kosong", Toast.LENGTH_SHORT).show();
    }
}