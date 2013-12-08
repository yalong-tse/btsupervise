package com.dreaming.btsupervise.net;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.util.Log;

public class HttpHelper 
{
	private static final int REQUEST_TIMEOUT = 10000;
	private static final int SO_TIMEOUT = 10000;
	public static String TAG = "HttpHelper";

	private Context context;
	private TaskParams taskParams;

	public HttpHelper(Context paramContext, TaskParams paramTaskParams) 
	{
		this.context = paramContext;
		this.taskParams = paramTaskParams;
	}

	public ResultData get() throws IOException 
	{
		// Log.i(TAG, this.taskParams.url);
		this.taskParams.resultData = new ResultData();
		HttpResponse localHttpResponse = getHttpClient().execute(new HttpGet(this.taskParams.url));
		int i = localHttpResponse.getStatusLine().getStatusCode();
		String str = EntityUtils.toString(localHttpResponse.getEntity(),"utf-8");
		
		Log.i(TAG, "resCode = " + i);
		// Log.i(TAG, "result = " + Tools.decode(str));

		if (i == 200) 
		{
			JsonParser localJsonParser = new JsonParser(this.context,this.taskParams);
			this.taskParams.resultData.result = localJsonParser.parseJson(str);
		}
		
		return this.taskParams.resultData;
	}

	public HttpClient getHttpClient() 
	{
		BasicHttpParams localBasicHttpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
		HttpConnectionParams.setSoTimeout(localBasicHttpParams, 10000);
		return new DefaultHttpClient(localBasicHttpParams);
	}

	public ResultData post() throws IOException 
	{
		Log.i(TAG, this.taskParams.url);
		ResultData localResultData = new ResultData();
		HttpClient localHttpClient = getHttpClient();
		HttpPost localHttpPost = new HttpPost(this.taskParams.url);
		
		if (this.taskParams.taskId != 0)
		{
			localHttpPost.setEntity(new UrlEncodedFormEntity(this.taskParams.getRequestParams(), "utf-8"));
		}
		
		HttpResponse localHttpResponse = localHttpClient.execute(localHttpPost);
		
		int i = localHttpResponse.getStatusLine().getStatusCode();
		
		String str = EntityUtils.toString(localHttpResponse.getEntity(),"utf-8");
		
		Log.i(TAG, "resCode = " + i);
		Log.i(TAG, "result = " + str);
		if (i == 200)
		{
			localResultData.result = new JsonParser(this.context,this.taskParams).parseJson(str);
		}
		
		return localResultData;
	}
}
