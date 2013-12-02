package com.dreaming.btsupervise.net;

import android.content.Context;
import android.os.Handler;

import com.dreaming.btsupervise.activity.TaskActivity;

public class TaskViewHolder
{
  private Handler activityHandler;//need modify qianjin
  protected Context context;
  private TaskObserver taskObservable;

  public TaskViewHolder(TaskActivity paramTaskActivity)
  {
    this.context = paramTaskActivity;
    this.taskObservable = paramTaskActivity;
  }

  public Handler getActivityHandler()
  {
    return this.activityHandler;
  }

  public Context getContext()
  {
    return this.context;
  }

  public void setActivityHandler(Handler paramHandler)
  {
    this.activityHandler = paramHandler;
  }

  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
}