package com.example.ts.news.Activity.Duibi_activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ts.news.R;
//智能对比对应的activity
public class DuibiActivity extends AppCompatActivity {

    //按钮控件
    public Button kaishuDuibi01;
    public Button kaishuDuibi02;
    public Button kaishuDuibi03;
    public Button kaishuDuibi04;

    public Button lishuDuibi01;
    public Button lishuDuibi02;
    public Button lishuDuibi03;
    public Button lishuDuibi04;

    public Button xingshuDuibi01;
    public Button xingshuDuibi02;
    public Button xingshuDuibi03;
    public Button xingshuDuibi04;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duibi);
        initView();
    }

    private void initView() {
        //楷书智能对比01页面跳转
        kaishuDuibi01 = findViewById(R.id.duibi_kaishu01);
        kaishuDuibi01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_kaishuActivity01.class);
                startActivity(intent);
            }
        });
        //楷书智能对比02页面跳转
        kaishuDuibi02 = findViewById(R.id.duibi_kaishu02);
        kaishuDuibi02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_kaishuActivity02.class);
                startActivity(intent);
            }
        });
        //楷书智能对比03页面跳转
        kaishuDuibi03 = findViewById(R.id.duibi_kaishu03);
        kaishuDuibi03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_kaishuActivity03.class);
                startActivity(intent);
            }
        });
        //楷书智能对比04页面跳转
        kaishuDuibi04 = findViewById(R.id.duibi_kaishu04);
        kaishuDuibi04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_kaishuActivity04.class);
                startActivity(intent);
            }
        });




        //隶书智能对比01页面跳转
        lishuDuibi01 = findViewById(R.id.duibi_lishu01);
        lishuDuibi01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_lishuActivity01.class);
                startActivity(intent);
            }
        });
        //隶书智能对比02页面跳转
        lishuDuibi02 = findViewById(R.id.duibi_lishu02);
        lishuDuibi02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_lishuActivity02.class);
                startActivity(intent);
            }
        });
        //隶书智能对比03页面跳转
        lishuDuibi03 = findViewById(R.id.duibi_lishu03);
        lishuDuibi03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_lishuActivity03.class);
                startActivity(intent);
            }
        });
        //隶书智能对比04页面跳转
        lishuDuibi04 = findViewById(R.id.duibi_lishu04);
        lishuDuibi04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_lishuActivity04.class);
                startActivity(intent);
            }
        });




        //行书智能对比01页面跳转
        xingshuDuibi01 = findViewById(R.id.duibi_xingshu01);
        xingshuDuibi01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_xingshuActivity01.class);
                startActivity(intent);
            }
        });
        //行书智能对比02页面跳转
        xingshuDuibi02 = findViewById(R.id.duibi_xingshu02);
        xingshuDuibi02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_xingshuActivity02.class);
                startActivity(intent);
            }
        });
        //行书智能对比03页面跳转
        xingshuDuibi03 = findViewById(R.id.duibi_xingshu03);
        xingshuDuibi03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_xingshuActivity03.class);
                startActivity(intent);
            }
        });
        //行书智能对比04页面跳转
        xingshuDuibi04 = findViewById(R.id.duibi_xingshu04);
        xingshuDuibi04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DuibiActivity.this, Duibi_xingshuActivity04.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.duibi_iv_back:
                finish();
                break;
        }
    }
}