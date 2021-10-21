package com.example.tubespbp;

public class DataPengguna {
    private String nama;
    private String NIK;
    private String alamat;
    private String notelp;

    public DataPengguna(String nama, String NIK, String alamat, String notelp) {
        this.nama = nama;
        this.NIK = NIK;
        this.alamat = alamat;
        this.notelp = notelp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNIK() {
        return NIK;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}
