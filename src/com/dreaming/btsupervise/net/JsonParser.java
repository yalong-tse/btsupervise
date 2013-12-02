package com.dreaming.btsupervise.net;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;

import com.dreaming.btsupervise.beans.Btc;
import com.dreaming.btsupervise.beans.Trade;
import com.dreaming.btsupervise.beans.Trust;
import com.dreaming.btsupervise.db.BtcService;

public class JsonParser 
{
	private static final int MAX_NUM = 60;
	private Context context;
	private SharedPreferences sharedPrefs;
	private TaskParams taskParams;

	public JsonParser(Context paramContext, TaskParams paramTaskParams) {
		this.context = paramContext;
		this.taskParams = paramTaskParams;
		this.sharedPrefs = paramContext.getSharedPreferences("iyiyun_map", 0);
	}

	
	private int parseBtcchina(JSONObject paramJSONObject) throws JSONException 
	{
		BtcService localBtcService = new BtcService(this.context);
		Btc localBtc = new Btc(this.sharedPrefs.getInt("order比特币中国", 1),"比特币中国", 1);
		this.taskParams.resultData.btc = localBtc;
		JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
		localBtc.high = localJSONObject.getDouble("high");
		localBtc.low = localJSONObject.getDouble("low");
		localBtc.vol = localJSONObject.getDouble("vol");
		localBtc.last = localJSONObject.getDouble("last");
		localBtc.sell = localJSONObject.getDouble("sell");
		localBtc.buy = localJSONObject.getDouble("buy");
		
		if (this.sharedPrefs.getBoolean("show比特币中国", false))
		{
			localBtcService.saveOrUpdate(localBtc);
		}
		else
		{
			localBtcService.deleteByName("比特币中国");
		}	
		return 1;
	}

	// private void parseBtcchinaDeep(JSONObject paramJSONObject)
	// throws JSONException
	// {
	// JSONArray localJSONArray1 = paramJSONObject.getJSONArray("bids");
	// ArrayList localArrayList1 = new ArrayList();
	// int i = localJSONArray1.length();
	// if (i > 60)
	// i = 60;
	// double d = 0.0D;
	// int j = 0;
	// JSONArray localJSONArray3;
	// ArrayList localArrayList2;
	// int k=0;
	// int m=0;
	// if (j >= i)
	// {
	// this.taskParams.resultData.buys = localArrayList1;
	// localJSONArray3 = paramJSONObject.getJSONArray("asks");
	// localArrayList2 = new ArrayList();
	// k = localJSONArray3.length();
	// m = 0;
	// if (k > 60)
	// m = k - 60;
	// }
	// for (int n = k - 1; ; n--)
	// {
	// if (n < m)
	// {
	// this.taskParams.resultData.maxTrust = d;
	// this.taskParams.resultData.sells = localArrayList2;
	// return;
	// JSONArray localJSONArray2 = localJSONArray1.getJSONArray(j);
	// Trust localTrust1 = new Trust();
	// localTrust1.price = localJSONArray2.getDouble(0);
	// localTrust1.amount = localJSONArray2.getDouble(1);
	// localArrayList1.add(localTrust1);
	// if (localTrust1.amount > d)
	// d = localTrust1.amount;
	// j++;
	// break;
	// }
	// JSONArray localJSONArray4 = localJSONArray3.getJSONArray(n);
	// Trust localTrust2 = new Trust();
	// localTrust2.price = localJSONArray4.getDouble(0);
	// localTrust2.amount = localJSONArray4.getDouble(1);
	// localArrayList2.add(localTrust2);
	// if (localTrust2.amount > d)
	// d = localTrust2.amount;
	// }
	// }

	
	
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
	 * 统一的解析JSON的入口，不同的网站调用不同的解析方法
	 * */
	public int parseJson(String paramString) {
		int i = 0;
		while (true) {
			try {
				switch (this.taskParams.taskId) {
				case 100:
					i = parseBtcchina(new JSONObject(paramString));
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