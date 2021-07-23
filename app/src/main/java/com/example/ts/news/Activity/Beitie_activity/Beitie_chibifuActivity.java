package com.example.ts.news.Activity.Beitie_activity;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.ts.news.Adapter.Beitie_adapter.Beitie_chibifuAdapter;
import com.example.ts.news.Adapter.Beitie_adapter.Beitie_jiuchenggongAdapter;
import com.example.ts.news.R;

import java.util.ArrayList;
import java.util.List;

public class Beitie_chibifuActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList arrayList;
    private View view1,view2,view3,view4,view5,view6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beitie_chibifu);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        LayoutInflater layoutInflater = getLayoutInflater();
        view1 = layoutInflater.inflate(R.layout.chibifu_layout1,null);
        view2 = layoutInflater.inflate(R.layout.chibifu_layout2,null);
        view3 = layoutInflater.inflate(R.layout.chibifu_layout3,null);
        view4 = layoutInflater.inflate(R.layout.chibifu_layout4,null);
        view5 = layoutInflater.inflate(R.layout.chibifu_layout5,null);
        view6 = layoutInflater.inflate(R.layout.chibifu_layout6,null);
        List<View> viewList = new ArrayList<View>();
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);
        viewList.add(view5);
        viewList.add(view6);
        Beitie_chibifuAdapter myPagerAdapter = new Beitie_chibifuAdapter(viewList);
        viewPager.setAdapter(myPagerAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.chibifu_iv_back:
                finish();
                break;
        }
    }
}