package com.tencent.extensionpointdemo;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * 
 * @author jamiemo
 *
 */
public abstract class MessageType {
	public static final int TYPE_DAILY_REPORT = 0;
	
	abstract public int getType();
	abstract public Bitmap getIcon();
	abstract public String getTitle();
	abstract public String getSummary();
	abstract public String getTime();
	abstract public void performAction(Context context);
}
