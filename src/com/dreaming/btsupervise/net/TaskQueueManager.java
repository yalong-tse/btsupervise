package com.dreaming.btsupervise.net;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskQueueManager
{
  static ArrayList<Task> tasks_running = TaskQueue.tasks_running;
  static LinkedList<Task> tasks_wait = TaskQueue.tasks_wait;

  // ERROR //
  public static boolean add(Task paramTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iload_1
    //   7: ireturn
    //   8: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   18: ifnull +84 -> 102
    //   21: invokestatic 35	com/renzhijian/btc/net/Task:getNameTask	()Ljava/util/HashMap;
    //   24: aload_0
    //   25: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   28: invokevirtual 41	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: ifnull +41 -> 72
    //   34: ldc 43
    //   36: new 45	java/lang/StringBuilder
    //   39: dup
    //   40: aload_0
    //   41: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   44: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: ldc 56
    //   52: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 69	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aload_2
    //   63: monitorexit
    //   64: goto -58 -> 6
    //   67: astore_3
    //   68: aload_2
    //   69: monitorexit
    //   70: aload_3
    //   71: athrow
    //   72: invokestatic 35	com/renzhijian/btc/net/Task:getNameTask	()Ljava/util/HashMap;
    //   75: aload_0
    //   76: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   79: aload_0
    //   80: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   87: aload_0
    //   88: invokevirtual 78	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: invokestatic 81	com/renzhijian/btc/net/TaskQueue:serivesRun	()V
    //   95: aload_2
    //   96: monitorexit
    //   97: iconst_1
    //   98: istore_1
    //   99: goto -93 -> 6
    //   102: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   105: aload_0
    //   106: invokevirtual 78	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   109: pop
    //   110: goto -18 -> 92
    //
    // Exception table:
    //   from	to	target	type
    //   14	70	67	finally
    //   72	110	67	finally
  }

  // ERROR //
  public static boolean addPoll(Task paramTask)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: iload_1
    //   7: ireturn
    //   8: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   18: ifnull +91 -> 109
    //   21: invokestatic 35	com/renzhijian/btc/net/Task:getNameTask	()Ljava/util/HashMap;
    //   24: aload_0
    //   25: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   28: invokevirtual 41	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: ifnull +41 -> 72
    //   34: ldc 43
    //   36: new 45	java/lang/StringBuilder
    //   39: dup
    //   40: aload_0
    //   41: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   44: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokespecial 54	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: ldc 56
    //   52: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 69	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aload_2
    //   63: monitorexit
    //   64: goto -58 -> 6
    //   67: astore_3
    //   68: aload_2
    //   69: monitorexit
    //   70: aload_3
    //   71: athrow
    //   72: invokestatic 35	com/renzhijian/btc/net/Task:getNameTask	()Ljava/util/HashMap;
    //   75: aload_0
    //   76: invokevirtual 31	com/renzhijian/btc/net/Task:getSingletonName	()Ljava/lang/String;
    //   79: aload_0
    //   80: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   87: aload_0
    //   88: invokevirtual 85	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   95: aload_0
    //   96: invokevirtual 89	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   99: invokestatic 81	com/renzhijian/btc/net/TaskQueue:serivesRun	()V
    //   102: aload_2
    //   103: monitorexit
    //   104: iconst_1
    //   105: istore_1
    //   106: goto -100 -> 6
    //   109: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   112: aload_0
    //   113: invokevirtual 85	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   116: pop
    //   117: getstatic 17	com/renzhijian/btc/net/TaskQueueManager:tasks_wait	Ljava/util/LinkedList;
    //   120: aload_0
    //   121: invokevirtual 89	java/util/LinkedList:addFirst	(Ljava/lang/Object;)V
    //   124: goto -25 -> 99
    //
    // Exception table:
    //   from	to	target	type
    //   14	70	67	finally
    //   72	124	67	finally
  }

  public static int getThreadCurrentNum()
  {
    return tasks_running.size();
  }

  public static boolean haveRunThread()
  {
    if ((tasks_running.size() <= 0) && (tasks_wait.size() <= 0));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public static void remove(Task paramTask)
  {
    paramTask.setWithout();
  }

  public static void setThreadMaxNum(int paramInt)
  {
    if (paramInt <= 0)
      TaskQueue.ThreadMaxNum = 1;
    while (true)
    {
      return;
      if (paramInt > 10)
        TaskQueue.ThreadMaxNum = 10;
      else
        TaskQueue.ThreadMaxNum = paramInt;
    }
  }
}

