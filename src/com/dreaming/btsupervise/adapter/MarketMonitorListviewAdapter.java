package com.dreaming.btsupervise.adapter;

import java.util.List;
import java.util.Map;

import com.dreaming.btsupervise.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


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
	
	
	/**
	 * 内部类
	 * */
	public class MonitorItemView
	{
		TextView tv_name;
		TextView tv_lastprice;
		TextView tv_buyprice;
		TextView tv_sellprice;
		TextView tv_amount;
	}
	
	
	public MarketMonitorListviewAdapter(Context context,List<Map<String,Object>> listItems)
	{
		this.context = context;
		this.listItems = listItems;
		
		// 创建视图容器并且设置上下文
		this.listContainer = LayoutInflater.from(context);
		
		Log.d("ADAPTER", "in the adapter create");
		
	}
	
	
	
	@Override
	public int getCount() {
		return listItems.size();
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
		
		
		MonitorItemView itemviews = null;
		if(convertview==null)
		{
			itemviews = new MonitorItemView();
			convertview =  this.listContainer.inflate(R.layout.market_listview_content, null);
			itemviews.tv_name = (TextView) convertview.findViewById(R.id.platform_name);
			itemviews.tv_lastprice = (TextView) convertview.findViewById(R.id.lastprice);
			itemviews.tv_buyprice = (TextView) convertview.findViewById(R.id.buyprice);
			itemviews.tv_sellprice = (TextView) convertview.findViewById(R.id.sellprice);
			itemviews.tv_amount = (TextView) convertview.findViewById(R.id.exchangeamount);
			convertview.setTag(itemviews);
		}
		else
		{
			itemviews = (MonitorItemView) convertview.getTag();
		}
		itemviews.tv_name.setText(listItems.get(position).get("name").toString());
		itemviews.tv_amount.setText(listItems.get(position).get("vol").toString());
		itemviews.tv_buyprice.setText(listItems.get(position).get("buy").toString());
		itemviews.tv_sellprice.setText(listItems.get(position).get("sell").toString());
		itemviews.tv_lastprice.setText(listItems.get(position).get("last").toString());
		return convertview;
	}

}
