package com.example.ts.news.Activity.Duibi_activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ts.news.R;
import com.example.ts.news.Utils.BitmapUtils;
import com.example.ts.news.Utils.FCompareUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Duibi_lishuActivity04 extends AppCompatActivity {

    private ImageView lishu04_add;
    private Button startCompare;
    //    final int random = new Random().nextInt((max - min) + 1) + min;
    final int random = new Random().nextInt((96-85) + 1) + 40;
    private double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duibi_lishu04);
        initview();
    }
    public void initview() {

        lishu04_add = findViewById(R.id.addPic);
        lishu04_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   //添加本地图片发表
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image/*");
                startActivityForResult(intent, 2);
            }
        });

        startCompare  = findViewById(R.id.startCompare);

        startCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (lishu04_add.getDrawable().getCurrent().
                        getConstantState()==getResources().
                        getDrawable(R.drawable.add).getConstantState()){
                    Toast.makeText(getApplicationContext(),"请先上传照片！", Toast.LENGTH_LONG).show();

                }else{
                    //实现延时功能 在进度条显示完6s后再显示对话框信息
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            /**
                             * 延时执行的代码
                             */
                            //再显示对话框
                            showDialog();
                        }
                    },6000); // 延时6秒

                    //先显示进度条
                    showProgressDialog();
                }
            }
        });

    }

    //获得图片显示在imageview
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if (requestCode == 2 && resultCode == RESULT_OK) {
            if (data != null) {
                Bitmap bitmap = ImageSizeCompress(data.getData());
                lishu04_add.setImageBitmap(bitmap);


                Bitmap bitmap1 = BitmapUtils.decodeSampledBitmapFromResource(getResources(),
                        R.drawable.lishu_duibi04,
                        lishu04_add.getWidth(),
                        lishu04_add.getHeight());


                result = FCompareUtil.HashCompare(bitmap1,bitmap);
                //result = CompareUtils.CompareTwoPic(bitmap1,bitmap);



                //result = CompareUtils.CompareTwoPic(bitmap1,bitmap2);
                result *= 100;

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //uri转bitmap
    private Bitmap ImageSizeCompress(Uri uri){
        InputStream Stream = null;
        InputStream inputStream = null;
        try {
            //根据uri获取图片的流
            inputStream = getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            //options的in系列的设置了，injustdecodebouond只解析图片的大小，而不加载到内存中去
            options.inJustDecodeBounds = true;
            //1.如果通过options.outHeight获取图片的宽高，就必须通过decodestream解析同options赋值
            //否则options.outheight获取不到宽高
            BitmapFactory.decodeStream(inputStream,null,options);
            //2.通过 btm.getHeight()获取图片的宽高就不需要1的解析，我这里采取第一张方式
//            Bitmap btm = BitmapFactory.decodeStream(inputStream);
            //以屏幕的宽高进行压缩
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int heightPixels = displayMetrics.heightPixels;
            int widthPixels = displayMetrics.widthPixels;
            //获取图片的宽高
            int outHeight = options.outHeight;
            int outWidth = options.outWidth;
            //heightPixels就是要压缩后的图片高度，宽度也一样
            int a = (int) Math.ceil((outHeight/(float)heightPixels));
            int b = (int) Math.ceil(outWidth/(float)widthPixels);
            //比例计算,一般是图片比较大的情况下进行压缩
            int max = Math.max(a, b);
            if(max > 1){
                options.inSampleSize = max;
            }
            //解析到内存中去
            options.inJustDecodeBounds = false;
//            根据uri重新获取流，inputstream在解析中发生改变了
            Stream = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(Stream, null, options);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
                if(Stream != null){
                    Stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return  null;
    }

    //显示进度条函数
    public void showProgressDialog(){
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setTitle("请稍等");
        pDialog.setIcon(R.drawable.assure);
        pDialog.setMessage("系统正在对比分析...");
        pDialog.setCancelable(false);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pDialog.show();


        // 呈现6s
        new Thread(new Runnable() {

            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                int progress = 0;

                while (System.currentTimeMillis() - startTime < 6000) {
                    try {
                        progress += 10;
                        pDialog.setProgress(progress);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        pDialog.dismiss();
                    }
                }

                pDialog.dismiss();

            }

        }).start();


    }

    //显示对话框函数
    public void showDialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.assure);
        builder.setTitle("智能对比结果：");
        builder.setMessage("您所写的字和原帖的相似度为"+result+"% !\n再接再厉，加油！");
        builder.setPositiveButton("确认",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.duibi_lishu04_iv_back:
                finish();
                break;
        }
    }
}