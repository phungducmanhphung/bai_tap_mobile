package com.example.baitap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.baitap.adapter.CustomeAdapter_SP;
import com.example.baitap.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MainBai7 extends AppCompatActivity {

    EditText edtMaSp, edtTenSP, edtGiaSP;
    Spinner spLoaiSP;
    List<String> data_lsp = new ArrayList<>();
    ArrayAdapter adapter_lsp;
    ImageView ivHinh;
    Button btnThem, btnXoa, btnSua, btnThoat;
    ListView lvDanhSach;
    List<SanPham> data_sp = new ArrayList<>();
    ArrayAdapter adapter_sp;
    int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai7);
        setControl();
        setEvent();
    }

    private void setEvent() {
        KhoiTao();
        adapter_lsp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data_lsp);
        spLoaiSP.setAdapter(adapter_lsp);
        spLoaiSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spLoaiSP.getSelectedItem().equals("Samsung")){
                    ivHinh.setImageResource(R.drawable.samsung);
                }
                else if(spLoaiSP.getSelectedItem().equals("Iphone")){
                    ivHinh.setImageResource(R.drawable.iphone);
                }
                else if(spLoaiSP.getSelectedItem().equals("Nokia")){
                    ivHinh.setImageResource(R.drawable.nokia);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        adapter_sp = new CustomeAdapter_SP(this, R.layout.layout_item_sp, data_sp);
        lvDanhSach.setAdapter(adapter_sp);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThemDL();
            }
        });

        lvDanhSach.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SanPham sp = data_sp.get(position);
                edtMaSp.setText(sp.getMaSP());
                edtTenSP.setText(sp.getTenSp());
                edtGiaSP.setText(sp.getGiaSp());
                if(sp.getLoaiSp().equals("Samsung")){
                    spLoaiSP.setSelection(0);
                }
                else if(sp.getLoaiSp().equals("Iphone")){
                    spLoaiSP.setSelection(1);
                }
                else if(sp.getLoaiSp().equals("Nokia")){
                    spLoaiSP.setSelection(2);
                }
                index = position;
            }
        });
        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                data_sp.remove(position);
                adapter_sp.notifyDataSetChanged();
                return false;
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_sp.remove(index);
                adapter_sp.notifyDataSetChanged();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sp = data_sp.get(index);
                sp.setMaSP(edtMaSp.getText().toString());
                sp.setTenSp(edtTenSP.getText().toString());
                sp.setGiaSp(edtGiaSP.getText().toString());
                sp.setLoaiSp(spLoaiSP.getSelectedItem().toString());
                adapter_sp.notifyDataSetChanged();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void ThemDL() {
        SanPham sp = new SanPham();
        sp.setMaSP(edtMaSp.getText().toString());
        sp.setTenSp(edtTenSP.getText().toString());
        sp.setGiaSp(edtGiaSP.getText().toString());
        sp.setLoaiSp(spLoaiSP.getSelectedItem().toString());
        data_sp.add(sp);
        adapter_sp.notifyDataSetChanged();
    }

    private void KhoiTao() {
        data_lsp.add("Samsung");
        data_lsp.add("Iphone");
        data_lsp.add("Nokia");
    }

    private void setControl() {
        edtMaSp = findViewById(R.id.edtMaSp);
        edtTenSP = findViewById(R.id.edtTenSp);
        edtGiaSP = findViewById(R.id.edtGiaSp);
        spLoaiSP = findViewById(R.id.spLoaiSp);
        ivHinh = findViewById(R.id.ivHinh);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }

}
