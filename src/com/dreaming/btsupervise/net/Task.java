package com.dreaming.btsupervise.net;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.dreaming.btsupervise.db.BtcService;

public abstract class Task
  implements Runnable
{
  static final int ERROR = -1;
  static final int FINSH = 1;
  static final int TREATEDING = 2;
  static final int UNTREATED = 0;
  static final int WITHOUT = 3;
  private static HashMap<String, Task> nameTasks = new HashMap();
  protected Context context;
  String debug = getClass().getSimpleName();
  protected Handler handler;
  protected OnFinishListen onFinishListen;
  protected OnProgressListen onProgressListen;
  protected OnStartListen onStartListen;
  protected OnSystemFinishListen onSystemFinishListen;
  protected OnSystemStartListen onSystemStartListen;
  protected Object result;
  protected String singletonName;
  int status = 0;
  protected Object tag;
  protected int taskId;
  protected TaskParams taskParams;
  protected Thread thread;

  protected Task(Context paramContext, Handler paramHandler, TaskParams paramTaskParams)
  {
    this.handler = paramHandler;
    this.context = paramContext;
    this.taskParams = paramTaskParams;
    this.singletonName = paramTaskParams.singletonName;
    this.taskId = paramTaskParams.taskId;
  }

  protected Task(TaskViewHolder paramTaskViewHolder, TaskParams paramTaskParams)
  {
    this.handler = paramTaskViewHolder.getActivityHandler();
    this.context = paramTaskViewHolder.getContext();
    this.taskParams = paramTaskParams;
    this.singletonName = paramTaskParams.singletonName;
    this.taskId = paramTaskParams.taskId;
  }

  public static HashMap<String, Task> getNameTask()
  {
    return nameTasks;
  }

  public final Object Execute()
  {
	  String paramString= "比特币中国";
	  ServerMethod sm = new ServerMethod();
	  Log.d("TEST","qianjina");
	  JSONObject paramJSONObject = null;
	  BtcService localBtcService = new BtcService(this.context);
	  Log.d("TEST","qianjinb");
	  //Btc localBtc = new Btc();
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
		  // paramJSONObject = new JSONObject(paramString);
			
			Log.d("TEST","qianjinf");
			//this.taskParams.resultData.btc = localBtc;
	//		JSONObject localJSONObject = paramJSONObject.getJSONObject("ticker");
	//		localBtc.high = localJSONObject.getDouble("high");
	//		localBtc.low = localJSONObject.getDouble("low");
	//		localBtc.vol = localJSONObject.getDouble("vol");
	//		localBtc.last = localJSONObject.getDouble("last");
	//		localBtc.sell = localJSONObject.getDouble("sell");
	//		localBtc.buy = localJSONObject.getDouble("buy");
	//		Log.d("TEST","qianjin"+localBtc.buy);
	//		Log.d("TEST","qianjin"+localBtc.high);
	//		Log.d("TEST","qianjin"+localBtc.low);
	//		Log.d("TEST","qianjin"+localBtc.vol);
	//		Log.d("TEST","qianjin"+localBtc.last);
	//		Log.d("TEST","qianjin"+localBtc.sell);
	//		Log.d("TEST","qianjin"+localBtc.buy);
			// TODO Auto-generated catch block
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if (this.sharedPrefs.getBoolean("show比特币中国", false))
//		{
//			//localBtcService.saveOrUpdate(localBtc);
//		}
//		else
//		{
//			localBtcService.deleteByName("比特币中国");
//		}	
	  return null;
  }
  
  public HttpClient getHttpClient()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
    return new DefaultHttpClient(localBasicHttpParams);
  }
