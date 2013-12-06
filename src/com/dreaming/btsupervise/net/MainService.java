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

public class MainService extends Service implements Runnable {

	 public static List<Activity> allActivity =new ArrayList<Activity>();
	 public static List<Item> allItem =new ArrayList<Item>();
	 
	 
	 
	 public boolean isrun =true;
	 
	 public static Activity getActivityByName(String name)
	 {
		  for(Activity ac:allActivity){
			   if(ac.getClass().getName().indexOf(name)>=0){
			    return ac;
			   }
		  }
		  return null;
	 }

	 //启动线程
	 @Override
	 public void onCreate()
	 {
		 //getResources().
		super.onCreate();
		  Thread t =new Thread(this);
		  t.start();
	 }


	 @Override
	 public void onDestroy() {
		 super.onDestroy();
	 }

	 public static void newItem(Item Item) {
		 allItem.add(Item);
	 }

	 
	//执行任务，业务逻辑调用，执行完后移出任务
	public void doItem(Item Item) {
	  Log.d("qianjin", "doItem1");
	  Message mess = handler.obtainMessage();
	  System.out.println("#####----doItem-----");
	  Log.d("qianjin", "doItem2");
	  
	  getdata();
	  
	  Log.d("qianjin", "doItem3");
	  handler.sendMessage(mess); //发送消息
	  Log.d("qianjin", "doItem4");
	  allItem.remove(Item);      //执行任务结束，移出任务
	  Log.d("qianjin", "doItem5");
	 }

	//侦听任务
	@Override
    public void run() {
	  // TODO Auto-generated method stub
	while (isrun) {
	   Log.d("qianjin", "doItema");
	   Item lastItem = new Item();
//	   if (allItem.size() >0) {
//	    lastItem = allItem.get(0);
	    doItem(lastItem);
//	   }
	   try{Thread.sleep(1000);}catch(Exception e){};
	  }
	 }

	 @Override
	 public IBinder onBind(Intent arg0) {
	  // TODO Auto-generated method stub
		 return null;
	 }
	 
	 //更新UI
	private Handler handler =new Handler(){

		@Override
	    public void handleMessage(Message msg) {
		   // TODO Auto-generated method stub
			  super.handleMessage(msg);
			  System.out.println("Handler");
			  switch (msg.what) {
			  case 0:
				  
				  //IWeiboActivity ia = (IWeiboActivity)getActivityByName("Login");
				  //getActivityByName("Main");
				  //ia.refresh(msg.what,msg.obj);
				  

				  break;
			  	  
			  case 1:
				  //IWeiboActivity ia2 = (IWeiboActivity)getActivityByName("Home");
				  //ia2.refresh(new Integer(Home.REFRESH_WEIBO),msg.obj);
				  break;
			  }
		  }
		  
		 };
		 
		 
   public void getdata()
   {
	   String paramString= "比特币中国";
		  ServerMethod sm = new ServerMethod();
		  Log.d("TEST","qianjina");
		  JSONObject paramJSONObject = null;
		  Log.d("TEST","qianjinb");
		  Btc localBtc = new Btc();
		  Log.d("TEST","qianjinc"+paramString);
		  try {
			   TaskParams localTaskParams = new TaskParams();
			    localTaskParams.url = "https://data.btcchina.com/data/ticker";
			    localTaskParams.singletonName = "比特币中国";
			    localTaskParams.taskId = 100;
			    Log.d("TEST","qianjind"+localTaskParams.url);
			   HttpResponse localHttpResponse = getHttpClient().execute(new HttpGet(localTaskParams.url));
			   paramString = EntityUtils.toString(localHttpResponse.getEntity(), "utf-8");
			   //Log.i(TAG, "result = " + Tools.decode(paramString));
			   Log.d("TEST","qianjine"+paramString);
			   paramJSONObject = new JSONObject(paramString);
				
				Log.d("TEST","qianjinf");
//				this.taskParams.resultData.btc = localBtc;
				JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
				localBtc.high = localJSONObject.getDouble("high");
				localBtc.low = localJSONObject.getDouble("low");
				localBtc.vol = localJSONObject.getDouble("vol");
				localBtc.last = localJSONObject.getDouble("last");
				localBtc.sell = localJSONObject.getDouble("sell");
				localBtc.buy = localJSONObject.getDouble("buy");
				Log.d("TEST","qianjin"+localBtc.buy);
				Log.d("TEST","qianjin"+localBtc.high);
				Log.d("TEST","qianjin"+localBtc.low);
				Log.d("TEST","qianjin"+localBtc.vol);
				Log.d("TEST","qianjin"+localBtc.last);
				Log.d("TEST","qianjin"+localBtc.sell);
				Log.d("TEST","qianjin"+localBtc.buy);
				List<Btc> list = BTCList.getInstance().getBtcs();
				list.add(localBtc);
		  	}
			catch (JSONException e) {
					 
				// TODO Auto-generated catch block
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			if (this.sharedPrefs.getBoolean("show比特币中国", false))
//			{
//				//localBtcService.saveOrUpdate(localBtc);
//			}
//			else
//			{
//				localBtcService.deleteByName("比特币中国");
//			}
	   
   }
   
   public HttpClient getHttpClient()
   {
     BasicHttpParams localBasicHttpParams = new BasicHttpParams();
     HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
     HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
     return new DefaultHttpClient(localBasicHttpParams);
   }

}
