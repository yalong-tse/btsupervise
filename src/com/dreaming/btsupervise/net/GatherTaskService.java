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

import com.dreaming.btsupervise.activity.MainActivity;
import com.dreaming.btsupervise.activity.MarketMonitorActivity;
import com.dreaming.btsupervise.beans.Btc;

import android.content.Context;
import android.content.Intent;
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
			TaskParams localTaskParams = new TaskParams();
			localTaskParams = TaskParamsManager.getInstance().getBtcchinaParams();
			getdata(localTaskParams);
			localTaskParams = TaskParamsManager.getInstance().getBitstampParams();
			getdata(localTaskParams);
			localTaskParams = TaskParamsManager.getInstance().getOkcoinParams();
			getdata(localTaskParams);
			localTaskParams = TaskParamsManager.getInstance().getMtgoxParams();
			getdata(localTaskParams);
			localTaskParams = TaskParamsManager.getInstance().getHuobiParams();
			getdata(localTaskParams);
//			localTaskParams = TaskParamsManager.getInstance().getBtctradeParams();
//			getdata(localTaskParams);
			localTaskParams = TaskParamsManager.getInstance().get796UrlParams();
			getdata(localTaskParams);
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
	public void getdata(TaskParams localTaskParams) {
		String paramString;
		JSONObject paramJSONObject = null;
		Btc localBtc = new Btc();
		try 
		{
			HttpResponse localHttpResponse = getHttpClient().execute(new HttpGet(localTaskParams.url));
			paramString = EntityUtils.toString(localHttpResponse.getEntity(),"utf-8");
			Log.d("test", paramString);
			paramJSONObject = new JSONObject(paramString);
			JsonParser parser = new JsonParser(this.context,localTaskParams);
			switch (localTaskParams.taskId) 
			{
			case 100:
				parser.parseBtcchina(paramJSONObject);
				break;
			case 109:
				parser.parse796(paramJSONObject);
				break;
			case 106:
				parser.parseBitstamp(paramJSONObject);
				break;
			case 104:
				parser.parseOkCoin(paramJSONObject);
				break;
			case 105:
				parser.parseMtgox(paramJSONObject);
				break;
			case 110:
				parser.parseHuobi(paramJSONObject);
				break;
			case 101:
				parser.parseBtctrade(paramJSONObject);
				break;
			}
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
