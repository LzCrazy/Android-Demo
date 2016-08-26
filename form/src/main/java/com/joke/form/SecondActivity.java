package com.joke.form;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       /* tv=(TextView)findViewById(R.id.textView);
        Intent intent=getIntent();
        String str=intent.getStringExtra("id");
        tv.setText(str);*/


        tv = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String str = intent.getStringExtra("id");
        ComponentName com = intent.getComponent();
        String pkgName = com.getPackageName();
        String className = com.getClassName();
        tv.setText(str + "\n" + pkgName + "\n" + className);

    }
}