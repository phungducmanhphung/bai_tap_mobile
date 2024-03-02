package com.example.baitap.csdl;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baitap.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DatabaseSP extends SQLiteOpenHelper {

    public DatabaseSP(@Nullable Context context) {
        super(context, "dbSanPham", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbSanPham (masp text, tensp text, giasp text, loaisp text)";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void themDL(SanPham sp){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into tbSanPham values(?, ?, ?, ?)";
        db.execSQL(sql, new String[]{sp.getMaSP(), sp.getTenSp(), sp.getGiaSp(), sp.getLoaiSp()});
    }
    public  void suaDL(SanPham sp){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "update tbSanPham set tensp = ?, giasp = ?, loaisp = ? where masp = ?";
        db.execSQL(sql, new String[]{sp.getTenSp(), sp.getGiaSp(), sp.getLoaiSp(), sp.getMaSP()});
    }
    public  void xoaDL(SanPham sp){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "delete from tbSanPham where masp = ?";
        db.execSQL(sql, new String[]{sp.getMaSP()});
    }
    public List<SanPham> docDL(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select * from tbSanPham";
        List<SanPham> datas =  new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst() == true){
            //có dữ liệu
            do {
                SanPham sp = new SanPham();
                sp.setMaSP(cursor.getString(0));
                sp.setTenSp(cursor.getString(1));
                sp.setGiaSp(cursor.getString(2));
                sp.setLoaiSp(cursor.getString(3));
                datas.add(sp);
            }
            while (cursor.moveToNext());
        }

        return datas;
    }
}
