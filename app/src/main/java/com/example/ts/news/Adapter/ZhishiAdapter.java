package com.example.ts.news.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ts.news.Bean.CalliBean;
import com.example.ts.news.R;

import java.util.List;

//书法知识对应的adapter
public class ZhishiAdapter extends BaseAdapter {
    Context context;
    List<CalliBean> mDatas;

    public ZhishiAdapter(Context context, List<CalliBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }
    //决定了ListView列表展示的行数
    @Override
    public int getCount() {
        return mDatas.size();
    }
    //返回指定位置对应的数据
    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }
    //返回指定位置所对应的id
    @Override
    public long getItemId(int position) {
        return position;
    }
    //返回指定位置所对应的view
    //将已经滑动出去的列表项复用优化
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        //对包含了控件的类进行声明
        ViewHolder holder = null;
        if (convertView == null){//第一次创建，没有复用的
            //将布局转化为view对象
            convertView = LayoutInflater.from(context).inflate(R.layout.item_infolist_lv,null);
            //初始化holder
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{//如果内存已经有滑动出去的ListView
            holder = (ViewHolder)convertView.getTag();
        }
        //加载控件当中的显示
        //获取集合指定位置的数据
        CalliBean calliBean = mDatas.get(i);
        holder.titleTv.setText(calliBean.getTitle());
        holder.notTv.setText("关键词："+ calliBean.getNotmatch());
        holder.iv.setImageResource(calliBean.getPicId());
        return convertView;
    }
    //view所有的类进行封装
    class ViewHolder{
        ImageView iv;
        TextView titleTv,notTv;
        public ViewHolder(View view){
            iv = view.findViewById(R.id.item_info_iv);
            titleTv = view.findViewById(R.id.item_info_tv_title);
            notTv = view.findViewById(R.id.item_info_tv_notmatch);
        }
    }
}
