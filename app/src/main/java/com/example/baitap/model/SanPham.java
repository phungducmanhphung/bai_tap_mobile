package com.example.baitap.model;

public class SanPham {
     String maSP, tenSp, giaSp, loaiSp;

    public SanPham() {

    }
    public SanPham(String maSP, String tenSp, String giaSp, String loaiSp) {
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.loaiSp = loaiSp;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public String getGiaSp() {
        return giaSp;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public void setGiaSp(String giaSp) {
        this.giaSp = giaSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }
    public String toString2() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", tenSp='" + tenSp + '\'' +
                ", giaSp='" + giaSp + '\'' +
                ", loaiSp='" + loaiSp + '\'' +
                '}';
    }
    @Override
    public String toString() {
        return "\nMã: " + maSP +
                "\nTên: " + tenSp +
                "\nGiá: " + giaSp +
                "\nHãng: " + loaiSp
                + "\n";
    }
}
