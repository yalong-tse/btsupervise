package com.dreaming.btsupervise.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dreaming.btsupervise.R;
import com.dreaming.btsupervise.R.layout;
import com.dreaming.btsupervise.R.menu;
import com.dreaming.btsupervise.adapter.MarketMonitorListviewAdapter;
import com.dreaming.btsupervise.beans.BTCList;
import com.dreaming.btsupervise.beans.Btc;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;

public class MarketMonitorActivity extends Activity {
	
	private ListView listview = null;
	
	private List<Map<String,Object>> listitems;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_market_monitor);
		
		
		listview = (ListView) findViewById(R.id.list_market_listview);
		listitems = getListItems();
		Log.d("TEST","11111111111111111");
		MarketMonitorListviewAdapter adapter = new MarketMonitorListviewAdapter(this,listitems);
		listview.setAdapter(adapter);
		Log.d("TEST","22222222222222222222222");
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.market_monitor, menu);
		return true;
	}

	
	private List<Map<String,Object>> getListItems()
	{
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		BTCList.getInstance().test();
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
}
