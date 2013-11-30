package com.dreaming.btsupervise.net;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.message.BasicNameValuePair;

public class TaskParams
{
  public Map<Object, Object> mapParams = new HashMap();
  public int result;
  public ResultData resultData;
  public String singletonName;
  public int taskId;
  public String url;

  public List<BasicNameValuePair> getRequestParams()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.mapParams.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localLinkedList;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Log.i("TaskParams", localEntry.getKey() + ":" + localEntry.getValue());
      //localLinkedList.add(new BasicNameValuePair(localEntry.getKey(), localEntry.getValue()));
    }
  }
}

