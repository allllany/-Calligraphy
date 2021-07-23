package com.example.ts.news.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import androidx.annotation.RequiresApi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ts.news.R;
import com.example.ts.news.Utils.AlbumUtil;
import com.example.ts.news.Utils.ApplicationUtil;
import com.example.ts.news.Utils.MyDatabaseHelper;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.pedant.SweetAlert.SweetAlertDialog;

//注册界面对应的activity
//使用SQLite数据库存储技术
public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "verify password in RegisterActivity";
    private MyDatabaseHelper dbHelper;

    private ImageView imgBack;
    private TextView save_user;
    private ImageView shangchuan_head;
    private EditText username, userpassword, repassword;
    private CheckBox checkBox;

    private static final int CHOSSE_PHOTO = 1;

    @SuppressLint("LongLogTag")
    public boolean isPassword(String password){
        String regex="^(?![0-9])(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        Pattern p=Pattern.compile(regex);
        Matcher m=p.matcher(password);
        boolean isMatch=m.matches();
        Log.i(TAG, "isPassword: 是否密码正则匹配"+isMatch);
        return isMatch;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new MyDatabaseHelper(this, "UserDB.db", null, 1);

        imgBack = (ImageView)findViewById(R.id.img_back);
        save_user =(TextView) findViewById(R.id.save_user);
        shangchuan_head =(ImageView) findViewById(R.id.shangchuan_head);

        username =(EditText) findViewById(R.id.register_username);
        userpassword =(EditText) findViewById(R.id.register_password);
        repassword =(EditText) findViewById(R.id.register_repassword);
        checkBox =(CheckBox) findViewById(R.id.checkbox_tiaokuan);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginOrRegisterActivity.class);
                startActivity(intent);
            }
        });

        shangchuan_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(RegisterActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(RegisterActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                } else {
                    openAlbum();
                }
            }
        });

        save_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkBox.isChecked()){
                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    String username_str = username.getText().toString();
                    String userpassword_str = userpassword.getText().toString();
                    String repassword_str = repassword.getText().toString();

                   //密码验证
                    boolean verify = isPassword(userpassword_str);
                    if (!verify){
                        //Toast.makeText(RegisterActivity.this, "密码过于简单，请重新输入密码！", Toast.LENGTH_SHORT).show();
//                        SweetAlertDialog pDialog = new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.PROGRESS_TYPE);
//                        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//                        pDialog.setTitleText("Loading");
//                        pDialog.setCancelable(false);
//                        pDialog.show();
                        new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("密码过于简单！")
                                .setContentText("不能只有数字或字母，字母开头")
                                .show();

                    }
                    else{
                        if (userpassword_str.equals(repassword_str)) {
                            ContentValues values = new ContentValues();
                            //组装数据
                            values.put("name", username_str);
                            values.put("password", userpassword_str);

                            db.insert("User", null, values);

                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            //Toast.makeText(RegisterActivity.this, "两次密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                            new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("两次密码不一致!")
                                    .setContentText("请重新输入!")
                                    .show();
                        }
                        db.close();
                    }


                }else {
                    //Toast.makeText(RegisterActivity.this, "请勾选同意使用条款", Toast.LENGTH_SHORT).show();
                    new SweetAlertDialog(RegisterActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("请勾选同意使用条款")
                            .show();
                }

            }
        });



        ApplicationUtil.getInstance().addActivity(this);
    }
    //上传头像功能，运行时权限要使用相册
    //若用户选择不上传，则程序会默认使用一个图片作为头像
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, CHOSSE_PHOTO);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CHOSSE_PHOTO:
                if (resultCode == -1) {
                    String imgPath = AlbumUtil.handleImageOnKitKat(this, data);
                    setHead(imgPath);
                }
                break;
            default:
                break;
        }
    }
    private void setHead(String imgPath) {
        if (imgPath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
            Bitmap round = AlbumUtil.toRoundBitmap(bitmap);
            try {
                String path = getCacheDir().getPath();
                File file = new File(path,"user_head");
                round.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            shangchuan_head.setImageBitmap(round);
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }
}
