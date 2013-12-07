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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
