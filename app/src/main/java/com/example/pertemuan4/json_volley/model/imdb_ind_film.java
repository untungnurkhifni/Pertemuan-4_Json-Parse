package com.example.pertemuan4.json_volley.model;

public class imdb_ind_film {

    private String judul ;
    private String deskripsi;
    private String rate ;
    private String sutradara;
    private String kategori;
    private String image_url;


    public imdb_ind_film() {

    }

    public imdb_ind_film(String judul, String deskripsi, String rate, String sutradara, String kategori, String image_url) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.rate = rate;
        this.sutradara = sutradara;
        this.kategori = kategori;
        this.image_url = image_url;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getRate() {
        return rate;
    }

    public String getSutradara() {
        return sutradara;
    }

    public String getKategori() {
        return kategori;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

