package com.example.ts.news.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.ts.news.Bean.PinBuBean;
import com.example.ts.news.R;
import com.example.ts.news.Utils.CommonUtils;

import java.util.List;

public class SearchLeftAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> groupDatas; //表示分组的列表
    List<List<PinBuBean.ResultBean>> childDatas;//将每组对应的子类列表存放到这个集合之中
    LayoutInflater inflater;
    int type;//拼音和部首都用此适配器 所以通过这个属性 进行类型区分
    int selectGroupPos = 0,selectChildPos = 0;//表示被选中的组的位置，和被选中的组的item的位置

    public void setSelectGroupPos(int selectGroupPos) {
        this.selectGroupPos = selectGroupPos;
    }

    public void setSelectChildPos(int selectChildPos) {
        this.selectChildPos = selectChildPos;
    }

    public SearchLeftAdapter(Context context, List<String> groupDatas, List<List<PinBuBean.ResultBean>> childDatas,int type) {
        this.context = context;
        this.groupDatas = groupDatas;
        this.childDatas = childDatas;
        this.type= type;
        inflater = LayoutInflater.from(context);//初始化布局加载器
    }
    //获得分组的数量
    @Override
    public int getGroupCount() {
        return groupDatas.size();
    }
    //获取指定分组中有几个item
    @Override
    public int getChildrenCount(int i) {
        return childDatas.get(i).size();
    }
    //获取分组指定位置的数据
    @Override
    public Object getGroup(int i) {
        return groupDatas.get(i);
    }
    //给出第几组 第几个 求出指定位置的对象
    @Override
    public Object getChild(int i, int i1) {
        return childDatas.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_exlv_group,null);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (GroupViewHolder) convertView.getTag();
        }
        //获取指定位置的数据
        String word = groupDatas.get(groupPosition);
        holder.groupTv.setText(word);
        //选中位置颜色会发生改变 和其他布局颜色不同 所以判断一下是否选中位置
        if(selectGroupPos == groupPosition){
            convertView.setBackgroundColor(Color.BLACK);
            holder.groupTv.setTextColor(Color.RED);
        }else{
            convertView.setBackgroundResource(R.color.grey_f3f3f3);
            holder.groupTv.setTextColor(Color.BLACK);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean idLastChild, View convertView, ViewGroup parent) {
        ChileViewHolder holder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_exlv_child,null);
            holder = new ChileViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ChileViewHolder) convertView.getTag();
        }
        PinBuBean.ResultBean bean = childDatas.get(groupPosition).get(childPosition);
        if(type == CommonUtils.TYPE_PINYIN){
            holder.chileTv.setText(bean.getPinyin());
        }else{
            holder.chileTv.setText(bean.getBushou());
        }
        //设置改变选中的颜色
        if(selectGroupPos == groupPosition&& selectChildPos==childPosition){
            convertView.setBackgroundColor(Color.WHITE);
            holder.chileTv.setTextColor(Color.RED);
        }else{
            convertView.setBackgroundResource(R.color.grey_f3f3f3);
            holder.chileTv.setTextColor(Color.BLACK);
        }
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
    class GroupViewHolder{
        TextView groupTv;
        public GroupViewHolder(View view){
            groupTv = view.findViewById(R.id.item_group_tv);

        }
    }
    class ChileViewHolder{
        TextView chileTv;
        public ChileViewHolder(View view){
            chileTv = view.findViewById(R.id.item_child_tv);

        }
    }
}
