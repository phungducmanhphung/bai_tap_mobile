package com.example.baitap.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baitap.R;
import com.example.baitap.model.SanPham;

import java.util.List;

public class CustomeAdapter_SP extends ArrayAdapter {
    Context context;
    int resource;
    List<SanPham> data;
    public CustomeAdapter_SP(@NonNull Context context, int resource, List<SanPham> data) {
        super(context, resource, data);
        this.context = context;
        this.data = data;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(resource, null);
        ImageView ivHinh = convertView.findViewById(R.id.ivHinh);
        TextView tvTenSP = convertView.findViewById(R.id.tvTenSP);
        SanPham sp = data.get(position);
        tvTenSP.setText(sp.getTenSp());
        if(sp.getLoaiSp().equals("Samsung")){
            ivHinh.setImageResource(R.drawable.samsung);
        }
        else if(sp.getLoaiSp().equals("Iphone")){
            ivHinh.setImageResource(R.drawable.iphone);
        }
        else if(sp.getLoaiSp().equals("Nokia")){
            ivHinh.setImageResource(R.drawable.nokia);
        }
        return convertView;
    }
}
