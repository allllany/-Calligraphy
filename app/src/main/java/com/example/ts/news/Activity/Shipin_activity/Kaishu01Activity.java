package com.example.ts.news.Activity.Shipin_activity;

import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.ts.news.R;

public class Kaishu01Activity extends AppCompatActivity {
    private VideoView videoView;
    private Button btn_start,btn_end;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaishu01);
        initView();

    }

    private void initView() {
        videoView= (VideoView) findViewById(R.id.kaishu01);
        btn_start= (Button) findViewById(R.id.btn_start);
        btn_end= (Button) findViewById(R.id.btn_end);


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
            }
        });
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
    }

    private void init() {
        videoView = (VideoView) findViewById(R.id.kaishu01);
        mediaController = new MediaController(this);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.kaishu01;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.kaishu01_iv_back:
                finish();
                break;
        }
    }

}