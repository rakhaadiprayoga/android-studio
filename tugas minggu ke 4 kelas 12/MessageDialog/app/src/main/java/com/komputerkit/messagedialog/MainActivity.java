package com.komputerkit.messagedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showToast(String pesan){
        Toast.makeText(this, "pesan", Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String pesan){
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("perhatian !");
        buatAlert.setMessage(pesan);

        buatAlert.show();
    }

    public void showAlertButtton(String pesan){
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        showAlert.setTitle("peringatan");
        showAlert.setMessage(pesan);

        showAlert.setPositiveButton("ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data sudah dihapus");
            }
        });
        showAlert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data tidak dihapus");
            }
        });
        showAlert.show();
    }

    public void btnToast(View view) {
        showToast("Belajar membuat pesan");
    }

    public void btnAlert(View view) {
        showAlert("Silahkan dicoba !");
    }

    public void btnAlertDialogButton(View view) {

        showAlertButtton("yakin akan menghapus ?");
    }
}