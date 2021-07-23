package com.example.ts.news.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;



import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ts.news.Fragment.MainFragment;
import com.example.ts.news.Fragment.MainFragment1;
import com.example.ts.news.Fragment.MineFragment;
import com.example.ts.news.Fragment.SettingFragment;
import com.example.ts.news.Fragment.TestFragment;
import com.example.ts.news.R;
import com.example.ts.news.Utils.ApplicationUtil;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;

import java.util.ArrayList;
import java.util.List;
//MainActivity
public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    private LinearLayout ll_main, ll_setting, ll_mine;

//    private MainFragment mainFragment;//主页
    private MainFragment1 mainFragment1;//设置的新的主页
    private SettingFragment settingFragment;//设置
    private MineFragment mineFragment;//我的

    private List<Fragment> fragmentList = new ArrayList<>();

    private ImageView img_main, img_seting, img_mine;
    private TextView text_main, text_setting, text_mine;

    /**
     * opencv初始化
     */
    @Override
    //想要opencv不依赖opencvmanager,关键就在这里，除了基本的把文件复制到项目中外，
    // onResume函数必须写成以下形式，这样才能调用到复制过来的包文件
    public void onResume()
    {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            //Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0, this, mLoaderCallback);
        } else {
            //Log.d(TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
        //super.onResume();
        //OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_9, this, mLoaderCallback);
    }
//    static {
//        OpenCVLoader.initDebug();
//    }


    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS: {
                    Log.i("rr", "OpenCV loaded successfully");
                }
                break;
                default: {
                    super.onManagerConnected(status);
                }
                break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();

        ll_main.setOnClickListener(this);
        ll_setting.setOnClickListener(this);
        ll_mine.setOnClickListener(this);

        ApplicationUtil.getInstance().addActivity(this);
    }

    private void initView() {
        ll_main = (LinearLayout) findViewById(R.id.layout_main);
        ll_setting = (LinearLayout)findViewById(R.id.layout_setting);
        ll_mine = (LinearLayout)findViewById(R.id.layout_mine);

        text_main = (TextView) findViewById(R.id.text_main);
        text_setting = (TextView) findViewById(R.id.text_setting);
        text_mine = (TextView) findViewById(R.id.text_mine);

        img_main = (ImageView) findViewById(R.id.img_main);
        img_seting =(ImageView) findViewById(R.id.img_setting);
        img_mine =(ImageView) findViewById(R.id.img_mine);

        img_main.setImageResource(R.drawable.main_selected);
        text_main.setTextColor(Color.RED);

    }

    private void initFragment() {
        mainFragment1 = new MainFragment1();
        addFragment(mainFragment1);
        showFragment(mainFragment1);

    }

    /*添加fragment*/
    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.add(R.id.main_content, fragment).commit();
            fragmentList.add(fragment);
        }
    }

    /*显示fragment*/
    private void showFragment(Fragment fragment) {
        for (Fragment frag : fragmentList) {
            if (frag != fragment) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.hide(frag).commit();
            }
        }
        //benginTransatcion()开启一个事务
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.show(fragment).commit();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_main: {
                 //加载mainFragment
                if (mainFragment1 == null) {
                    mainFragment1 = new MainFragment1();
                }
                addFragment(mainFragment1);
                showFragment(mainFragment1);


                text_main.setTextColor(Color.RED);
                text_setting.setTextColor(Color.BLACK);
                text_mine.setTextColor(Color.BLACK);

                img_main.setImageResource(R.drawable.main_selected);
                img_seting.setImageResource(R.drawable.setting);
                img_mine.setImageResource(R.drawable.mine);

            }
            break;
            case R.id.layout_setting: {
                //加载settingFragment
                if (settingFragment == null) {
                    settingFragment = new SettingFragment();
                }
                addFragment(settingFragment);
                showFragment(settingFragment);
                text_setting.setTextColor(Color.RED);
                text_main.setTextColor(Color.BLACK);
                text_mine.setTextColor(Color.BLACK);

                img_main.setImageResource(R.drawable.main);
                img_seting.setImageResource(R.drawable.setting_selected);
                img_mine.setImageResource(R.drawable.mine);
            }
            break;
            case R.id.layout_mine: {
                //加载mineFragment
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
                addFragment(mineFragment);
                showFragment(mineFragment);
                text_mine.setTextColor(Color.RED);
                text_main.setTextColor(Color.BLACK);
                text_setting.setTextColor(Color.BLACK);

                img_main.setImageResource(R.drawable.main);
                img_seting.setImageResource(R.drawable.setting);
                img_mine.setImageResource(R.drawable.mine_selected);
            }
            break;
            default:
                break;
        }
    }
}
