package com.dreaming.btsupervise.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dreaming.btsupervise.R;
import com.dreaming.btsupervise.R.drawable;
import com.dreaming.btsupervise.R.id;
import com.dreaming.btsupervise.R.layout;
import com.dreaming.btsupervise.R.menu;
import com.dreaming.btsupervise.utils.GlobalConstants;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	// Gridview 中的菜单
	private List<HashMap<String, Object>> menuitems = new ArrayList<HashMap<String, Object>>();

	private GridView gridview;

	protected SharedPreferences sharedPrefs;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		gridview = (GridView) findViewById(R.id.main_gridview);

		for (int i = 0; i < GlobalConstants.items.length; i++) {
			//System.out.println("111111111111");
			//Log.d("TEST","111111111");
			//Log.d("test","the i:"+i);
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (i == 0)
				map.put("image", R.drawable.module12);
			else if (i == 1)
				map.put("image", R.drawable.module21);
			else if (i == 2)
				map.put("image", R.drawable.module22);
			else if (i == 3)
				map.put("image", R.drawable.module2);
			else if (i == 4)
				map.put("image", R.drawable.module24);
			else if (i == 5)
				map.put("image", R.drawable.module23);

			map.put("item", GlobalConstants.items[i]);

			menuitems.add(map);
		}

		String[] from = { "image", "item" };
		int[] to = { R.id.main_menuitem_image, R.id.main_menuitem_text };
		SimpleAdapter menuAdapter = new SimpleAdapter(this, menuitems,
				R.layout.main_items, from, to);

		gridview.setAdapter(menuAdapter);

		/**
		 * 点击事件的方法
		 * */
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				switch (arg2) {
				// 大盘走势
				case 0:
					Intent intent_property = new Intent();
					intent_property.setClass(MainActivity.this,
							MarketMonitorActivity.class);
					startActivity(intent_property);
					break;
				//
				case 1:
					break;
				// 资产配置
				case 2:
					break;

				// 理财圈
				case 3:
					break;

				// 个人设置
				case 4:
					break;

				// 网点查询
				case 5:

					break;

				// 每日推荐
				case 6:

					break;
				// 风险测试
				case 7:
					break;
				// 理财计算器
				case 8:
					break;

				}
			}

		});
		
		
		buildingPreference();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	public void buildingPreference()
	{
		this.sharedPrefs = this.getSharedPreferences(GlobalConstants.PREFERENCE_NAME, GlobalConstants.MODE);
		
		if (!this.sharedPrefs.getBoolean("first2", true)) return;
		
		SharedPreferences.Editor localEditor = this.sharedPrefs.edit();
	    localEditor.putBoolean("first2", false);
	    localEditor.putBoolean("showMt.Gox", true);
	    localEditor.putBoolean("show比特币中国", true);
	    localEditor.putBoolean("showOkCoin", true);
	    localEditor.putBoolean("show火币网", true);
	    localEditor.putBoolean("showbtc-e(ltc)", true);
	    localEditor.putBoolean("showFXBTC(ltc)", true);
	    localEditor.putBoolean("showBitstamp", true);
	    
	    // 定义顺序
	    localEditor.putInt("orderMt.Gox", 1);
	    localEditor.putInt("orderBitstamp", 2);
	    localEditor.putInt("orderbtc-e", 3);
	    localEditor.putInt("order796期货", 4);
	    localEditor.putInt("order比特币中国", 5);
	    localEditor.putInt("orderbtcTrade", 6);
	    localEditor.putInt("orderFXBTC", 7);
	    localEditor.putInt("orderOkCoin", 8);
	    localEditor.putInt("orderBTC100", 9);
	    localEditor.putInt("order火币网", 10);
	    localEditor.putInt("order比特儿Bter", 11);
	    localEditor.putInt("order人盟比特币", 12);
	    localEditor.putInt("orderGoXBTC", 13);
	    localEditor.putInt("orderbtc-e(ltc)", 14);
	    localEditor.putInt("orderFXBTC(ltc)", 15);
	    localEditor.putInt("orderbtcTrade(ltc)", 16);
	    localEditor.putInt("orderOkCoin(ltc)", 17);
	    
	    // 定义货币种类
	    localEditor.putInt("kindMt.Gox", 2);
	    localEditor.putInt("kindBitstamp", 2);
	    localEditor.putInt("kindbtc-e", 2);
	    localEditor.putInt("kind796期货", 2);
	    localEditor.putInt("kind比特币中国", 1);
	    localEditor.putInt("kindbtcTrade", 1);
	    localEditor.putInt("kindFXBTC", 1);
	    localEditor.putInt("kindOkCoin", 1);
	    localEditor.putInt("kindBTC100", 1);
	    localEditor.putInt("kind火币网", 1);
	    localEditor.putInt("kind比特儿Bter", 1);
	    localEditor.putInt("kind人盟比特币", 1);
	    localEditor.putInt("kindGoXBTC", 1);
	    localEditor.putInt("kindbtc-e(ltc)", 4);
	    localEditor.putInt("kindFXBTC(ltc)", 3);
	    localEditor.putInt("kindbtcTrade(ltc)", 3);
	    localEditor.putInt("kindOkCoin(ltc)", 3);
	    localEditor.commit();
	    
	}
}
