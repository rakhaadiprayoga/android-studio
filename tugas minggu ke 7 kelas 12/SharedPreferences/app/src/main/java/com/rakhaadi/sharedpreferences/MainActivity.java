package com.rakhaadi.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView etBarang, etStock;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    public void load(){
        etBarang = findViewById(R.id.etBarang);
        etStock = findViewById(R.id.etStock);
        sharedPreferences = getSharedPreferences("barang", MODE_PRIVATE);
    }

    public void isiSharedPreferences(String barang, float stock){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("barang", barang);
        editor.putFloat("stock", stock);
        editor.apply();
    }

    public void simpan(View view) {
        String barang = etBarang.getText().toString();
        float stock = Float.parseFloat(etStock.getText().toString());
        if (barang.isEmpty() || stock == 0.0){
            Toast.makeText(this, "Data kosong", Toast.LENGTH_SHORT).show();
        }else{
            isiSharedPreferences(barang,stock);
            Toast.makeText(this, "Data sudah disimpan", Toast.LENGTH_SHORT).show();
        }
        etBarang.setText("");
        etStock.setText("");
    }

    public void tampil(View view) {
        String barang = sharedPreferences.getString("barang", "");
        float stock = sharedPreferences.getFloat("stock", 0);

        etBarang.setText(barang);
        etStock.setText(stock+"");
    }
}