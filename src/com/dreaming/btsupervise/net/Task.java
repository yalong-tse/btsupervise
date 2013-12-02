package com.dreaming.btsupervise.net;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import java.util.HashMap;

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
    if (this.onStartListen != null)
      this.onStartListen.onStart(this.taskId);
    if (this.onSystemStartListen != null)
      this.onSystemStartListen.onSystemStart(this.taskId);
    this.status = 2;
    Object localObject = cacheData(this.taskParams);
    this.result = localObject;
    if (localObject == null)
      this.result = obtainData(this.result, this.taskParams);
    if (this.status != 3)
    {
      if (this.handler != null)
        this.handler.obtainMessage(this.taskId, this.result).sendToTarget();
      if (this.onFinishListen != null)
        this.onFinishListen.OnFinish(this.taskId, this.result);
    }
    if (this.onSystemFinishListen != null)
      this.onSystemFinishListen.OnSystemFinish(this.taskId, this.result, this);
    this.status = 1;
    return this.result;
  }

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