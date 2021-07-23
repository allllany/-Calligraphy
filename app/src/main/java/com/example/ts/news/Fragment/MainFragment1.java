package com.example.ts.news.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ts.news.Activity.BeitieActivity;
import com.example.ts.news.Activity.Duibi_activity.DuibiActivity;
import com.example.ts.news.Activity.JiaoxueActivity;
import com.example.ts.news.Activity.ShuxieActivity;
import com.example.ts.news.Activity.ZhishiActivity;
import com.example.ts.news.Activity.ZhixieActivity;
import com.example.ts.news.R;

/**
 * Created by ts on 18-8-20.
 */
//功能板块主页面对应的MainFragment
public class MainFragment1 extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment1_main, container, false);

        //书法知识板块对应的监听事件
        TextView text1=(TextView)view.findViewById(R.id.main_tv_zhishi);
        //设置监听
        text1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //ZhishiActivity.class为想要跳转的Activity
                intent.setClass(getActivity(), ZhishiActivity.class);
                startActivity(intent);
            }
        });

        //碑帖临摹板块对应的监听事件
        TextView text2=(TextView)view.findViewById(R.id.main_tv_beitie);
        //设置监听
        text2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //BeitieActivity.class为想要跳转的Activity
                intent.setClass(getActivity(), BeitieActivity.class);
                startActivity(intent);
            }
        });

        //书法教学板块对应的监听事件
        TextView text3=(TextView)view.findViewById(R.id.main_tv_jiaoxue);
        //设置监听
        text3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //JiaoxueActivity.class为想要跳转的Activity
                intent.setClass(getActivity(), JiaoxueActivity.class);
                startActivity(intent);
            }
        });

        //书法字典板块对应的监听事件
        TextView text4=(TextView)view.findViewById(R.id.main_tv_zidian);
        //设置监听
        text4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("http://www.shufazidian.com/");
                intent.setData(content_url);
                startActivity(intent);
            }
        });

        //智能对比板块对应的监听事件
        TextView text5=(TextView)view.findViewById(R.id.main_tv_duibi);
        //设置监听
        text5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //DuibiActivity.class为想要跳转的Activity
                intent.setClass(getActivity(), DuibiActivity.class);
                startActivity(intent);
            }
        });

        //智能书写板块对应的监听事件
        TextView text6=(TextView)view.findViewById(R.id.main_tv_shuxie);
        //设置监听
        text6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //DuibiActivity.class为想要跳转的Activity
                intent.setClass(getActivity(), ZhixieActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }
}

