package com.example.ts.news.Activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.ts.news.Adapter.ZhishiAdapter;
import com.example.ts.news.Bean.CalliBean;
import com.example.ts.news.Utils.CalliUtils;
import com.example.ts.news.R;

import java.util.ArrayList;
import java.util.List;
//书法知识对应的activity

//让整个Activity实现OnClickListener接口
public class ZhishiActivity extends AppCompatActivity implements View.OnClickListener {
    EditText searchEt;
    ImageView searchIv,flushIv;
    ListView showLv;

    //ListView内部数据源
    List<CalliBean> mDatas;
    List<CalliBean> allFoodList;
    private ZhishiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhishi);

        //1.查找控件
        initView();
        //2.找到ListView对应的数据源
        mDatas = new ArrayList<>();
        allFoodList = CalliUtils.getAllFooList();
        mDatas.addAll(allFoodList);
        //3.创建适配器 BaseAdapter的子类
        adapter = new ZhishiAdapter(this,mDatas);
        //4.设置适配器
        showLv.setAdapter(adapter);
        //设置单项点击监听事件
        setListener();
    }

    private void setListener() {
        showLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CalliBean calliBean = mDatas.get(position);
                Intent intent = new Intent(ZhishiActivity.this, ZhishiDescActivity.class);
                intent.putExtra("food", calliBean);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        searchEt = findViewById(R.id.info_et_search);
        searchIv = findViewById(R.id.info_iv_search);
        flushIv = findViewById(R.id.info_iv_flush);
        showLv = findViewById(R.id.infolist_lv);
        searchIv.setOnClickListener(this);//添加搜索点击事件监听
        flushIv.setOnClickListener(this);//添加刷新点击事件监听
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.info_iv_flush://刷新点击
                searchEt.setText("   ");
                mDatas.clear();
                mDatas.addAll(allFoodList);
                adapter.notifyDataSetChanged();
                break;
            case R.id.info_iv_search://搜索点击
                //1.获取输入内容，判断不为空=
                String msg = searchEt.getText().toString().trim();//获取输入信息
                if (TextUtils.isEmpty(msg)) {//是空则不搜索
                    Toast.makeText(this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //2.判断所有食物列表的标题是否包含输入内容，如果包含，就添加到小集合中
                List<CalliBean> list = new ArrayList<>();
                for (int i = 0; i < allFoodList.size() ; i++) {
                    String title = allFoodList.get(i).getTitle();
                    if (title.contains(msg)) {
                        list.add(allFoodList.get(i));
                    }
                }
                mDatas.clear();//清空listview的适配器数据源内容
                mDatas.addAll(list);//添加新的数据源
                adapter.notifyDataSetChanged();//提示适配器更新
                break;
            case R.id.zhishi_iv_back:
                finish();
                break;
        }
    }
}
