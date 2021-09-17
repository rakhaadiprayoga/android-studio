package com.rakhaadi.Recyclerviewcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SiswaAdapter adapter;
    List<siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
        isiData();

    }
    public void load(){
        recyclerView = findViewById(R.id.rcvSiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void isiData (){
        siswaList = new ArrayList<siswa>();
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "budi", "Surabaya"));
        siswaList.add(new siswa( "andi", "Surabaya"));
        siswaList.add(new siswa( "abdul", "Surabaya"));
        siswaList.add(new siswa( "suparjo", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));
        siswaList.add(new siswa( "joni", "Surabaya"));

        adapter =  new SiswaAdapter(this,siswaList);
        recyclerView.setAdapter(adapter);
    }


    public void btnTambah(View view) {
        siswaList.add(new siswa( "JONI RAMBO", "JAKARTA"));
        adapter.notifyDataSetChanged();
    }
}