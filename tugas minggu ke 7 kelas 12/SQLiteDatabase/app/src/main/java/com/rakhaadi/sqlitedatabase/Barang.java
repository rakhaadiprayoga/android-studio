package com.rakhaadi.sqlitedatabase;

public class Barang {

    private String idbarang, barang, stock, harga;

    public Barang(String idbarang, String barang, String stock, String harga) {
        this.idbarang = idbarang;
        this.barang = barang;
        this.stock = stock;
        this.harga = harga;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getBarang() {
        return barang;
    }

    public void setBarang(String barang) {
        this.barang = barang;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
