package com.dreaming.btsupervise.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.dreaming.btsupervise.R;
import com.dreaming.btsupervise.adapter.MarketMonitorListviewAdapter;
import com.dreaming.btsupervise.beans.BTCList;
import com.dreaming.btsupervise.beans.Btc;
import com.dreaming.btsupervise.db.BtcService;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

public class GatherTaskService implements Runnable {

	// 持有父亲的 mHandler
	private Handler mHandler;
	
	private boolean isrun = true;
	
	public GatherTaskService(Handler $mHandler)
	{
		this.mHandler = $mHandler;
	}
	
	
	// 获取任务之后就发送消息给主UI线程就可以了。
	
	@Override
	public void run() {
		
		while(isrun)
		{
			Log.d("调试", "开始线程");
			Message msg = mHandler.obtainMessage();
			msg.what = 1;
			Btc btc = getdata();
			msg.obj = btc;
			msg.sendToTarget();
			try 
			{
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Btc getdata() {
		String paramString = "比特币中国";
		JSONObject paramJSONObject = null;
		Btc localBtc = new Btc();
		try 
		{
			TaskParams localTaskParams = new TaskParams();
			localTaskParams.url = "https://data.btcchina.com/data/ticker";
			localTaskParams.singletonName = " btcchina";
			localTaskParams.taskId = 100;
			HttpResponse localHttpResponse = getHttpClient().execute(new HttpGet(localTaskParams.url));
			paramString = EntityUtils.toString(localHttpResponse.getEntity(),"utf-8");
			paramJSONObject = new JSONObject(paramString);

			JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
			localBtc.high = localJSONObject.getDouble("high");
			localBtc.low = localJSONObject.getDouble("low");
			localBtc.vol = localJSONObject.getDouble("vol");
			localBtc.last = localJSONObject.getDouble("last");
			localBtc.sell = localJSONObject.getDouble("sell");
			localBtc.buy = localJSONObject.getDouble("buy");
			localBtc.name = localTaskParams.singletonName;
		} catch (JSONException e) {

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return localBtc;

	}

	public HttpClient getHttpClient() {
		BasicHttpParams localBasicHttpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
		HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
		return new DefaultHttpClient(localBasicHttpParams);
	}

}
