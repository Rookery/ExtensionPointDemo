package com.tencent.extensionpointdemo;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
		MyAdapter adapter = new MyAdapter(this);
		getListView().setAdapter(adapter);
		getListView().setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				MessageType msgType = (MessageType)arg1.getTag();
				if (msgType != null) {
					msgType.performAction(MainActivity.this);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}


class MyAdapter extends BaseAdapter{
	Context mContext;

	public MyAdapter(Context context){
		mContext = context;
	}
	
	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//这里的type假设是TYPE_DAILY_REPORT，实际中可能是从db中获取
		int type = MessageType.TYPE_DAILY_REPORT;
		MessageType messageType = MessageTypeExtensionPoint.getInstance().getMessageType(type);
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.message_list_item, null);
		ImageView icon = (ImageView)view.findViewById(R.id.icon);
		TextView title = (TextView)view.findViewById(R.id.title);
		TextView summary = (TextView)view.findViewById(R.id.summary);
		TextView time = (TextView)view.findViewById(R.id.time);
		icon.setImageBitmap(messageType.getIcon());
		summary.setText(messageType.getSummary());
		title.setText(messageType.getTitle());
		time.setText(messageType.getTime());
		view.setTag(messageType);
		return view;
	}
	
}
