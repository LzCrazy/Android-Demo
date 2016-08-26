package com.bitmap.szlizb.recycleviewdemo;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * Created by szlizb on 2016/6/21.
 */

public class MyRecycleAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private Activity activity;
    private List<Item> list;

    public MyRecycleAdapter (Activity act, List<Item> list) {
        this.activity = act;
        this.list = list;
    }


    @Override  //绑定一个UI作为Holder 提高性能
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(R.layout.list_base_item,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    //设置数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item item = list.get(position);
        TextView text1 = (TextView) holder.itemView.findViewById(R.id.text) ;
        text1.setText(item.desc);
        ImageView img = (ImageView) holder.itemView.findViewById(R.id.img);
        img.setImageResource(item.imgId);

        //随机摆放
        int ww = 60 + (int)(position * new Random().nextInt(100));
        if (ww > 300) {
            ww = 200;
        }
        img.getLayoutParams().width = ww;
        img.getLayoutParams().height = 50 + (int)(position * new Random().nextInt(50));//随机高宽
        img.setImageResource(item.imgId);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
class MyViewHolder extends RecyclerView.ViewHolder {

    public MyViewHolder(View itemView) {
        super(itemView);
    }
}
