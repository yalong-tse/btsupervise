package com.dreaming.btsupervise.net;

import com.dreaming.btsupervise.activity.TaskActivity;

public class ServerMethod
{
  public static void addDeepServerMethod(TaskActivity paramTaskActivity, String paramString)
  {
    if (paramString.equals("Mt.Gox"))
    {
      TaskParams localTaskParams33 = TaskParamsManager.getInstance().getMtgoxDeepUrlParams();
      TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams33));
      TaskParams localTaskParams34 = TaskParamsManager.getInstance().getMtgoxTradeUrlParams();
      TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams34));
    }
    while (true)
    {
      if (paramString.equals("Bitstamp"))
      {
        TaskParams localTaskParams31 = TaskParamsManager.getInstance().getBitstampDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams31));
        TaskParams localTaskParams32 = TaskParamsManager.getInstance().getBitstampTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams32));
      }
      else if (paramString.equals("btc-e"))
      {
        TaskParams localTaskParams29 = TaskParamsManager.getInstance().getBtceDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams29));
        TaskParams localTaskParams30 = TaskParamsManager.getInstance().getBtceTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams30));
      }
      else if (paramString.equals("796期货"))
      {
        TaskParams localTaskParams27 = TaskParamsManager.getInstance().get796DeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams27));
        TaskParams localTaskParams28 = TaskParamsManager.getInstance().get796TradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams28));
      }
      else if (paramString.equals("比特币中国"))
      {
        TaskParams localTaskParams25 = TaskParamsManager.getInstance().getBtcchinaDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams25));
        TaskParams localTaskParams26 = TaskParamsManager.getInstance().getBtcchinaTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams26));
      }
      else if (paramString.equals("btcTrade"))
      {
        TaskParams localTaskParams23 = TaskParamsManager.getInstance().getBtctradeDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams23));
        TaskParams localTaskParams24 = TaskParamsManager.getInstance().getBtctradeTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams24));
      }
      else if (paramString.equals("FXBTC"))
      {
        TaskParams localTaskParams21 = TaskParamsManager.getInstance().getFxbtcDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams21));
        TaskParams localTaskParams22 = TaskParamsManager.getInstance().getFxbtcTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams22));
      }
      else if (paramString.equals("OkCoin"))
      {
        TaskParams localTaskParams19 = TaskParamsManager.getInstance().getOkcoinDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams19));
        TaskParams localTaskParams20 = TaskParamsManager.getInstance().getOkcoinTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams20));
      }
      else if (paramString.equals("BTC100"))
      {
        TaskParams localTaskParams17 = TaskParamsManager.getInstance().getBtc100DeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams17));
        TaskParams localTaskParams18 = TaskParamsManager.getInstance().getBtc100TradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams18));
      }
      else if (paramString.equals("火币网"))
      {
        TaskParams localTaskParams15 = TaskParamsManager.getInstance().getHuobiDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams15));
        TaskParams localTaskParams16 = TaskParamsManager.getInstance().getHuobiTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams16));
      }
      else if (paramString.equals("比特儿Bter"))
      {
        TaskParams localTaskParams13 = TaskParamsManager.getInstance().getBterDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams13));
        TaskParams localTaskParams14 = TaskParamsManager.getInstance().getBterTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams14));
      }
      else if (paramString.equals("人盟比特币"))
      {
        TaskParams localTaskParams11 = TaskParamsManager.getInstance().getRmbtbDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams11));
        TaskParams localTaskParams12 = TaskParamsManager.getInstance().getRmbtbTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams12));
      }
      else if (paramString.equals("GoXBTC"))
      {
        TaskParams localTaskParams9 = TaskParamsManager.getInstance().getGoxbtcDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams9));
        TaskParams localTaskParams10 = TaskParamsManager.getInstance().getGoxbtcTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams10));
      }
      else if (paramString.equals("btc-e(ltc)"))
      {
        TaskParams localTaskParams7 = TaskParamsManager.getInstance().getBtceLtcDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams7));
        TaskParams localTaskParams8 = TaskParamsManager.getInstance().getBtceLtcTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams8));
      }
      else if (paramString.equals("FXBTC(ltc)"))
      {
        TaskParams localTaskParams5 = TaskParamsManager.getInstance().getFxbtcLtcDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams5));
        TaskParams localTaskParams6 = TaskParamsManager.getInstance().getFxbtcLtcTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams6));
      }
      else if (paramString.equals("btcTrade(ltc)"))
      {
        TaskParams localTaskParams3 = TaskParamsManager.getInstance().getBtctradeLtcDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams3));
        TaskParams localTaskParams4 = TaskParamsManager.getInstance().getBtctradeLtcTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams4));
      }
      else if (paramString.equals("OkCoin(ltc)"))
      {
        TaskParams localTaskParams1 = TaskParamsManager.getInstance().getOkcoinLtcDeepUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams1));
        TaskParams localTaskParams2 = TaskParamsManager.getInstance().getOkcoinLtcTradeUrlParams();
        TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams2));
      }
    }
  }

  public static void addServerMethod(TaskActivity paramTaskActivity, String paramString)
  {
	   if (paramString.equals("Mt.Gox"))
	   {
	      TaskParams localTaskParams17 = TaskParamsManager.getInstance().getMtgoxParams();
	      TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams17));
	   }
	   else if (paramString.equals("Bitstamp"))
	  {
	    TaskParams localTaskParams16 = TaskParamsManager.getInstance().getBitstampParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams16));
	  }
	  else if (paramString.equals("btc-e"))
	  {
	    TaskParams localTaskParams15 = TaskParamsManager.getInstance().getBtceUrlParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams15));
	  }
	  else if (paramString.equals("796期货"))
	  {
	    TaskParams localTaskParams14 = TaskParamsManager.getInstance().get796UrlParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams14));
	  }
	  else if (paramString.equals("比特币中国"))
	  {
	    TaskParams localTaskParams13 = TaskParamsManager.getInstance().getBtcchinaParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams13));
	  }
	  else if (paramString.equals("btcTrade"))
	  {
	    TaskParams localTaskParams12 = TaskParamsManager.getInstance().getBtctradeParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams12));
	  }
	  else if (paramString.equals("FXBTC"))
	  {
	    TaskParams localTaskParams11 = TaskParamsManager.getInstance().getFxbtcParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams11));
	  }
	  else if (paramString.equals("OkCoin"))
	  {
	    TaskParams localTaskParams10 = TaskParamsManager.getInstance().getOkcoinParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams10));
	  }
	  else if (paramString.equals("BTC100"))
	  {
	    TaskParams localTaskParams9 = TaskParamsManager.getInstance().getBtc100Params();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams9));
	  }
	  else if (paramString.equals("火币网"))
	  {
	    TaskParams localTaskParams8 = TaskParamsManager.getInstance().getHuobiParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams8));
	  }
	  else if (paramString.equals("比特儿Bter"))
	  {
	    TaskParams localTaskParams7 = TaskParamsManager.getInstance().getBterParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams7));
	  }
	  else if (paramString.equals("人盟比特币"))
	  {
	    TaskParams localTaskParams6 = TaskParamsManager.getInstance().getRmbtbParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams6));
	  }
	  else if (paramString.equals("GoXBTC"))
	  {
	    TaskParams localTaskParams5 = TaskParamsManager.getInstance().getGoxbtcParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams5));
	  }
	  else if (paramString.equals("btc-e(ltc)"))
	  {
	    TaskParams localTaskParams4 = TaskParamsManager.getInstance().getBtceLtcParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams4));
	  }
	  else if (paramString.equals("FXBTC(ltc)"))
	  {
	    TaskParams localTaskParams3 = TaskParamsManager.getInstance().getFxbtcLtcParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams3));
	  }
	  else if (paramString.equals("btcTrade(ltc)"))
	  {
	    TaskParams localTaskParams2 = TaskParamsManager.getInstance().getBtctradeLtcParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams2));
	  }
	  else if (paramString.equals("OkCoin(ltc)"))
	  {
	    TaskParams localTaskParams1 = TaskParamsManager.getInstance().getOkcoinLtcParams();
	    TaskQueueManager.add(new HttpRequestTask(new TaskViewHolder(paramTaskActivity), localTaskParams1));
	  }
  }
}