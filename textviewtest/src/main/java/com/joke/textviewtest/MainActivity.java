package com.joke.textviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //显示数据
    private TextView tv;
    //添加Button
    private Button bt;
    //下拉Spinner
    private Spinner sp;
    //输入文本
    private EditText et;
    //String
    String str;
    //list
    ArrayList<String>list;
    //spinner适配器
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        setViews();
        //设置监听
        setListener();
        //设置适配器
        setAdapter();

    }
    private void setViews(){
        tv=(TextView)findViewById(R.id.tv);
        bt=(Button)findViewById(R.id.button);
        sp=(Spinner)findViewById(R.id.sp);
        tv=(TextView)findViewById(R.id.textView);
    }

    private void setListener(){
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str=et.getText().toString();
                list.add(str);
                et.setText("");
            }
        });
        sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                str=(String)sp.getSelectedItem();
                tv.setText(str);

            }
        });

    }
    private void setAdapter(){
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        sp.setAdapter(adapter);
    }



}
