package com.dreaming.btsupervise.net;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.dreaming.btsupervise.beans.Btc;
import com.dreaming.btsupervise.beans.Trade;
import com.dreaming.btsupervise.db.BtcService;
import com.dreaming.btsupervise.utils.GlobalConstants;

public class JSONParser 
{
	private static final int MAX_NUM = 60;
	private Context context;
	private SharedPreferences sharedPrefs;
	private TaskParams taskParams;

	public JSONParser(Context paramContext, TaskParams paramTaskParams) {
		this.context = paramContext;
		this.taskParams = paramTaskParams;
		
		this.sharedPrefs = context.getSharedPreferences(GlobalConstants.PREFERENCE_NAME, GlobalConstants.MODE);
	}

	
	public Boolean parseBtcchina(JSONObject paramJSONObject) throws JSONException 
	{
		Boolean result = false;
		BtcService localBtcService = new BtcService(this.context);
		Btc localBtc = new Btc(this.sharedPrefs.getInt("order比特币中国", 1),"比特币中国", 1);
		
		Log.d("test",localBtc.name + "");
		
		//this.taskParams.resultData.btc = localBtc;
		
		JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
		localBtc.high = localJSONObject.getDouble("high");
		localBtc.low = localJSONObject.getDouble("low");
		localBtc.vol = localJSONObject.getDouble("vol");
		localBtc.last = localJSONObject.getDouble("last");
		localBtc.sell = localJSONObject.getDouble("sell");
		localBtc.buy = localJSONObject.getDouble("buy");
		
		Log.d("test",localBtc.name + "");
		
		// 直接存储到数据库中 
		if (this.sharedPrefs.getBoolean("show比特币中国", false))
		{
			localBtcService.saveOrUpdate(localBtc);
			result = true;
		}
		else
		{
			localBtcService.deleteByName("比特币中国");
			result = true;
		}
		return result;
	}
	
	public boolean parseBitstamp(JSONObject paramJSONObject)throws JSONException
	  {
		Log.d("qianjin", "111111");
		
	    BtcService localBtcService = new BtcService(this.context);
	    Btc localBtc = new Btc(this.sharedPrefs.getInt("orderBitstamp", 1), "Bitstamp", 2);
	    Log.d("qianjin", ""+paramJSONObject.getDouble("high"));
	    Log.d("qianjin", ""+paramJSONObject.getDouble("low"));
	    Log.d("qianjin", ""+paramJSONObject.getDouble("volume"));
	    Log.d("qianjin", ""+paramJSONObject.getDouble("last"));
	    Log.d("qianjin", ""+paramJSONObject.getDouble("ask"));
	    Log.d("qianjin", ""+paramJSONObject.getDouble("bid"));
	    
	    localBtc.high = paramJSONObject.getDouble("high");
	    localBtc.low = paramJSONObject.getDouble("low");
	    localBtc.vol = paramJSONObject.getDouble("volume");
	    localBtc.last = paramJSONObject.getDouble("last");
	    localBtc.sell = paramJSONObject.getDouble("ask");
	    localBtc.buy = paramJSONObject.getDouble("bid");
	    if (this.sharedPrefs.getBoolean("showBitstamp", true))
	    {
	    	localBtcService.saveOrUpdate(localBtc);
	    }
	    else
	    {
	    	localBtcService.deleteByName("Bitstamp");
	    }
	    return true;
	  }
	
	 public boolean parseOkCoin(JSONObject paramJSONObject)
	    throws JSONException
	  {
		BtcService localBtcService = new BtcService(this.context);
	    JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
	    Btc localBtc = new Btc(this.sharedPrefs.getInt("orderOkCoin", 1), "OkCoin", 1);
	    localBtc.high = localJSONObject.getDouble("high");
	    localBtc.low = localJSONObject.getDouble("low");
	    localBtc.vol = localJSONObject.getDouble("vol");
	    localBtc.last = localJSONObject.getDouble("last");
	    localBtc.sell = localJSONObject.getDouble("sell");
	    localBtc.buy = localJSONObject.getDouble("buy");
		if (this.sharedPrefs.getBoolean("showOkCoin", true))
	    {
	    	localBtcService.saveOrUpdate(localBtc);
	    }
	    else
	    {
	    	localBtcService.deleteByName("OkCoin");
	    }
	    return true;
	 }
	 
	 public boolean parseMtgox(JSONObject paramJSONObject)
	    throws JSONException
	  {
	    BtcService localBtcService = new BtcService(this.context);
	    Btc localBtc = new Btc(this.sharedPrefs.getInt("orderMt.Gox", 1), "Mt.Gox", 2);
	    JSONObject localJSONObject = paramJSONObject.getJSONObject("data");
	    localBtc.high = localJSONObject.getJSONObject("high").getDouble("value");
	    localBtc.low = localJSONObject.getJSONObject("low").getDouble("value");
	    localBtc.vol = localJSONObject.getJSONObject("vol").getDouble("value");
	    localBtc.last = localJSONObject.getJSONObject("last").getDouble("value");
	    localBtc.buy = localJSONObject.getJSONObject("buy").getDouble("value");
	    localBtc.sell = localJSONObject.getJSONObject("sell").getDouble("value");
	    if (this.sharedPrefs.getBoolean("showMt.Gox", true))
	    {
	    	localBtcService.saveOrUpdate(localBtc);
	    }
	    else
	    {
	    	localBtcService.deleteByName("Mt.Gox");
	    }
	    return true;
	  }
	 
