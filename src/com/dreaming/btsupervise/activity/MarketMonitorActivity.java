package com.dreaming.btsupervise.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

import com.dreaming.btsupervise.R;
import com.dreaming.btsupervise.adapter.MarketMonitorListviewAdapter;
import com.dreaming.btsupervise.beans.BTCList;
import com.dreaming.btsupervise.beans.Btc;
import com.dreaming.btsupervise.net.ServiceBtc;

public class MarketMonitorActivity extends Activity {
	
	private ListView listview = null;
	
	private List<Map<String,Object>> listitems;
	
	private static final String TAG = "MarketMonitorActivity";  
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_market_monitor);
		
		
		//refreshui();
		//启动服务
        Intent intent = new Intent("com.dreaming.btsupervise.net.MainService");
        bindService(new Intent(ServiceBtc.ACTION), conn, BIND_AUTO_CREATE);  
        startService(intent);
        stopService(intent);
	}
	
	ServiceConnection conn = new ServiceConnection() {  
        public void onServiceConnected(ComponentName name, IBinder service) {  
            Log.v(TAG, "onServiceConnected");  
        }  
        public void onServiceDisconnected(ComponentName name) {  
            Log.v(TAG, "onServiceDisconnected");  
        }  
    };  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.market_monitor, menu);
		return true;
	}

	
	private List<Map<String,Object>> getListItems()
	{
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		//BTCList.getInstance().setBtcs(btcs);
		Log.d("TEST",BTCList.getInstance().getBtcs().size() + "===========");
		for(Btc btc: BTCList.getInstance().getBtcs())
		{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", btc.name);
			map.put("high", btc.high);
			map.put("low",btc.low);
			map.put("buy", btc.buy);
			map.put("sell", btc.sell);
			map.put("vol", btc.vol);
			map.put("last", btc.last);
			result.add(map);
		}
		
		return result;
		
	}
	
	
	private void refreshui()
	{
		listview = (ListView) findViewById(R.id.list_market_listview);
		listitems = getListItems();
		MarketMonitorListviewAdapter adapter = new MarketMonitorListviewAdapter(this,listitems);
		listview.setAdapter(adapter);
		
	}
	
	
}