//  public final Object Execute()
//  {
//    if (this.onStartListen != null)
//      this.onStartListen.onStart(this.taskId);
//    if (this.onSystemStartListen != null)
//      this.onSystemStartListen.onSystemStart(this.taskId);
//    this.status = 2;
//    Object localObject = cacheData(this.taskParams);
//    this.result = localObject;
//    if (localObject == null)
//      this.result = obtainData(this.result, this.taskParams);
//    if (this.status != 3)
//    {
//      if (this.handler != null)
//        this.handler.obtainMessage(this.taskId, this.result).sendToTarget();
//      if (this.onFinishListen != null)
//        this.onFinishListen.OnFinish(this.taskId, this.result);
//    }
//    if (this.onSystemFinishListen != null)
//      this.onSystemFinishListen.OnSystemFinish(this.taskId, this.result, this);
//    this.status = 1;
//    return this.result;
//  }

  public void cacheClear()
  {
    if (this.taskParams != null)
      this.taskParams = null;
    if (this.onStartListen != null)
      this.onStartListen = null;
    if (this.onProgressListen != null)
      this.onProgressListen = null;
    if (this.onFinishListen != null)
      this.onFinishListen = null;
    if (this.onSystemStartListen != null)
      this.onSystemStartListen = null;
    if (this.onSystemFinishListen != null)
      this.onSystemFinishListen = null;
    if (this.handler != null)
      this.handler = null;
    if (this.result != null)
      this.result = null;
    if (this.singletonName != null)
      this.singletonName = null;
    if (this.tag != null)
      this.tag = null;
    if (this.thread != null)
      this.thread = null;
    if (this.context != null)
      this.context = null;
  }

  public abstract Object cacheData(TaskParams paramTaskParams);

  public Handler getHandler()
  {
    return this.handler;
  }

  public OnFinishListen getOnFinishListen()
  {
    return this.onFinishListen;
  }

  public OnProgressListen getOnProgressListen()
  {
    return this.onProgressListen;
  }

  public OnStartListen getOnStartListen()
  {
    return this.onStartListen;
  }

  public OnSystemFinishListen getOnSystemFinishListen()
  {
    return this.onSystemFinishListen;
  }

  public OnSystemStartListen getOnSystemStartListen()
  {
    return this.onSystemStartListen;
  }

  public Object getParameter()
  {
    return this.taskParams;
  }

  public Object getResult()
  {
    return this.result;
  }

  public String getSingletonName()
  {
    return this.singletonName;
  }

  public int getStatus()
  {
    return this.status;
  }

  public Object getTag()
  {
    return this.tag;
  }

  public int getTaskID()
  {
    return this.taskId;
  }

  public Thread getThread()
  {
    return this.thread;
  }

  public abstract Object obtainData(Object paramObject, TaskParams paramTaskParams);

  public void run()
  {
    Execute();
  }

  public void setHandler(Handler paramHandler)
  {
    this.handler = paramHandler;
  }

  public void setOnFinishListen(OnFinishListen paramOnFinishListen)
  {
    this.onFinishListen = paramOnFinishListen;
  }

  public void setOnProgressListen(OnProgressListen paramOnProgressListen)
  {
    this.onProgressListen = paramOnProgressListen;
  }

  public void setOnStartListen(OnStartListen paramOnStartListen)
  {
    this.onStartListen = paramOnStartListen;
  }

  public void setOnSystemFinishListen(OnSystemFinishListen paramOnSystemFinishListen)
  {
    this.onSystemFinishListen = paramOnSystemFinishListen;
  }

  public void setParameter(TaskParams paramTaskParams)
  {
    this.taskParams = paramTaskParams;
  }

  public void setResult(Object paramObject)
  {
    this.result = paramObject;
  }

  public void setSingletonName(String paramString)
  {
    this.singletonName = paramString;
  }

  public void setStatus(int paramInt)
  {
    this.status = paramInt;
  }

  public void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }

  public void setTaskID(int paramInt)
  {
    this.taskId = paramInt;
  }

  public void setWithout()
  {
    this.status = 3;
  }

  public abstract void shutDownExecute();

  public void threadRun()
  {
    this.thread = new Thread(this);
    this.thread.start();
  }

  public static abstract interface OnFinishListen
  {
    public abstract Boolean OnFinish(int paramInt, Object paramObject);
  }

  public static abstract interface OnProgressListen
  {
    public abstract void onProgress(int paramInt1, int paramInt2);
  }

  public static abstract interface OnStartListen
  {
    public abstract void onStart(int paramInt);
  }

  public static abstract interface OnSystemFinishListen
  {
    public abstract Boolean OnSystemFinish(int paramInt, Object paramObject, Task paramTask);
  }

  public static abstract interface OnSystemStartListen
  {
    public abstract void onSystemStart(int paramInt);
  }
}

/* Location:           C:\Users\Administrator\Desktop\classes_dex2jar\
 * Qualified Name:     com.renzhijian.btc.net.Task
 * JD-Core Version:    0.6.2
 */