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

public class BeitieAdapter extends BaseAdapter {
    Context context;
    List<CalliBean> mDatas;

    public BeitieAdapter(Context context, List<CalliBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1.声明ViewHolder
        ViewHolder holder = null;
        //2.判断是否有复用的view，如果没有就创建
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foodgrid,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //获取指定位置的数据
        CalliBean calliBean = mDatas.get(position);
        holder.iv.setImageResource(calliBean.getPicId());
        holder.tv.setText(calliBean.getTitle());
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
        public ViewHolder(View view){
            iv = view.findViewById(R.id.item_grid_iv);
            tv = view.findViewById(R.id.item_grid_tv);
        }
    }
}
