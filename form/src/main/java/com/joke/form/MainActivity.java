package com.joke.form;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)findViewById(R.id.compont);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent();
                String s="test componet";
                intent.putExtra("id",s);
                intent.setClass(MainActivity.this,SecondActivity.class);
                startActivity(intent);*/

                Intent intent = new Intent();
                ComponentName com = new ComponentName(
                        "com.joke.form",
                        "com.joke.form.SecondActivity");
                intent.setComponent(com);
                String s = "This is a Test.";
                intent.putExtra("id", s);
                startActivity(intent);
            }
        });
    }
}
