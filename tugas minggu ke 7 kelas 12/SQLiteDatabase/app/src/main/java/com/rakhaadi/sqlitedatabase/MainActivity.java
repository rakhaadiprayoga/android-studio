package com.rakhaadi.sqlitedatabase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Database db;
    EditText etBarang,etStock,etHarga;
    TextView tvPilihan;

    List<Barang> dataBarang = new ArrayList<Barang>();
    BarangAdapter adapter;
    RecyclerView rcvBarang;

    String idBarang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        selectData();
    }
    public  void load(){
        db = new Database(this);
        db.buatTabel();

        etBarang = findViewById(R.id.etBarang);
        etStock = findViewById(R.id.etStock);
        etHarga = findViewById(R.id.etHarga);
        tvPilihan = findViewById(R.id.tvPilihan);
        rcvBarang = findViewById(R.id.rcvBarang);

        rcvBarang.setLayoutManager(new LinearLayoutManager(this));
        rcvBarang.setHasFixedSize(true);
    }

    public void simpan(View v) {
        String barang = etBarang.getText().toString();
        String stock = etStock.getText().toString();
        String harga = etHarga.getText().toString();
        String pilihan = tvPilihan.getText().toString();

        if (barang.isEmpty() || stock.isEmpty() || harga.isEmpty() ){
            pesan("Data kosong");
        }else  {
            if (tvPilihan.equals("insert") ){
                String sql = "INSERT INTO tblbarang (barang,stock,harga) VALUES ('"+barang+"',"+stock+","+harga+")";
                if (db.runSQL(sql)){
                    pesan("insert berhasil");
                    selectData();
                }else {
                    pesan("insert gagal");
                }

            }else{
               String sql = "UPDATE tblbarang\n" +
                       "SET barang = \'"+barang+"', stock = "+stock+", harga = "+harga+"\n" +
                       "WHERE idbarang = "+idBarang+";";

               if (db.runSQL(sql)){
                   pesan("data sudah di ubah");
                   selectData();
               }else{
                   pesan("Data ridak bisa di ubah");
               }
            }
        }

        etBarang.setText("");
        etStock.setText("");
        etHarga.setText("");
        tvPilihan.setText("insert");
    }

    public void pesan(String isi){
        Toast.makeText(this, isi, Toast.LENGTH_SHORT).show();
    }

    public void selectData (){
        String sql = "SELECT * FROM tblbarang order BY barang ASC";
        Cursor cursor = db.select(sql);
        dataBarang.clear();
       if (cursor.getCount() > 0){
           while (cursor.moveToNext()){
               String idbarang = cursor.getString(cursor.getColumnIndex("idbarang"));
               String barang = cursor.getString(cursor.getColumnIndex("barang"));
               String stock = cursor.getString(cursor.getColumnIndex("stock"));
               String harga = cursor.getString(cursor.getColumnIndex("harga"));

               dataBarang.add(new Barang(idbarang,barang,stock,harga));
           }
           adapter = new BarangAdapter(this,dataBarang);
           rcvBarang.setAdapter(adapter);
           adapter.notifyDataSetChanged();

       }else {
           pesan("data kosong");
       }
    }

    public void deleteData(String id){
        String idbarang = id;


        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("peringatan");
        al.setMessage("yakin akan menghapus ?");
        al.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql = "DELETE FROM tblbarang WHERE idbarang = "+idbarang+"";
                if (db.runSQL(sql)){
                    pesan("data ssudah di hapus");
                    selectData();
                }else {
                    pesan("data tidak bisa di hapus");
                }
            }
        });

        al.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            }
        });
        al.show();

    }

    public void selectUpdate(String id){
        idBarang = id;
        String sql ="SELECT * FROM tblbarang WHERE idbarang="+id+";";
        Cursor cursor = db.select(sql);
        cursor.moveToNext();

        etBarang.setText(cursor.getString(cursor.getColumnIndex("barang")));
        etStock.setText(cursor.getString(cursor.getColumnIndex("stock")));
        etHarga.setText(cursor.getString(cursor.getColumnIndex("harga")));

        tvPilihan.setText("update");
    }

}