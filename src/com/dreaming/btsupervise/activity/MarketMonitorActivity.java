package com.dreaming.btsupervise.activity;

import com.dreaming.btsupervise.R;
import com.dreaming.btsupervise.R.layout;
import com.dreaming.btsupervise.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MarketMonitorActivity extends Activity {
	
	private ListView listview = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_market_monitor);
		
		listview = (ListView) findViewById(R.id.list_market_listview);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.market_monitor, menu);
		return true;
	}

}
