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
import com.dreaming.btsupervise.beans.Btc;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class GatherTaskService implements Runnable {

	// 持有父亲的 mHandler
	private Handler mHandler;
	
	// 持有父亲的context
	private Context context;
	
	private boolean isrun = true;
	
	public GatherTaskService(Context $context,Handler $mHandler)
	{
		this.context = $context ; 
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
			getdata();
			//msg.obj = btc;
			msg.sendToTarget();
			try 
			{
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * 此处解析完毕后直接存储到DB 
	 * */
	public void getdata() {
		String paramString;
		JSONObject paramJSONObject = null;
		Btc localBtc = new Btc();
		try 
		{
			TaskParams localTaskParams = new TaskParams();
			localTaskParams.url = "https://data.btcchina.com/data/ticker";
			localTaskParams.singletonName = "btcchina";
			localTaskParams.taskId = 100;
			HttpResponse localHttpResponse = getHttpClient().execute(new HttpGet(localTaskParams.url));
			paramString = EntityUtils.toString(localHttpResponse.getEntity(),"utf-8");
			paramJSONObject = new JSONObject(paramString);
			JSONParser parser = new JSONParser(this.context,localTaskParams);
			parser.parseBtcchina(paramJSONObject);
			
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		} 
		catch (ClientProtocolException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public HttpClient getHttpClient() 
	{
		BasicHttpParams localBasicHttpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
		HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
		return new DefaultHttpClient(localBasicHttpParams);
	}

}
