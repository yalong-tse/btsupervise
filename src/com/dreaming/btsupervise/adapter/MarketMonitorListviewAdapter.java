package com.dreaming.btsupervise.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


/**
 * 
 * 监控市场的界面ListView 的Adapter
 * 
 * 
 * */
public class MarketMonitorListviewAdapter extends BaseAdapter {

	private Context context;
	private List<Map<String,Object>> listItems;
	private LayoutInflater listContainer;
	
	
	public MarketMonitorListviewAdapter(Context context,List<Map<String,Object>> listItems)
	{
		this.context = context;
		this.listItems = listItems;
		
		// 创建视图容器并且设置上下文
		this.listContainer = LayoutInflater.from(context);
		
		
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertview, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
