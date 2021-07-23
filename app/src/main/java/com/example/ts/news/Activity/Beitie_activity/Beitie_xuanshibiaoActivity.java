package com.example.ts.news.Activity.Beitie_activity;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.ts.news.Adapter.Beitie_adapter.Beitie_jiuchenggongAdapter;
import com.example.ts.news.Adapter.Beitie_adapter.Beitie_xuanshibiaoAdapter;
import com.example.ts.news.R;

import java.util.ArrayList;
import java.util.List;

public class Beitie_xuanshibiaoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList arrayList;
    private View view1,view2,view3,view4,view5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beitie_xuanshibiao);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        LayoutInflater layoutInflater = getLayoutInflater();
        view1 = layoutInflater.inflate(R.layout.xuanshibiao_layout1,null);
        view2 = layoutInflater.inflate(R.layout.xuanshibiao_layout2,null);
        view3 = layoutInflater.inflate(R.layout.xuanshibiao_layout3,null);
        view4 = layoutInflater.inflate(R.layout.xuanshibiao_layout4,null);
        view5 = layoutInflater.inflate(R.layout.xuanshibiao_layout5,null);
        List<View> viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        viewList.add(view5);
        Beitie_xuanshibiaoAdapter myPagerAdapter = new Beitie_xuanshibiaoAdapter(viewList);
        viewPager.setAdapter(myPagerAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jiuchenggong_iv_back:
                finish();
                break;
        }
    }
}