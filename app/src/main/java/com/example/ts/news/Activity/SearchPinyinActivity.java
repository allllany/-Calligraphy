package com.example.ts.news.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.GridView;

import com.example.ts.news.Adapter.SearchLeftAdapter;
import com.example.ts.news.Bean.PinBuBean;
import com.example.ts.news.R;
import com.example.ts.news.Utils.AssetsUtils;
import com.example.ts.news.Utils.CommonUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
//拼音查询对应的activity（无用）
public class SearchPinyinActivity extends AppCompatActivity {
    SearchLeftAdapter adapter;
    ExpandableListView exLv;
    GridView Gv;
    List<String> groupDatas;//表示分组的列表 [A B C D E F]
    List<List<PinBuBean.ResultBean>> childDatas;//将对应的子类i列表存放到这个集合
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pinyin);
        exLv = findViewById(R.id.searchpy_elv);
        Gv = findViewById(R.id.searchpy_gv);
        initData(CommonUtils.FILE_PINYIN,CommonUtils.TYPE_PINYIN);
//        initData(CommonUtils.FILE_BUSHOU,CommonUtils.TYPE_BUSHOU);
    }

    /**
     * 加载数据,读取assets文件夹当中的数据，使用Gson解析将数据存储到二维列表当中
     * @param assetsName 文件名称
     * @param type 文件类型 pinyin:0 bushou:1
     */
    public void initData(String assetsName,int type) {
        groupDatas = new ArrayList<>();
        childDatas = new ArrayList<>();
        String json = AssetsUtils.getAssetsContent(this,assetsName);
        if(!TextUtils.isEmpty(json)){
            PinBuBean pinBuBean = new Gson().fromJson(json, PinBuBean.class);
            List<PinBuBean.ResultBean> list = pinBuBean.getResult();
            //整理数据，一组数据
            List<PinBuBean.ResultBean> grouplist = new ArrayList<>();//声明每组包含的元素集合
            for(int i=0;i<list.size();i++){
                PinBuBean.ResultBean bean = list.get(i);//id pinyin_key pinyin
                if(type==CommonUtils.TYPE_PINYIN){
                    String pinyin_key = bean.getPinyin_key();//获取大写字母
                    if(!groupDatas.contains(pinyin_key)){//判断是否存在于分母的列表中，不存在则添加
                        groupDatas.add(pinyin_key);
                        //说明上一个拼音的已经全部录入完成grouplist当中了，可以将上一个拼音的集合添加到childDatas
                        if(grouplist.size()>0){
                            childDatas.add(grouplist);
                        }
                        //既然是新的一组，就要创建一个对应的子列表
                        grouplist = new ArrayList<>();
                        grouplist.add(bean);
                    }else{
                        grouplist.add(bean);//大写字母存在，说明还在当前这组当中，可以直接添加
                    }
                }else if(type==CommonUtils.TYPE_BUSHOU){
                    String bihua = bean.getBihua();
                    if(!grouplist.contains(bihua)){
                        groupDatas.add(bihua);
                        //新的一组，把上一组进行添加
                        if(grouplist.size()>0){
                            childDatas.add(grouplist);
                        }
                        //新的一组，新创建子列表
                        grouplist = new ArrayList<>();
                        grouplist.add(bean);
                    }else{
                        grouplist.add(bean);//当前笔画存在，就不用向组中添加了
                    }
                }
            }
            //循环结束之后，最后一组并没有添加进去，需要手动添加
            childDatas.add(grouplist);

            adapter = new SearchLeftAdapter(this, groupDatas, childDatas, type);
            exLv.setAdapter(adapter);
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.search_iv_back:
                finish();
                break;
        }
    }
}