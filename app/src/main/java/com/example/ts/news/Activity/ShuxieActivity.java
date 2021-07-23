package com.example.ts.news.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ts.news.Activity.Duibi_activity.DuibiActivity;
import com.example.ts.news.Activity.Duibi_activity.Duibi_kaishuActivity01;
import com.example.ts.news.R;
//智能识别对应的activity
public class ShuxieActivity extends AppCompatActivity {
    public Button button_shuxie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shibie);
        initview();
    }
    private void initview(){
        button_shuxie = findViewById(R.id.zhineng_shuxie);
        button_shuxie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ShuxieActivity.this, Duibi_kaishuActivity01.class);
                startActivity(intent);
            }
        });
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.shibie_iv_back:
                finish();
                break;
        }
    }
}