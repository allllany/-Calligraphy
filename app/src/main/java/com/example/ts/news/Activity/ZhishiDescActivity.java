package com.example.ts.news.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ts.news.Bean.CalliBean;
import com.example.ts.news.R;
//展示每一个具体书法知识对应的activity
public class ZhishiDescActivity extends AppCompatActivity {
    TextView titleTv1,titleTv2,descTv,notTv;
    ImageView backIv,bigPicIv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhishi_desc);
        initView();
        //接收上一级页面传来的数据
        Intent intent = getIntent();
        CalliBean calliBean = (CalliBean) intent.getSerializableExtra("food");
        //设置显示控件
        titleTv1.setText(calliBean.getTitle());
        titleTv2.setText(calliBean.getTitle());
        descTv.setText(calliBean.getDesc());
        notTv.setText(calliBean.getNotmatch());
        bigPicIv.setImageResource(calliBean.getPicId());
    }

    private void initView() {
        titleTv1 = findViewById(R.id.fooddesc_tv_title);
        titleTv2 = findViewById(R.id.fooddesc_tv_title2);
        descTv = findViewById(R.id.fooddesc_tv_desc);
        notTv = findViewById(R.id.food_tv_not);
        backIv = findViewById(R.id.fooddesc_iv_back);
        bigPicIv = findViewById(R.id.fooddesc_iv_bigpic);

        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//销毁当前的activity
            }
        });
    }
}