package com.example.ts.news.Activity;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ts.news.Activity.Beitie_activity.Beitie_caoquanbeiActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_chibifuActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_danbabeiActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_duobaotaActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_fushenguanActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_hanshitieActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_huangtingjingActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_jianzhuanActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_jiuchenggongActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_leyilunActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_lingfeijingActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_liqibeiActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_luoshenfuActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_nongfangshiActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_qianziwenActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_shusutieActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_xuanmitaActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_xuanshibiaoActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_yiyingbeiActivity;
import com.example.ts.news.Activity.Beitie_activity.Beitie_zhangqianbeiActivity;
import com.example.ts.news.Activity.Shipin_activity.Kaishu01Activity;
import com.example.ts.news.Activity.Shipin_activity.Kaishu02Activity;
import com.example.ts.news.Activity.Shipin_activity.Lishu01Activity;
import com.example.ts.news.Activity.Shipin_activity.Lishu02Activity;
import com.example.ts.news.Activity.Shipin_activity.Xingshu01Activity;
import com.example.ts.news.Activity.Shipin_activity.Xingshu02Activity;
import com.example.ts.news.R;
//书法教学对应的activity
public class JiaoxueActivity extends AppCompatActivity {
    //按钮控件
    public Button luzhongnan;
    public Button tianyingzhang01;
    public Button zhangji;
    public Button zhangzhanli;
    public Button zhangxuguang;
    public Button tianyingzhang02;
    public Button shufa01;
    public Button shufa02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiaoxue);
        initView();
    }

    private void initView() {
        //卢中南楷书页面跳转
        luzhongnan = findViewById(R.id.jiaoxue_luzhongnan);
        luzhongnan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JiaoxueActivity.this, Kaishu01Activity.class);
                startActivity(intent);
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.VIEW");
//                Uri content_url = Uri.parse("https://www.bilibili.com/video/BV1bb411x7L6");
//                intent.setData(content_url);
//                startActivity(intent);
            }
        });
        //田英章楷书页面跳转
        tianyingzhang01 = findViewById(R.id.jiaoxue_tianyingzhang01);
        tianyingzhang01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JiaoxueActivity.this, Kaishu02Activity.class);
                startActivity(intent);
            }
        });
        //张继隶书页面跳转
        zhangji = findViewById(R.id.jiaoxue_zhangji);
        zhangji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JiaoxueActivity.this, Lishu01Activity.class);
                startActivity(intent);
            }
        });
        //张站立隶书页面跳转(lishu02)
        zhangzhanli = findViewById(R.id.jiaoxue_zhangzhanli);
        zhangzhanli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JiaoxueActivity.this, Lishu02Activity.class);
                startActivity(intent);
            }
        });
        //张旭光行书页面跳转
        zhangxuguang = findViewById(R.id.jiaoxue_zhangxuguang);
        zhangxuguang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JiaoxueActivity.this, Xingshu01Activity.class);
                startActivity(intent);
            }
        });
        //田英章行书页面跳转
        tianyingzhang02 = findViewById(R.id.jiaoxue_tianyingzhang02);
        tianyingzhang02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JiaoxueActivity.this, Xingshu02Activity.class);
                startActivity(intent);
            }
        });
        //书法五千年页面跳转
//        shufa01 = findViewById(R.id.jiaoxue_shufa01);
//        shufa01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.VIEW");
//                Uri content_url = Uri.parse("https://www.bilibili.com/video/BV1Fx411n7rj");
//                intent.setData(content_url);
//                startActivity(intent);
//            }
//        });
        //千年书法页面跳转
//        shufa02 = findViewById(R.id.jiaoxue_shufa02);
//        shufa02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                intent.setAction("android.intent.action.VIEW");
//                Uri content_url = Uri.parse("https://www.bilibili.com/video/BV14s411R7sb");
//                intent.setData(content_url);
//                startActivity(intent);
//            }
//        });
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jiaoxue_iv_back:
                finish();
                break;
        }
    }
}