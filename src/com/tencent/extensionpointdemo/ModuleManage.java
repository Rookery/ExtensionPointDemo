package com.tencent.extensionpointdemo;

import android.content.Context;

/**
 * 负责所有Module的生命周期，该例子中只包含DailyReportModule，添加任意Module需在该地方初始化
 * @author jamiemo
 *
 */
public class ModuleManage {

	private Module mReportModule;
	
	public ModuleManage(Context context){
		mReportModule = new DailyReportModule(context);
	}
	
	public void init(){
		mReportModule.init();
	}
	
	public void destroy(){
		mReportModule.destroy();
	}
}
