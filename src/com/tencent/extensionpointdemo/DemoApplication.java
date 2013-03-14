package com.tencent.extensionpointdemo;

import android.app.Application;

public class DemoApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		ModuleManage moduleManage = new ModuleManage(getApplicationContext());
		moduleManage.init();
	}
}
