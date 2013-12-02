package com.dreaming.btsupervise.net;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class NetworkProber
{
  public static boolean is3G(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 0));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static boolean isGpsEnabled(Context paramContext)
  {
    return ((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps");
  }

  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool = false;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
        {
          NetworkInfo.State localState1 = localNetworkInfo.getState();
          NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
          if (localState1 == localState2)
            bool = true;
        }
      }
      return bool;
    }
    catch (Exception localException)
    {
      return bool;
    }
  }

  public static boolean isWifi(Context paramContext)
  {
    int i = 1;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == i))
    	return true;
    else
    	return false;
  }

  public static boolean isWifiEnabled(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (((localConnectivityManager.getActiveNetworkInfo() == null) || (localConnectivityManager.getActiveNetworkInfo().getState() != NetworkInfo.State.CONNECTED)) && (localTelephonyManager.getNetworkType() != 3));
    for (boolean bool = false; ; bool = true)
      return bool;
  }
}

/* Location:           C:\Users\Administrator\Desktop\classes_dex2jar\
 * Qualified Name:     com.renzhijian.btc.net.NetworkProber
 * JD-Core Version:    0.6.2
 */