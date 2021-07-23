package com.example.ts.news.Activity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.ts.news.R;

//碑帖临摹对应的activity
public class BeitieActivity extends AppCompatActivity implements View.OnClickListener {
    //按钮控件
    public Button caoquanbei;
    public Button liqibei;
    public Button yiyingbei;
    public Button zhangqianbei;
    public Button huangtingjing;
    public Button leyilun;
    public Button luoshenfu;
    public Button xuanshibiao;
    public Button jiuchenggong;
    public Button duobaota;
    public Button xuanmita;
    public Button lingfeijing;
    public Button chibifu;
    public Button hanshitie;
    public Button shusutie;
    public Button nongfangshi;
    public Button danbabei;
    public Button fushenguan;
    public Button jianzhuan;
    public Button qianziwen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beitie);
        initView();
    }

    private void initView() {
        //曹全碑页面跳转
        caoquanbei = findViewById(R.id.beitie_caoquanbei);
        caoquanbei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_caoquanbeiActivity.class);
                startActivity(intent);
            }
        });
        //礼器碑页面跳转
        liqibei = findViewById(R.id.beitie_liqibei);
        liqibei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_liqibeiActivity.class);
                startActivity(intent);
            }
        });
        //乙瑛碑页面跳转
        yiyingbei = findViewById(R.id.beitie_yiyingbei);
        yiyingbei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_yiyingbeiActivity.class);
                startActivity(intent);
            }
        });
        //张迁碑页面跳转
        zhangqianbei = findViewById(R.id.beitie_zhangqianbei);
        zhangqianbei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_zhangqianbeiActivity.class);
                startActivity(intent);
            }
        });
        //黄庭经页面跳转
        huangtingjing = findViewById(R.id.beitie_huangtingjing);
        huangtingjing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_huangtingjingActivity.class);
                startActivity(intent);
            }
        });
        //乐毅论页面跳转
        leyilun = findViewById(R.id.beitie_leyilun);
        leyilun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_leyilunActivity.class);
                startActivity(intent);
            }
        });
        //洛神赋页面跳转
        luoshenfu = findViewById(R.id.beitie_luoshenfu);
        luoshenfu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_luoshenfuActivity.class);
                startActivity(intent);
            }
        });
        //宣示表页面跳转
        xuanshibiao = findViewById(R.id.beitie_xuanshibiao);
        xuanshibiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_xuanshibiaoActivity.class);
                startActivity(intent);
            }
        });
        //九成宫碑帖页面跳转
        jiuchenggong = findViewById(R.id.beitie_jiuchenggong);
        jiuchenggong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_jiuchenggongActivity.class);
                startActivity(intent);
            }
        });
        //多宝塔碑页面跳转
        duobaota = findViewById(R.id.beitie_duobaota);
        duobaota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_duobaotaActivity.class);
                startActivity(intent);
            }
        });
        //玄秘塔碑页面跳转
        xuanmita = findViewById(R.id.beitie_xuanmita);
        xuanmita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_xuanmitaActivity.class);
                startActivity(intent);
            }
        });
        //灵飞经页面跳转
        lingfeijing = findViewById(R.id.beitie_lingfeijing);
        lingfeijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_lingfeijingActivity.class);
                startActivity(intent);
            }
        });
        //赤壁赋页面跳转
        chibifu = findViewById(R.id.beitie_chibifu);
        chibifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_chibifuActivity.class);
                startActivity(intent);
            }
        });
        //寒食帖页面跳转
        hanshitie = findViewById(R.id.beitie_hanshitie);
        hanshitie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_hanshitieActivity.class);
                startActivity(intent);
            }
        });
        //蜀素帖页面跳转
        shusutie = findViewById(R.id.beitie_shusutie);
        shusutie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_shusutieActivity.class);
                startActivity(intent);
            }
        });
        //秾芳诗帖页面跳转
        nongfangshi = findViewById(R.id.beitie_nongfangshi);
        nongfangshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_nongfangshiActivity.class);
                startActivity(intent);
            }
        });
        //胆巴碑页面跳转
        danbabei = findViewById(R.id.beitie_danbabei);
        danbabei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_danbabeiActivity.class);
                startActivity(intent);
            }
        });
        //福神观记页面跳转
        fushenguan = findViewById(R.id.beitie_fushenguan);
        fushenguan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_fushenguanActivity.class);
                startActivity(intent);
            }
        });
        //汲黯传页面跳转
        jianzhuan = findViewById(R.id.beitie_jianzhuan);
        jianzhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_jianzhuanActivity.class);
                startActivity(intent);
            }
        });
        //千字文页面跳转
        qianziwen = findViewById(R.id.beitie_qianziwen);
        qianziwen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BeitieActivity.this, Beitie_qianziwenActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.beitie_iv_back:
                finish();
                break;
        }
    }
}