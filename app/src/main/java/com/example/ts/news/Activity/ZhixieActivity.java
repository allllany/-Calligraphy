package com.example.ts.news.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ts.news.Activity.HelloARU3D.UnityPlayerActivity;
import com.example.ts.news.R;
//智能书写对应的activity
public class ZhixieActivity extends AppCompatActivity {
    public Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhixie);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ZhixieActivity.this, UnityPlayerActivity.class);
                startActivity(intent);
            }
        });

    }
}