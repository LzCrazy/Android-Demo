package com.joke.editdemo;
import android.app.Application;


public class MyApplication extends Application{

	private static MyApplication app;
	public static MyApplication getInstance(){
		return (MyApplication) app;
		
	}
	@Override
	public void onCreate() {
		super.onCreate();
		app = this;
	}
	
	
}
