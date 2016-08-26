package com.joke.serviceresolve;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    /**
     * 启动服务
     */
    public void start(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startActivity(intent);

    }

    /**
     * 绑定服务
     */
    public void bind(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startActivity(intent);

    }

    /**
     * 解除绑定
     */
    public void unBind(View view) {
        unbindService(conn);

    }

    /**
     * 停止服务
     */
    public void stop(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        stopService(intent);
    }
}
