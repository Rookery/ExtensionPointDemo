package com.tencent.extensionpointdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;


/**
 * 具体的module类，实现Module的init和destroy方法
 * @author jamiemo
 *
 */
public class DailyReportModule implements Module{
	
	private Context mContext;
	
	public DailyReportModule(Context context){
		mContext = context;
	}
	
	MessageType messageType = new MessageType() {
		
		@Override
		public int getType() {
			return MessageType.TYPE_DAILY_REPORT;
		}
		
		@Override
		public String getTitle() {
			return "title";
		}
		
		@Override
		public String getTime() {
			return "time";
		}
		
		@Override
		public String getSummary() {
			return "summary";
		}
		
		@Override
		public Bitmap getIcon() {
			return BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_launcher);
		}

		@Override
		public void performAction(Context context) {
			Toast.makeText(context, "Item Clicked", Toast.LENGTH_LONG).show();
		}
	};
	
	@Override
	public void init(){
		MessageTypeExtensionPoint.getInstance().register(messageType);
	}
	
	@Override
	public void destroy(){
		MessageTypeExtensionPoint.getInstance().unregister(messageType);
	}
}