	 public boolean parseHuobi(JSONObject paramJSONObject)
	    throws JSONException
	  {
		BtcService localBtcService = new BtcService(this.context);
	    JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
	    Btc localBtc = new Btc(this.sharedPrefs.getInt("order火币网", 1), "火币网", 1);
	    localBtc.high = localJSONObject.getDouble("high");
	    localBtc.low = localJSONObject.getDouble("low");
	    localBtc.vol = localJSONObject.getDouble("vol");
	    localBtc.last = localJSONObject.getDouble("last");
	    localBtc.sell = localJSONObject.getDouble("sell");
	    localBtc.buy = localJSONObject.getDouble("buy");
	    if (this.sharedPrefs.getBoolean("show火币网", true))
	      localBtcService.saveOrUpdate(localBtc);
	    else
	    {
	      localBtcService.deleteByName("火币网");
	    }
	    return true;
	  }
	 
	 public boolean parseBtctrade(JSONObject paramJSONObject)
	    throws JSONException
	  {
		Log.d("qianjin","qianjin++++"+paramJSONObject.getDouble("high"));
	    BtcService localBtcService = new BtcService(this.context);
	    Btc localBtc = new Btc(this.sharedPrefs.getInt("orderbtcTrade", 1), "btcTrade", 1);
	    localBtc.high = paramJSONObject.getDouble("high");	
	    localBtc.low = paramJSONObject.getDouble("low");
	    localBtc.vol = paramJSONObject.getDouble("vol");
	    localBtc.last = paramJSONObject.getDouble("last");
	    localBtc.sell = paramJSONObject.getDouble("sell");
	    localBtc.buy = paramJSONObject.getDouble("buy");
	    if (this.sharedPrefs.getBoolean("showbtcTrade", true))
	      localBtcService.saveOrUpdate(localBtc);
	    else
	    {
	      localBtcService.deleteByName("btcTrade");
	    }
	    return true;
	  }
	
	public Boolean parse796(JSONObject paramJSONObject) throws JSONException
	  {
	    BtcService localBtcService = new BtcService(this.context);
	    Btc localBtc = new Btc(this.sharedPrefs.getInt("order796期货", 1), "796期货", 2);
	    JSONObject localJSONObject;
		localJSONObject = paramJSONObject.getJSONObject("return");
	    localBtc.high = localJSONObject.getDouble("high");
	    localBtc.low = localJSONObject.getDouble("low");
	    localBtc.vol = localJSONObject.getDouble("vol");
	    localBtc.last = localJSONObject.getDouble("last");
	    localBtc.sell = localJSONObject.getDouble("sell");
	    localBtc.buy = localJSONObject.getDouble("buy");
	    if (this.sharedPrefs.getBoolean("show796期货", true))
	      localBtcService.saveOrUpdate(localBtc);
	    else
	      localBtcService.deleteByName("796期货");
	    return true;
	  }
	
	 
	 
	private void parseBtcchinaTrade(JSONArray paramJSONArray)
			throws JSONException {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
				"HH:mm:ss");
		ArrayList localArrayList = new ArrayList();
		int i = paramJSONArray.length();
		int j = 0;
		if (i > 60)
			j = i - 60;
		double d = 0.0D;
		for (int k = i - 1;; k--) {
			if (k < j) {
				this.taskParams.resultData.maxTrade = d;
				this.taskParams.resultData.trades = localArrayList;
				return;
			}
			JSONObject localJSONObject = paramJSONArray.getJSONObject(k);
			Trade localTrade = new Trade();
			localTrade.time = localSimpleDateFormat.format(new Date(
					1000L * localJSONObject.getLong("date")));
			localTrade.price = localJSONObject.getDouble("price");
			localTrade.amount = localJSONObject.getDouble("amount");
			localTrade.tid = localJSONObject.getInt("tid");
			localTrade.type = localJSONObject.getString("type");
			localArrayList.add(localTrade);
			if (localTrade.amount > d)
				d = localTrade.amount;
		}
	}
	
	/**
	 * 
	 * 统一的解析JSON的入口，不同的网站调用不同的解析方法
	 * 
	 * */
	public int parseJson(String paramString) {
		int i = 0;
		while (true) {
			try {
				switch (this.taskParams.taskId) {
				case 100:
					//i = parseBtcchina(new JSONObject(paramString));
					// parseBtcchinaDeep(new JSONArray(paramString));
					parseBtcchinaTrade(new JSONArray(paramString));
					JSONObject localJSONObject8 = new JSONObject(paramString);
					i = 1;
					break;
				case 305:
				}
			} catch (JSONException localJSONException) {
				localJSONException.printStackTrace();
				break;
			}
		}
		return i;
	}
}