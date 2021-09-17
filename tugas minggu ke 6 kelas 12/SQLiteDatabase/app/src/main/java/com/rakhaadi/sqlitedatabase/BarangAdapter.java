package com.rakhaadi.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {

    Context context;
    List<Barang> barangList;

    public BarangAdapter(Context context, List<Barang> barangList) {
        this.context = context;
        this.barangList = barangList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_barang,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvBarang.setText(barangList.get(i).getBarang());
        viewHolder.tvStock.setText(barangList.get(i).getStock());
        viewHolder.tvHarga.setText(barangList.get(i).getHarga());

        viewHolder.tvMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(context, viewHolder.tvMenu);
                popupMenu.inflate(R.menu.menu_item);

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.ubah:
                                Toast.makeText(context, "Ubah", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.hapus:
                                ((MainActivity)context).deleteData(barangList.get(i).getIdbarang());
                                break;
                        }

                        return false;
                    }
                });

                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return barangList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvBarang, tvStock, tvHarga, tvMenu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvBarang = itemView.findViewById(R.id.tvBarang);
            tvStock = itemView.findViewById(R.id.tvStock);
            tvHarga = itemView.findViewById(R.id.tvHarga);
            tvMenu = itemView.findViewById(R.id.tvMenu);
        }
    }
}
