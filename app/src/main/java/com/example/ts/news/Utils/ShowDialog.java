package com.example.ts.news.Utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.ts.news.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ShowDialog {
    // 只显示标题
    public void show1(Context context) {
        new SweetAlertDialog(context)
                .setTitleText("我是标题")
                .show();
    }
    // 同时显示标题和内容
    public void show2(Context context) {
        new SweetAlertDialog(context)
                .setTitleText("我是标题")
                .setContentText("小姐姐你好，有看见过我的小熊吗?")
                .show();
    }
    // 异常情况样式
    public void show3(Context context) {
        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText("Something went wrong!")
                .show();
    }
    // 显示警告
    public void show4(Context context) {
        new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .show();
    }
    // 成功完成
    public void show5(Context context) {
        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good job!")
                .setContentText("You clicked the button!")
                .show();
    }
//    // 自定义图标Icon
//    public void show6(Context context) {
//        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
//                .setTitleText("Sweet!")
//                .setContentText("Here's a custom image.")
//                .setCustomImage(R.drawable.ic_launcher)
//                .show();
//    }
//    // 警告 + 确定按钮 + 确定点击监听
//    public void show7(Context context) {
//        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
//                .setTitleText("Are you sure?")
//                .setContentText("Won't be able to recover this file!")
//                .setConfirmText("Yes,delete it!")
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        Toast.makeText(DialogActivity.this, "删除成功！", Toast.LENGTH_SHORT).show();
//                        sDialog.dismissWithAnimation();
//                    }
//                })
//                .show();
//    }
//    // 警告 + 取消 + 取消监听 + 确定 + 确定监听
//    public void show8(Context context) {
//        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
//                .setTitleText("Are you sure?")
//                .setContentText("Won't be able to recover this file!")
//                .setCancelText("No,cancel plx!")
//                .setConfirmText("Yes,delete it!")
//                .showCancelButton(true)
//                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        Toast.makeText(DialogActivity.this, "已取消！", Toast.LENGTH_SHORT).show();
//                        sDialog.cancel();
//                    }
//                })
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        Toast.makeText(DialogActivity.this, "删除成功！", Toast.LENGTH_SHORT).show();
//                        sDialog.dismissWithAnimation();
//                    }
//                })
//                .show();
//    }
//    // 在确认监听中显示成功对话框
//    public void show9(Context context){
//        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
//                .setTitleText("Are you sure?")
//                .setContentText("Won't be able to recover this file!")
//                .setConfirmText("Yes,delete it!")
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        sDialog
//                                .setTitleText("Deleted!")
//                                .setContentText("Your imaginary file has been deleted!")
//                                .setConfirmText("OK")
//                                .setConfirmClickListener(null)
//                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
//                        // or you can new a SweetAlertDialog to show
//                               /* sDialog.dismiss();
//                                new SweetAlertDialog(SampleActivity.this, SweetAlertDialog.ERROR_TYPE)
//                                        .setTitleText("Cancelled!")
//                                        .setContentText("Your imaginary file is safe :)")
//                                        .setConfirmText("OK")
//                                        .show();*/
//                    }
//                })
//                .show();
//    }



}
