package com.dreaming.btsupervise.net;

import android.content.Context;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.apache.http.client.ClientProtocolException;

public class HttpRequestTask extends Task
{
  public static String TAG = "HttpRequestTask";

  public HttpRequestTask(Context paramContext, Handler paramHandler, TaskParams paramTaskParams)
  {
    super(paramContext, paramHandler, paramTaskParams);
  }

  public HttpRequestTask(TaskViewHolder paramTaskViewHolder, TaskParams paramTaskParams)
  {
    super(paramTaskViewHolder, paramTaskParams);
  }

  public Object cacheData(TaskParams paramTaskParams)
  {
    return null;
  }

  public ResultData httpRequest(TaskParams paramTaskParams)
  {
    Object localObject = new ResultData();
    try
    {
      isThreadShouDouwn();
      if (!NetworkProber.isNetworkAvailable(this.context))
        throw new ClientProtocolException();
      HttpHelper localHttpHelper = new HttpHelper(this.context, paramTaskParams);
      Process.setThreadPriority(10);
      ResultData localResultData = localHttpHelper.get();
      return localResultData;
    }
    catch (ClientProtocolException localClientProtocolException)
    {
      ;
      while (true)
      {
    	  Log.e(TAG, "-------------------ClientProtocolException----------------------");
          ((ResultData)localObject).result = -3;
          localClientProtocolException.printStackTrace();
          Log.e(TAG, "-------------------ClientProtocolException----------------------");
      }
    }
//    catch (SocketTimeoutException localSocketTimeoutException)
//    {
//      while (true)
//      {
//        Log.e(TAG, "------------------SocketTimeoutException-----------------------");
//        ((ResultData)localObject).result = -2;
//        localSocketTimeoutException.printStackTrace();
//        Log.e(TAG, "------------------SocketTimeoutException-----------------------");
//      }
//    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Log.e(TAG, "-------------------IOException----------------------");
        ((ResultData)localObject).result = -3;
        localIOException.printStackTrace();
        Log.e(TAG, "-------------------IOException----------------------");
      }
    }
  }

  public void isThreadShouDouwn()
    throws ClientProtocolException
  {
    if ((Thread.interrupted()) || (getStatus() == 3))
      throw new ClientProtocolException();
  }

  public Object obtainData(Object paramObject, TaskParams paramTaskParams)
  {
	ResultData localResultData = httpRequest(paramTaskParams);
    Log.i(TAG, "result:" + localResultData.result);
    localResultData.taskParams = paramTaskParams;
    return localResultData;
    
  }

  public void shutDownExecute()
  {
    try
    {
      if (this.status == 2)
        Log.i(this.debug, "编号" + this.taskId + "任务中断");
      setWithout();
      if (this.thread != null)
        this.thread.interrupt();
      return;
    }
    catch (Exception localException)
    {
      return;
    }
  }
}

