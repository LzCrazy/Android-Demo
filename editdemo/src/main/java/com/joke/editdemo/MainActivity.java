package com.joke.editdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Spinner spn;
    private EditText edt;
    private Button btnSubmit;
    //用于保存数据的List
    private List<String> list = new ArrayList<>();
    //Spinner的适配器
    private ArrayAdapter<String> adapter;
    //保存从Spinner拿到的值
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //初始化
        setViews();
        //监听
        setListeners();
        //适配器
        setAdapter();
    }
    private void setAdapter(){
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //设置适配器
        spn.setAdapter(adapter);
    }

    private void setViews(){
        edt = (EditText) findViewById(R.id.edt_text);
        spn = (Spinner) findViewById(R.id.spn);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        tv=(TextView)findViewById(R.id.textView);
    }
    private void setListeners(){
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //获取在EditText中输入的值
                String etText = edt.getText().toString();
                //将EditText的值添加到List中
                list.add(etText);
                edt.setText("");
            }
        });
        spn.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                tv.setText("您选择的是："+ adapter.getItem(position));
                /* 将mySpinner 显示*/
                parent.setVisibility(View.VISIBLE);


               /* Toast.makeText(MainActivity.this,"开始执行了",Toast.LENGTH_LONG).show();
                //拿到被选择项的值
//                str = (String) spn.getSelectedItem();
                String str=parent.getItemAtPosition(position).toString();
                //将提取的值设置到EditText中
                // edt.setText(str);
                tv.setText(str);
                Toast.makeText(MainActivity.this, "你点击的是:"+str, Toast.LENGTH_LONG).show();*/
            }
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

}


