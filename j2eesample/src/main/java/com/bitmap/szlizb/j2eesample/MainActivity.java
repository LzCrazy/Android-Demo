package com.bitmap.szlizb.j2eesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //GET方式访问j2ee服务器
        String strurl="http://172.16.3.17:8080/AndroidJ2eeServlet/ServletSample?param=helloWorld";
        URL url=null;
        try{
            url=new URL(strurl);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            InputStreamReader in=new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(in);
            String result="";
            String readLine="";
            while ((readLine=bufferedReader.readLine())!=null){
                result += readLine;
            }
            in.close();
            urlConnection.disconnect();
            TextView textView=(TextView)this.findViewById(R.id.result);
        }catch (Exception e){
            e.printStackTrace();
        }
/*


        //Post请求
        */
/**
         * post传输方式不再URL里面传递，解决了get传输量小，容易改动的缺点
         *//*

        String strUrl="";
        URL url1=null;
        try{
            url1=new URL(strUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
            //设置输入流采用字节流
            httpURLConnection.setDoInput(true);
            //设置输出流
            httpURLConnection.setDoOutput(true);
            //请求方式
            httpURLConnection.setRequestMethod("POST");
            //设置缓存
            httpURLConnection.setUseCaches(false);
            //设置meta参数
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-urlencoded");
            //设置字符
            httpURLConnection.setRequestProperty("Charset", "utf-8");

            //链接服务器发送消息
            httpURLConnection.connect();
            DataOutputStream dop=new DataOutputStream(httpURLConnection.getOutputStream());
            //发送参数
            dop.writeBytes("param="+ URLEncoder.encode("啥：我滴个去","utf-8"));
            //发送，清空缓存
            dop.flush();
            //关闭
            dop.close();


            //接收工作
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String results = "";
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                results +=line;
            }
            bufferedReader.close();
            //关闭链接
            httpURLConnection.disconnect();

            //讲接收的数据显示出来
            TextView textView=(TextView)this.findViewById(R.id.result);
            textView.setText(URLEncoder.encode(results, "utf-8"));

        }catch (Exception e){

        }
*/

    }
}
