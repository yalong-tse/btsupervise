package com.dreaming.btsupervise.net;

import java.io.IOException;

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

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

import com.dreaming.btsupervise.beans.Btc;
import com.dreaming.btsupervise.db.BtcService;

public class ServiceBtc extends Service {

	private static final String TAG = "MyService";
	public static final String ACTION = "com.lql.service.ServiceDemo";
	private Context context;
	private SharedPreferences sharedPrefs;
	private TaskParams taskParams;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Service#onBind(android.content.Intent)
	 */
	@Override
	public IBinder onBind(Intent arg0) {
		Log.d("TEST", "qianjinService6");
		return null;
	}

	@Override
	public void onCreate() {
		Log.v(TAG, "onCreate");
		Log.d("TEST", "qianjinService7");
		// if (mediaPlayer == null) {
		// mediaPlayer = MediaPlayer.create(this, R.raw.tmp);
		// mediaPlayer.setLooping(false);
		// }
	}

	@Override
	public void onDestroy() {
		Log.v(TAG, "onDestroy");
		Log.d("TEST", "qianjinService8");
		// if (mediaPlayer != null) {
		// mediaPlayer.stop();
		// mediaPlayer.release();
		// }
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.v(TAG, "onStart");
		Log.d("TEST", "qianjinService9");
		String paramString = "比特币中国";
		ServerMethod sm = new ServerMethod();
		Log.d("TEST", "qianjina");
		JSONObject paramJSONObject = null;
		BtcService localBtcService = new BtcService(this.context);
		Log.d("TEST", "qianjinb");
		Btc localBtc = new Btc();
		Log.d("TEST", "qianjinc" + paramString);
		try {
			TaskParams localTaskParams = new TaskParams();
			localTaskParams.url = "https://data.btcchina.com/data/ticker";
			localTaskParams.singletonName = "比特币中国";
			localTaskParams.taskId = 100;
			
			Log.d("TEST", "qianjind" + localTaskParams.url);
			
			HttpResponse localHttpResponse = getHttpClient().execute(new HttpGet(localTaskParams.url));
			
			paramString = EntityUtils.toString(localHttpResponse.getEntity(),"utf-8");
			// Log.i(TAG, "result = " + Tools.decode(paramString));
			
			
			Log.d("TEST", "qianjine" + paramString);
			paramJSONObject = new JSONObject(paramString);

			Log.d("TEST", "qianjinf");
			// this.taskParams.resultData.btc = localBtc;
			JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
			localBtc.high = localJSONObject.getDouble("high");
			localBtc.low = localJSONObject.getDouble("low");
			localBtc.vol = localJSONObject.getDouble("vol");
			localBtc.last = localJSONObject.getDouble("last");
			localBtc.sell = localJSONObject.getDouble("sell");
			localBtc.buy = localJSONObject.getDouble("buy");
			Log.d("TEST", "qianjin" + localBtc.buy);
			Log.d("TEST", "qianjin" + localBtc.high);
			Log.d("TEST", "qianjin" + localBtc.low);
			Log.d("TEST", "qianjin" + localBtc.vol);
			Log.d("TEST", "qianjin" + localBtc.last);
			Log.d("TEST", "qianjin" + localBtc.sell);
			Log.d("TEST", "qianjin" + localBtc.buy);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (this.sharedPrefs.getBoolean("show比特币中国", false)) {
			// localBtcService.saveOrUpdate(localBtc);
		} else {
			localBtcService.deleteByName("比特币中国");
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
