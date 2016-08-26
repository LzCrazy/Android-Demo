package com.bitmap.szlizb.recycleviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Item>itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        String title = "你懂的";
        itemList = new ArrayList<>();

            itemList.add(new Item(title, R.drawable.h2));
            itemList.add(new Item(title, R.drawable.h3));
            itemList.add(new Item(title, R.drawable.h4));
            itemList.add(new Item(title, R.drawable.h2));
            itemList.add(new Item(title, R.drawable.h3));
            itemList.add(new Item(title, R.drawable.h4));
            itemList.add(new Item(title, R.drawable.h2));
            itemList.add(new Item(title, R.drawable.h3));
            itemList.add(new Item(title, R.drawable.h4));
            itemList.add(new Item(title, R.drawable.h2));
            itemList.add(new Item(title, R.drawable.h3));
            itemList.add(new Item(title, R.drawable.h4));
            itemList.add(new Item(title, R.drawable.h2));
            itemList.add(new Item(title, R.drawable.h3));










        RecyclerView list = (RecyclerView) findViewById(R.id.listview);
         //LinearLayoutManager mg = new LinearLayoutManager(this);

        //水平或垂直摆放，可以不用 HorizontalScrollView
        //mg.setOrientation(LinearLayoutManager.HORIZONTAL);

        //GridLayoutManager mg = new GridLayoutManager(this,3);//格子摆放


        //交错性的摆放，有点win8那种格子风格，最好使用CardView作为item，有边框和圆角
        StaggeredGridLayoutManager mg = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);


        list.setLayoutManager(mg);
        MyRecycleAdapter adapter = new MyRecycleAdapter(this, itemList);
        list.setAdapter(adapter);
    }
}
